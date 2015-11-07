(ns sicp.chapter01.1-20-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-20 :refer :all]))

(deftest test-gcd
  (assert-equal 2 (gcd 206 40))
  (assert-equal 256 (gcd 256 0))
  (assert-equal 128 (gcd 1024 128)))
