(ns sicp.chapter01.1-33-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-33 :refer :all]))

(deftest test-summ-of-primes-squares
  (assert-equal 88 (summ-of-primes-squares 1 10))
  (assert-equal 65797 (summ-of-primes-squares 1 100)))

(deftest test-product-of-pos-coprimes
  (assert-equal 189 (product-of-pos-coprimes 1 10))
  (assert-equal 8729721 (product-of-pos-coprimes 1 20)))
