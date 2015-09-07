(ns sicp.chapter01.1-20-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-20 :refer :all]))

(deftest test-gcd
  (assert-equal {:nod 2, :iter 4} (gcd 206 40))
  (assert-equal {:nod 256, :iter 0} (gcd 256 0))
  (assert-equal {:nod 128, :iter 1} (gcd 1024 128)))
