(ns ashikaweb2.test.handler
  (:require [clojure.test :refer [deftest is testing]]
            [ring.mock.request :as ring-request]
            [ashikaweb2.handler :as handler]))

(deftest test-app
  (testing "main route"
    (let [response ((handler/app {}) (ring-request/request :get "/"))]
      (is (= 200 (:status response)))))

  (testing "not-found route"
    (let [response ((handler/app {}) (ring-request/request :get "/invalid"))]
      (is (= 404 (:status response))))))
