(ns sicp.chapter01.1-14-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-14 :refer :all]))

(deftest test-count-change
  (assert-equal 1 (count-change 0))
  (assert-equal 0 (count-change -1))
  (assert-equal 4 (count-change 11))
  (assert-equal 292 (count-change 100)))
