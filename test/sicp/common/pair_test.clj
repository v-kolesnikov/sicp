(ns sicp.common.pair-test
  (:require [clojure.test :refer :all]
            [sicp.common.pairs :as p]
            [sicp.test-helper :refer :all]))

(deftest car-test
  (assert-equal 3 (p/car (p/cons 3 8)))
  (assert-equal 5 (p/car (p/cons 5 0))))

(deftest cdr-test
  (assert-equal 8 (p/cdr (p/cons 3 8)))
  (assert-equal 0 (p/cdr (p/cons 5 0))))

(deftest pair?-test
  (assert-true  (p/pair? (p/cons 3 8)))
  (assert-false (p/pair? [1, 2])))

(deftest test-inspect
  (assert-equal "(10, ((2, 5), 1))" (p/inspect (p/cons 10 (p/cons (p/cons 2 5) 1))))
  (assert-equal "((1 2 3), [4 5])" (p/inspect (p/cons '(1 2 3) '[4 5])))
  (assert-equal "(10, (foo, :bar))" (p/inspect (p/cons 10 (p/cons 'foo :bar)))))
