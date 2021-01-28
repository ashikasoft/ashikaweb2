(ns ashikaweb2.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [ashikaweb2.core-test]))

(doo-tests 'ashikaweb2.core-test)

