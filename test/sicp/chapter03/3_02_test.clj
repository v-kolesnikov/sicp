(ns sicp.chapter03.3-02-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter03.3-02 :as sicp-3-02]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-make-monitored
  (let [f (sicp-3-02/make-monitored (fn [x] (Math/sqrt x)))]
    (assert-equal 0.0 (f 0))
    (assert-equal 1.0 (f 1))
    (assert-equal 2.0 (f 4))
    (assert-equal 3.0 (f 9))
    (assert-equal 4 (f :how-many-calls?))
    (assert-equal 0 (f :reset-count!))
    (assert-equal 0 (f :how-many-calls?))
    (assert-equal 2.0 (f 4))
    (assert-equal 1 (f :how-many-calls?))))
