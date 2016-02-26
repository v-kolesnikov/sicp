(ns sicp.chapter02.2-55-test
  (:require [clojure.test :refer [deftest]]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-quote
  (assert-equal 'x (quote x))
  (assert-equal ''x (quote (quote x)))
  (assert-equal '''x (quote (quote (quote x))))
  (assert-equal 'quote (first ''x)))

(deftest test-print-quote
  (assert-equal "quote" (print-str (first ''abracadabra))))
