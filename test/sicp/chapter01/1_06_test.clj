(ns sicp.chapter01.1-06-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-06 :refer :all]))

(deftest test-asserts
  (assert-equal 0 (new-if (= 1 1) 0 5))
  (assert-equal 5 (new-if (= 2 3) 0 5)))
