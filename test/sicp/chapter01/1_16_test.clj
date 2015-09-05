(ns sicp.chapter01.1-16-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-16 :refer :all]))

(deftest test-fast-expt
  (assert-equal 1 (fast-expt 3 0))
  (assert-equal 3 (fast-expt 3 1))
  (assert-equal 27 (fast-expt 3 3))
  (assert-equal 81 (fast-expt 3 4)))
