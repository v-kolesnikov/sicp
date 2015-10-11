(ns sicp.chapter01.1-30-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-30 :refer :all]))

(deftest test-sum
  (assert-equal 21 (sum (fn [x] x) 1 inc 6))
  (assert-equal 36 (sum (fn [x] (* x x x)) 1 inc 3)))
