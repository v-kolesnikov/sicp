(ns sicp.chapter01.1-10-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-10 :refer :all]))

(deftest test-ackermann
  (assert-equal 1024 (A 1 10))
  (assert-equal 65536 (A 2 4))
  (assert-equal 65536 (A 3 3)))

(deftest test-f
  (assert-equal 2 (f 1))
  (assert-equal 4 (f 2))
  (assert-equal 6 (f 3))
  (assert-equal 8 (f 4))
  (assert-equal 10 (f 5)))

(deftest test-g
  (assert-equal 2 (g 1))
  (assert-equal 4 (g 2))
  (assert-equal 8 (g 3))
  (assert-equal 16 (g 4))
  (assert-equal 32 (g 5)))

(deftest test-h
  (assert-equal 2 (h 1))
  (assert-equal 4 (h 2))
  (assert-equal 16 (h 3))
  (assert-equal 65536 (h 4)))
