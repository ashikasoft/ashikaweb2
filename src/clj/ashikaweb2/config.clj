(ns ashikaweb2.config
  (:require [ashikaweb2.handler]
            [ashikaweb2.webdict]
            [ashikasoft.webstack.httpd]
            [cprop.core :as cprop]
            [cprop.source :as source]
            [clojure.tools.logging :as log]
            [integrant.core :as ig]))

(defn configure [options]
  "Configure the app dependency map, to be loaded by integrant."
  {:ashikaweb2/env     {:options options}
   :ashikaweb2/handler {:webdict (ig/ref :ashikaweb2/webdict)}
   :ashikaweb2/webdict {:env (ig/ref :ashikaweb2/env)}
   :ashikasoft/httpd    {:env (ig/ref :ashikaweb2/env)
                         :handler (ig/ref :ashikaweb2/handler)}})

(defmethod ig/init-key :ashikaweb2/env [_ {:keys [options]}]
  (cprop/load-config
     :merge
     [options
      (source/from-system-props)
      (source/from-env)]))

(defn stop-deps [system]
  (ig/halt! system)
  (log/info "Stopped components:" (keys system)))

(defn start-deps [options]
  (let [system (ig/init (configure options))]
    (log/info "Started components:" (keys system))
    system))

