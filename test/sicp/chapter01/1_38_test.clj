(ns sicp.chapter01.1-38-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-38 :refer :all]))

(deftest test-euler-number
  (assert-equal 2.7182818284590455 (euler-number 21)))
