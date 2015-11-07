(ns sicp.chapter01.1-21-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-21 :refer :all]))

(deftest test-smallest-divisor
  (assert-equal 199 (smallest-divisor 199))
  (assert-equal 1999 (smallest-divisor 1999))
  (assert-equal 7 (smallest-divisor 19999)))
