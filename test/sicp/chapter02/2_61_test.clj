(ns sicp.chapter02.2-61-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-61 :as sicp-2-61]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-adjoin-set
  (assert-equal '(1) (sicp-2-61/adjoin-set 1 '()))
  (assert-equal '(1) (sicp-2-61/adjoin-set 1 '(1)))
  (assert-equal '(1 2 3 4 5) (sicp-2-61/adjoin-set 3 '(1 2 4 5))))

(deftest test-element-of-set?
  (assert-equal true (sicp-2-61/element-of-set? 1 '(1)))
  (assert-equal true (sicp-2-61/element-of-set? 1 '(1 2 3)))
  (assert-equal true (sicp-2-61/element-of-set? 3 '(1 2 3)))
  (assert-equal false (sicp-2-61/element-of-set? 1 '())))

(deftest test-intersection-set
  (assert-equal '() (sicp-2-61/intersection-set '() '()))
  (assert-equal '(2 3) (sicp-2-61/intersection-set '(1 2 3) '(2 3 4)))
  (assert-equal '(1 3) (sicp-2-61/intersection-set '(1 3 5) '(0 1 2 3 4 6))))
