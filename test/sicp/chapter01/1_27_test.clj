(ns sicp.chapter01.1-27-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-27 :refer :all]
            [sicp.chapter01.1-21 :refer [prime?]]))

(deftest test-check-prime
  (assert-true (check-prime 561))
  (assert-true (not (prime? 561)))

  (assert-true (check-prime 1105))
  (assert-true (not (prime? 1105)))

  (assert-true (check-prime 1729))
  (assert-true (not (prime? 1729)))

  (assert-true (check-prime 2465))
  (assert-true (not (prime? 2465)))

  (assert-true (check-prime 2821))
  (assert-true (not (prime? 2821))))
