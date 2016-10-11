(ns sicp.chapter03.3-01-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter03.3-01 :as sicp-3-01]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-make-accumulator
  (let [A (sicp-3-01/make-accumulator 5)
        B (sicp-3-01/make-accumulator 7)]
    (assert-equal 15 (A 10))
    (assert-equal 25 (A 10))

    (assert-equal 17 (B 10))
    (assert-equal 27 (B 10))

    (assert-equal 25 (A 0))
    (assert-equal 30 (A 5))

    (assert-equal 27 (B 0))
    (assert-equal 32 (B 5))))
