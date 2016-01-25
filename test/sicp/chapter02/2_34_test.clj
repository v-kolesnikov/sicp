(ns sicp.chapter02.2-34-test
  (:require [clojure.test :refer [deftest]]
            [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-34 :as sicp-2-34]
            [sicp.test-helper :refer [assert-equal]]))

(ct/defspec spec-horner-eval
  20
  (prop/for-all [v (gen/fmap seq (gen/vector gen/nat 1 9))
                 x (gen/choose 0 9)]
                (= (sicp-2-34/horner-eval-v1 x v)
                   (sicp-2-34/horner-eval-v2 x v))))

(deftest test-horner-eval
  (assert-equal 79 (sicp-2-34/horner-eval-v1 2 '(1 3 0 5 0 1)))
  (assert-equal 79 (sicp-2-34/horner-eval-v2 2 '(1 3 0 5 0 1))))
