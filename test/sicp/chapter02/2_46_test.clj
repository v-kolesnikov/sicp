(ns sicp.chapter02.2-46-test
  (:require [clojure.test :refer [deftest is]]
            [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-46 :as sicp-2-46]
            [sicp.test-helper :refer [assert-equal]]))

(defspec spec-make-vect
  20
  (prop/for-all [v (gen/tuple gen/int gen/int)]
                (vector? (apply sicp-2-46/make-vect v))))

(deftest test-make-vect
  (assert-equal [0 0] (sicp-2-46/make-vect 0 0))
  (assert-equal [1.5 10] (sicp-2-46/make-vect 1.5 10))
  (assert-equal [-50 -1] (sicp-2-46/make-vect -50 -1)))

(deftest test-add-vect
  (assert-equal [2 3] (sicp-2-46/add-vect [0 0] [2 3]))
  (assert-equal [4.5 5.0] (sicp-2-46/add-vect [2.5 1.5] [2 3.5]))
  (assert-equal [-65 85] (sicp-2-46/add-vect [-50 -10] [-15 95])))

(deftest test-sub-vect
  (assert-equal [-2 -3] (sicp-2-46/sub-vect [0 0] [2 3]))
  (assert-equal [0.5 -2.0] (sicp-2-46/sub-vect [2.5 1.5] [2 3.5]))
  (assert-equal [-35 -105] (sicp-2-46/sub-vect [-50 -10] [-15 95])))

(deftest test-scale-vect
  (assert-equal [0 0] (sicp-2-46/scale-vect [0 0] 1))
  (assert-equal [3.75 2.25] (sicp-2-46/scale-vect [2.5 1.5] 1.5))
  (assert-equal [100 20] (sicp-2-46/scale-vect [-50 -10] -2)))
