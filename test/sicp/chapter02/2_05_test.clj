(ns sicp.chapter02.2-05-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter02.2-05 :refer :all]))

(deftest car-test
  (assert-equal 3 (car (cons- 3 8)))
  (assert-equal 5 (car (cons- 5 0))))

(deftest cdr-test
  (assert-equal 8 (cdr (cons- 3 8)))
  (assert-equal 0 (cdr (cons- 5 0))))
