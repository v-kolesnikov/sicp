(ns sicp.chapter01.1-29-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.common :refer [cube]]
            [sicp.chapter01.1-29 :refer :all]))

(deftest test-integral
  (assert-equal 0.24998750000000042 (integral cube 0 1 0.01))
  (assert-equal 0.24999987500000073 (integral cube 0 1 0.001)))

(deftest test-simpson-rule-integral
  (assert-equal 0.25 (simpson-rule-integral cube 0 1 100))
  (assert-equal 0.25 (simpson-rule-integral cube 0 1 1000)))
