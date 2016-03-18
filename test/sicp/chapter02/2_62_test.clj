(ns sicp.chapter02.2-62-test
  (:require [clojure.test :refer [deftest]]
            [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-62 :as sicp-2-62]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-union-set
  (assert-equal '() (sicp-2-62/union-set '() '()))
  (assert-equal '(1 2 3 4 5) (sicp-2-62/union-set '(1 2 3 4 5) '(1 2 3 4 5)))
  (assert-equal '(0 1 2 3 4 5 6 7) (sicp-2-62/union-set '(1 3 5 7) '(0 2 4 6)))
  (assert-equal '(-4 -3 -2 -1 0 1 2 3 4 5) (sicp-2-62/union-set '(0 1 2 3 4 5) '(-4 -3 -2 -1))))

(def sorted-set-generator
  (gen/fmap sort (gen/list-distinct gen/int)))

(defspec spec-union-set-sorted
  20
  (prop/for-all [s1 sorted-set-generator
                 s2 sorted-set-generator]
                (let [union (sicp-2-62/union-set s1 s2)]
                  (= (sort union) union))))

(defspec spec-union-set-unique
  (prop/for-all [s1 sorted-set-generator
                 s2 sorted-set-generator]
                (let [union (sicp-2-62/union-set s1 s2)]
                  (= (-> union set seq sort) union))))
