(ns sicp.chapter02.2-04-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter02.2-04 :refer :all]))

(deftest car-test
  (assert-equal 3 (car (my-cons 3 8)))
  (assert-equal 5 (car (my-cons 5 0))))

(deftest cdr-test
  (assert-equal 8 (cdr (my-cons 3 8)))
  (assert-equal 0 (cdr (my-cons 5 0))))
