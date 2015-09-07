(ns sicp.chapter01.1-19-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-19 :refer :all]))

(deftest test-fast-expt
  (assert-equal 0 (fib 0))
  (assert-equal 1 (fib 1))
  (assert-equal 1 (fib 2))
  (assert-equal 21 (fib 8))
  (assert-equal 6765 (fib 20)))
