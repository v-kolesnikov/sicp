(ns sicp.chapter02.2-02-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter02.2-02 :refer :all]))

(deftest test-make-point
  (assert-equal [3 9] (make-point 3 9))
  (assert-equal [0 6] (make-point 0 6)))

(deftest test-x-point
  (assert-equal 3 (x-point (make-point 3 9)))
  (assert-equal 0 (x-point (make-point 0 6))))

(deftest test-y-point
  (assert-equal 9 (y-point (make-point 3 9)))
  (assert-equal 6 (y-point (make-point 0 6))))

(deftest test-midpoint-segment
  (let [segment1 (make-segment (make-point 2 0)
                               (make-point 6 8))
        segment2 (make-segment (make-point 0 2)
                               (make-point 6 8))]
    (assert-equal (make-point 4 4) (midpoint-segment segment1))
    (assert-equal (make-point 3 5) (midpoint-segment segment2))))
