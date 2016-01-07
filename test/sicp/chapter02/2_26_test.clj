(ns sicp.chapter02.2-26-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-26 :as sicp-2-26]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-solution
  (assert-equal '(1 2 3 4 5 6) (concat sicp-2-26/x sicp-2-26/y))
  (assert-equal '((1 2 3) 4 5 6) (cons sicp-2-26/x sicp-2-26/y))
  (assert-equal '((1 2 3) (4 5 6)) (list sicp-2-26/x sicp-2-26/y)))
