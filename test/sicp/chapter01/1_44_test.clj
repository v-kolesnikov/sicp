(ns sicp.chapter01.1-44-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.common :refer [square]]
            [sicp.chapter01.1-44 :refer :all]))

(deftest test-smooth
  (let [dx 0.00001]
    (assert-equal 4.0 ((smooth square dx) 2))
    (assert-equal 9.0 ((smooth square dx) 3))))

(deftest test-smooth-fold
  (let [dx 0.00001
        n 10]
    (assert-equal 4.0 ((smooth-fold square dx n) 2))
    (assert-equal 9.0 ((smooth-fold square dx n) 3))))
