(ns sicp.chapter02.2-37-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-37 :as sicp-2-37]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-dot-product
  (assert-equal 14 (sicp-2-37/dot-product '(1 2 3) '(1 2 3))))

(deftest test-matrix-*-vector
  (assert-equal '(5 11) (sicp-2-37/matrix-*-vector '((1 2) (3 4)) '(1 2))))

(deftest test-transpose
  (assert-equal '((1 4 7) (2 5 8) (3 6 9))
                (sicp-2-37/transpose '((1 2 3) (4 5 6) (7 8 9)))))

(deftest test-matrix-*-matrix
  (assert-equal '((2 6) (4 8))
                (sicp-2-37/matrix-*-matrix '((2 0) (0 2))
                                           '((1 2) (3 4)))))
