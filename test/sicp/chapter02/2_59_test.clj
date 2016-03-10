(ns sicp.chapter02.2-59-test
  (:require [clojure.test :refer [deftest]]
            [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-59 :as sicp-2-59]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-adjoin-set
  (assert-equal '(1 2 3) (sicp-2-59/adjoin-set 1 '(2 3)))
  (assert-equal '(1 2 3) (sicp-2-59/adjoin-set 1 '(1 2 3)))
  (assert-equal '(nil) (sicp-2-59/adjoin-set nil '()))
  (assert-equal '(()) (sicp-2-59/adjoin-set '() '())))

(deftest test-element-of-set?
  (assert-equal true (sicp-2-59/element-of-set? 1 '(1)))
  (assert-equal true (sicp-2-59/element-of-set? 3 '(1 2 3 4)))
  (assert-equal true (sicp-2-59/element-of-set? '(2 3) '(1 (2 3) 4)))
  (assert-equal false (sicp-2-59/element-of-set? nil '()))
  (assert-equal false (sicp-2-59/element-of-set? '() '(nil)))
  (assert-equal false (sicp-2-59/element-of-set? '() '()))
  (assert-equal false (sicp-2-59/element-of-set? 3 '(1 (2 3) 4))))

(deftest test-intersection-set
  (assert-equal '(1 3) (sicp-2-59/intersection-set '(1 2 3) '(1 3 4)))
  (assert-equal '(4 1 3) (sicp-2-59/intersection-set '(4 1 5 3) '(1 3 4))))

(deftest test-union-set
  (assert-equal '() (sicp-2-59/union-set '() '()))
  (assert-equal '(nil) (sicp-2-59/union-set '() '(nil)))
  (assert-equal '(nil) (sicp-2-59/union-set '(nil) '()))
  (assert-equal '(nil) (sicp-2-59/union-set '(nil) '(nil)))
  (assert-equal '(3 1 2) (sicp-2-59/union-set '(1 2) '(3)))
  (assert-equal '(3 1 2) (sicp-2-59/union-set '(1 2) '(1 2 3)))
  (assert-equal '((2) (1) 1 2 3 4) (sicp-2-59/union-set '(1 2 3 4) '((1) (2) 3))))

(def element-of-set
  (gen/one-of [gen/int gen/char-ascii]))

(def set-generator
  (gen/list-distinct element-of-set))

(defspec spec-set1
  20
  (prop/for-all [s set-generator
                 x element-of-set]
                (sicp-2-59/element-of-set? x (sicp-2-59/adjoin-set x s))))

(defspec spec-set2
  20
  (prop/for-all [s1 set-generator
                 s2 set-generator
                 x element-of-set]
                (= (sicp-2-59/element-of-set? x (sicp-2-59/union-set s1 s2))
                   (or (sicp-2-59/element-of-set? x s1)
                       (sicp-2-59/element-of-set? x s2)))))

(defspec spec-set3
  20
  (prop/for-all [x element-of-set]
                (not (sicp-2-59/element-of-set? x '()))))
