(ns ashikaweb2.handler
  (:require
   [ashikaweb2.route.home :refer [home-routes]]
   [ashikasoft.webstack.handler :as webstack.handler]
   [ashikasoft.webstack.middleware :as webstack.middleware]
   [reitit.ring :as ring]
   [integrant.core :as ig]))

(defn app [dict]
  (webstack.middleware/wrap-base
    (identity
     (ring/ring-handler
      (ring/router
        [(home-routes dict)])
      (webstack.handler/common-routes)))))

(defmethod ig/init-key :ashikaweb2/handler [_ {dict :webdict}]
  (app dict))

