(ns sicp.chapter02.2-17-test
  (:require [clojure.test :refer [deftest]]
            [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-17 :as sicp-2-17]
            [sicp.test-helper :refer [assert-equal]]))

(ct/defspec spec-last-pair
  20
  (let [gen-values (gen/one-of [gen/int gen/boolean gen/string-ascii])]
    (prop/for-all [v (gen/not-empty (gen/one-of [(gen/list gen-values)
                                                 (gen/vector gen-values)]))]
                  (= (list (last v))
                     (sicp-2-17/last-pair v)))))

(deftest test-last-pair
  (assert-equal '(34) (sicp-2-17/last-pair (list 23 72 149 34))))
