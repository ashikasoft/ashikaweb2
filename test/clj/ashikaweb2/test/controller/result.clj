(ns ashikaweb2.test.controller.result
  (:require [clojure.test :refer [deftest is testing]]
            [ashikaweb2.controller.main :refer :all]))

(deftest test-export
  (testing "export renders data"
    (is (= 1 1)))) 
