(ns sicp.chapter01.1-02-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-02 :refer :all]))

(deftest test-asserts
  (assert-equal -37/150 solution))
