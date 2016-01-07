(ns sicp.chapter02.2-24-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-24 :as sicp-2-24]
            [sicp.test-helper :refer [assert-equal]]))

(deftest pair-list-test
  (assert-equal "(1 (2 (3 4)))" (print-str sicp-2-24/pair-list)))
