(ns sicp.chapter01.1-07-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-07 :refer :all]))

; Book examples
(deftest test-sqrt
  (assert-equal 3.00009155413138 (sqrt 9))
  (assert-equal 11.704699917758145 (sqrt (+ 100 37)))
  (assert-equal 1.7739279023207892 (sqrt (+ (sqrt 2) (sqrt 3))))
  (assert-equal 1000.000369924366 (square (sqrt 1000))))

; Test solution
(deftest test-better-sqrt
  (assert-equal 3.0 (better-sqrt 9))
  (assert-equal 0.02 (better-sqrt 0.0004))
  (assert-equal 1000.0 (square (better-sqrt 1000))))
