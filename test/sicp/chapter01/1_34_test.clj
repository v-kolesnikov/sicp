(ns sicp.chapter01.1-34-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-34 :refer :all]
            [sicp.common :refer [square]]))

(deftest test-f
  (assert-equal 4 (f square))
  (assert-equal 6 (f #(* (inc %) %)))
  (is (thrown? ClassCastException (f f))))
