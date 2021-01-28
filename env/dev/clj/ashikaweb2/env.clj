(ns ashikaweb2.env
  (:require [clojure.tools.logging :as log]
            [ashikaweb2.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[ashikaweb2 started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[ashikaweb2 has shut down successfully]=-"))
   :middleware wrap-dev})
