(ns sicp.chapter02.2-06-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter02.2-06 :refer :all]))

(deftest one-test
  (assert-equal 2 ((one inc) 1))
  (assert-equal 5 ((one inc) 4)))

(deftest two-test
  (let [f #(* 2 %)]
    (assert-equal 4 ((two f) 1))
    (assert-equal 8 ((two f) 2))))

(deftest add-test
  (assert-equal 03 (((add one two) inc) 0))
  (assert-equal 16 (((add two two) #(* 2 %)) 1)))
