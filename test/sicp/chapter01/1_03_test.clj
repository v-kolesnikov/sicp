(ns sicp.chapter01.1-03-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-03 :refer :all]))

(deftest test-asserts
  (assert-equal 13 (solution 1 2 3))
  (assert-equal 13 (solution 1 3 2))
  (assert-equal 29 (solution 5 2 1))
  (assert-equal 13 (solution -2 -3 -5)))
