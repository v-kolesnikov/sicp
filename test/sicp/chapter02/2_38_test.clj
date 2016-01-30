(ns sicp.chapter02.2-38-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-38 :as sicp-2-38]
            [sicp.common :as sicp]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-fold-right
  (let [fold-right sicp/accumulate]
    (assert-equal 3/2 (fold-right / 1 (list 1 2 3)))
    (assert-equal '(1 (2 (3 nil))) (fold-right list nil (list 1 2 3)))))

(deftest test-fold-left-v1
  (let [fold-left sicp-2-38/fold-left-v1]
    (assert-equal 1/6 (fold-left / 1 (list 1 2 3)))
    (assert-equal '(((nil 1) 2) 3) (fold-left list nil (list 1 2 3)))))

(deftest test-fold-left-v2
  (let [fold-left sicp-2-38/fold-left-v2]
    (assert-equal 1/6 (fold-left / 1 (list 1 2 3)))
    (assert-equal '(((nil 1) 2) 3) (fold-left list nil (list 1 2 3)))))
