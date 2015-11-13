(ns sicp.chapter01.1-36-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-36 :refer :all]))

(deftest test-solution
  (assert-equal 9 (:steps (solution-with-average-damp 2.0)))
  (assert-equal 34 (:steps (solution-without-average-damp 2.0)))
  (assert-equal 4.555537700653076 (:value (solution-with-average-damp 2.0)))
  (assert-equal 4.555532270803653 (:value (solution-without-average-damp 2.0))))
