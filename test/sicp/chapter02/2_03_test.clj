(ns sicp.chapter02.2-03-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter02.2-02 :refer :all]
            [sicp.chapter02.2-03 :refer :all]))

(deftest test-make-rect
  (assert-equal [(make-point 1 1) (make-point 6 8)]
                (make-rect (make-point 1 1) (make-point 6 8)))
  (assert-equal (make-rect (make-point 2 7) (make-point 5 2))
                (make-rect (make-point 2 7) 3 5)))

(deftest test-rect-perimeter
  (assert-equal 8 (rect-perimeter (make-rect [0 2] [2 0]))))

(deftest test-rect-area
  (assert-equal 16 (rect-area (make-rect [2 6] [6 2]))))
