(ns sicp.chapter01.1-39-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-39 :refer :all]))

(deftest test-tan-cf
  (assert-equal (float 1.5574077) (tan-cf 1 10)))
