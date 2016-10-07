(ns sicp.chapter02.2-04-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter02.2-04 :as sicp-2-04]))

(deftest car-test
  (assert-equal 3 (sicp-2-04/car (sicp-2-04/cons 3 8)))
  (assert-equal 5 (sicp-2-04/car (sicp-2-04/cons 5 0))))

(deftest cdr-test
  (assert-equal 8 (sicp-2-04/cdr (sicp-2-04/cons 3 8)))
  (assert-equal 0 (sicp-2-04/cdr (sicp-2-04/cons 5 0))))
