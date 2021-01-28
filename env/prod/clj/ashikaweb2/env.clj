(ns ashikaweb2.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[ashikaweb2 started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[ashikaweb2 has shut down successfully]=-"))
   :middleware identity})
