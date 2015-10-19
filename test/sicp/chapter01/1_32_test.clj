(ns sicp.chapter01.1-32-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-32 :refer :all]))

(deftest test-accumulate
  (assert-equal 21 (accumulate + 0 identity 1 inc 6))
  (assert-equal 24 (accumulate * 1 identity 1 inc 4)))

(deftest test-accumulate-recursive
  (assert-equal 21 (accumulate-recursive + 0 identity 1 inc 6))
  (assert-equal 24 (accumulate-recursive * 1 identity 1 inc 4)))

(deftest test-sum
  (assert-equal 21 (sum 1 6))
  (assert-equal 55 (sum 1 10)))

(deftest test-product
  (assert-equal 24 (product 1 4))
  (assert-equal 40320 (product 1 8)))
