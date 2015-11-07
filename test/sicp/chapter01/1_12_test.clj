(ns sicp.chapter01.1-12-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-12 :refer :all]))

(deftest test-pascal-triangle
  (assert-equal 1 (pascal-triangle-element 0 0))
  (assert-equal 1 (pascal-triangle-element 1 0))
  (assert-equal 1 (pascal-triangle-element 1 1))
  (assert-equal 1 (pascal-triangle-element 2 0))
  (assert-equal 2 (pascal-triangle-element 2 1))
  (assert-equal 1 (pascal-triangle-element 2 2))
  (assert-equal 6 (pascal-triangle-element 4 2))
  (assert-equal nil (pascal-triangle-element 1 2))
  (assert-equal nil (pascal-triangle-element 1 -2))
  (assert-equal nil (pascal-triangle-element -1 0)))
