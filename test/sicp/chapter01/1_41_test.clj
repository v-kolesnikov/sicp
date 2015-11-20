(ns sicp.chapter01.1-41-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-41 :refer :all]))

(deftest test-double-func
  (assert-equal 21 (((double-func (double-func double-func)) inc) 5)))
