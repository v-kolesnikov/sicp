(ns sicp.chapter01.1-46-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.common :refer [round]]
            [sicp.chapter01.1-46 :refer :all]))

(deftest test-sqrt
  (assert-equal 8.0 (round (sqrt 64) 4))
  (assert-equal 16.0 (round (sqrt 256) 4)))

(deftest test-fixed-point
  (assert-equal 1.6180371352785146 (fixed-point #(inc (/ 1 %)) 1.0)))
