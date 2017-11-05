(ns sicp.chapter03.3-08-test
  (:require [clojure.test :refer :all]
            [sicp.chapter03.3-08 :refer :all]))

(deftest test-left-to-rigth
  (let [f (make-f)]
    (is (= 0 (+ (f 0) (f 1))))))

(deftest test-right-to-left
  (let [f (make-f)]
    (is (= 1 (+ (f 1) (f 0))))))
