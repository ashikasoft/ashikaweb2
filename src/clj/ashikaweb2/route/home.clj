(ns ashikaweb2.route.home
  (:require
    [ashikaweb2.controller.main :as main]
    [ashikasoft.webstack.middleware :as middleware]))

(defn home-routes [dict]
  [""
   {:middleware [middleware/wrap-formats]}
   ["/" main/render]
   ["/lookup" (partial main/lookup dict)]])

