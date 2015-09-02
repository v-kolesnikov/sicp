(ns sicp.chapter01.1-11-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-11 :refer :all]))

(deftest test-f-recursive
  (assert-equal 1 (f-recursive 1))
  (assert-equal 2 (f-recursive 2))
  (assert-equal 3 (f-recursive 3))
  (assert-equal 6 (f-recursive 4))
  (assert-equal 101902 (f-recursive 20)))

(deftest test-f-iterative
  (assert-equal 1 (f-iteraive 1))
  (assert-equal 2 (f-iteraive 2))
  (assert-equal 3 (f-iteraive 3))
  (assert-equal 6 (f-iteraive 4))
  (assert-equal 101902 (f-iteraive 20)))
