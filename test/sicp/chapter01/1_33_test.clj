(ns sicp.chapter01.1-33-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-33 :refer :all]))

(deftest test-filtered-accumulate
  (assert-equal 88 (summ-of-primes-squares 1 10))
  (assert-equal 189 (product-of-pos-coprimes 1 10)))
