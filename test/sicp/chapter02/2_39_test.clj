(ns sicp.chapter02.2-39-test
  (:require [clojure.test :refer [deftest]]
            [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-39 :as sicp-2-39]
            [sicp.test-helper :refer [assert-equal]]))

(ct/defspec spec-reverse-left
  20
  (prop/for-all [v (gen/list gen/int)]
                (= (reverse v)
                   (sicp-2-39/reverse-left v))))

(ct/defspec spec-reverse-right
  20
  (prop/for-all [v (gen/list gen/int)]
                (= (reverse v)
                   (sicp-2-39/reverse-right v))))

(deftest test-reverse-left
  (assert-equal '() (sicp-2-39/reverse-left '()))
  (assert-equal '(5 4 3 2 1) (sicp-2-39/reverse-left '(1 2 3 4 5))))

(deftest test-reverse-right
  (assert-equal '() (sicp-2-39/reverse-right '()))
  (assert-equal '(5 4 3 2 1) (sicp-2-39/reverse-right '(1 2 3 4 5))))
