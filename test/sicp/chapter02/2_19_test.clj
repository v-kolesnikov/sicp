(ns sicp.chapter02.2-19-test
  (:require [clojure.test :refer [deftest]]
            [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-19 :as sicp-2-19]
            [sicp.test-helper :refer [assert-equal]]))

(ct/defspec spec-cc
  10
  (prop/for-all [coins (gen/list-distinct gen/s-pos-int)
                 amount gen/s-pos-int]
                (= (sicp-2-19/cc amount coins)
                   (sicp-2-19/cc amount (sort coins)))))

(deftest test-cc
  (let [us-coins (list 50 25 10 5 1)]
    (assert-equal 292 (sicp-2-19/cc 100 us-coins))))
