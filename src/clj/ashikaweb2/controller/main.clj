(ns ashikaweb2.controller.main
  (:require
   [clojure.string :as string]
   [ring.util.http-response :refer [content-type ok]]
   [ashikasoft.jdict :as jdict]
   [ashikaweb2.view.main :as view.main]))

(defn render [content]
  (->(ok (view.main/render (select-keys content [:results])))
     (content-type "text/html; charset=utf-8")))

(defn lookup [dict {{word :word} :params}]
  (let [term (string/trim word)
        results (if (string/blank? term) [] (jdict/lookup dict term))]
    (render {:results results})))
