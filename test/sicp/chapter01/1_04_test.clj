(ns sicp.chapter01.1-04-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-04 :refer :all]))

(deftest test-asserts
  (assert-equal 5 (a-plus-abs-b 2 3))
  (assert-equal 5 (a-plus-abs-b 2 (- 3))))
