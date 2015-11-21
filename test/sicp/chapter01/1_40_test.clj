(ns sicp.chapter01.1-40-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-40 :refer :all]))

(deftest test-newtons-method
  (assert-equal 2.00000000001201 (newtons-method (cubic 4 -19 19 6) 1))
  (assert-equal 2.000000000036784 (newtons-method (cubic 1 0 0 -8) 1)))
