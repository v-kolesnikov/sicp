(ns sicp.chapter02.2-07-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter02.2-07 :refer :all]))

(deftest add-interval-test
  (assert-equal (make-interval 6 12)
                (add-interval (make-interval 2 5)
                              (make-interval 4 7))))
