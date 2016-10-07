(ns sicp.chapter02.2-05-test
  (:require [clojure.test :refer :all]
            [sicp.chapter02.2-05 :as sicp-2-05]
            [sicp.test-helper :refer :all]))

(deftest car-test
  (assert-equal 3 (sicp-2-05/car (sicp-2-05/cons 3 8)))
  (assert-equal 5 (sicp-2-05/car (sicp-2-05/cons 5 0))))

(deftest cdr-test
  (assert-equal 8 (sicp-2-05/cdr (sicp-2-05/cons 3 8)))
  (assert-equal 0 (sicp-2-05/cdr (sicp-2-05/cons 5 0))))
