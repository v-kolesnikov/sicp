(ns sicp.chapter01.1-43-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.common :refer [square]]
            [sicp.chapter01.1-43 :refer :all]))

(deftest test-repeated
  (assert-equal 256 ((repeated square 3) 2))
  (assert-equal 625 ((repeated square 2) 5)))
