(ns sicp.chapter02.2-27-test
  (:require [clojure.test :refer [deftest]]
            [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-27 :as sicp-2-27]
            [sicp.test-helper :refer [assert-equal]]))

(ct/defspec spec-deep-reverse
  20
  (prop/for-all [v (gen/list (gen/one-of [gen/int (gen/list gen/int)]))]
                (= (sicp-2-27/deep-reverse-v1 v)
                   (sicp-2-27/deep-reverse-v2 v))))

(deftest test-reverse
  (assert-equal '((4 3) (2 1)) (sicp-2-27/deep-reverse-v1 '((1 2) (3 4))))
  (assert-equal '((4 3) (2 1)) (sicp-2-27/deep-reverse-v2 '((1 2) (3 4)))))
