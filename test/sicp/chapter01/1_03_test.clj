(ns sicp.chapter01.1-03-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-03 :refer :all]))

(deftest test-asserts
  (assert-equal (solution 1 2 3) 13)
  (assert-equal (solution 5 2 1) 29)
  (assert-equal (solution (- 2) (- 3) (- 5)) 13))
