(ns sicp.chapter01.1-45-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-45 :refer :all]))

(deftest test-repeated
  (assert-equal 3.0 (nth-root 81 4))
  (assert-equal 2.0 (nth-root 256 8))
  (assert-equal 2.0 (nth-root 4294967296 32))
  (assert-equal 2.0 (nth-root 340282366920938463463374607431768211456 128)))
