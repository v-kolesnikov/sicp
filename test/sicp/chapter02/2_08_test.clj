(ns sicp.chapter02.2-08-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter02.2-07 :refer :all]
            [sicp.chapter02.2-08 :refer :all]))

(deftest sub-interval-test
  (assert-equal (make-interval 2 7)
                (sub-interval (make-interval 6 9)
                              (make-interval 2 4))))
