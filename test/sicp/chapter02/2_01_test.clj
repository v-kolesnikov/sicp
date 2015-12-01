(ns sicp.chapter02.2-01-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter02.2-01 :refer :all]))

(deftest test-make-rat
  (assert-equal [1 2] (make-rat 1 2))
  (assert-equal [1 3] (make-rat 2 6))
  (assert-equal [1 4] (make-rat -1 -4))
  (assert-equal [-1 4] (make-rat 1 -4))
  (assert-equal [-1 4] (make-rat -1 4))
  (assert-equal [2 1] (make-rat 2)))

(deftest test-str-rat
  (assert-equal "1/2" (str-rat (make-rat 1 2)))
  (assert-equal "-1/2" (str-rat (make-rat -1 2))))
