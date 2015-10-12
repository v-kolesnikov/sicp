(ns sicp.chapter01.1-31-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-31 :refer :all]))

(deftest test-product
  (assert-equal 24 (product identity 1 inc 4))
  (assert-equal 576 (product #(* % %) 1 inc 4)))

(deftest test-product-recursive
  (assert-equal 24 (product-recursive identity 1 inc 4))
  (assert-equal 576 (product-recursive #(* % %) 1 inc 4)))

(deftest test-factorial
  (assert-equal 1 (factorial 0))
  (assert-equal 1 (factorial 1))
  (assert-equal 24 (factorial 4)))

(deftest test-pi
  (assert-true (> 0.01 (Math/abs (- Math/PI (pi))))))
