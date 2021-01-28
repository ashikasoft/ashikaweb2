(ns ashikaweb2.webdict
  (:require [ashikasoft.jdict :as jdict]
            [integrant.core :as ig]))

(defmethod ig/init-key :ashikaweb2/webdict [_ {:keys [env]}]
  (if-let [data-dir (env :jmdict-assets)]
    (jdict/load-data-dir data-dir)
    (jdict/load-data-resource "public/data")))

