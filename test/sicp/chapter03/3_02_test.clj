(ns sicp.chapter03.3-02-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter03.3-02 :as sicp-3-02]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-make-monitored
  (let [sqrt (sicp-3-02/make-monitored (fn [x] (Math/sqrt x)))]
    (assert-equal 0.0 (sqrt 0))
    (assert-equal 1.0 (sqrt 1))
    (assert-equal 2.0 (sqrt 4))
    (assert-equal 3.0 (sqrt 9))
    (assert-equal 4 (sqrt 'how-many-calls?))))
