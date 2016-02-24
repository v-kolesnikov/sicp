(ns sicp.chapter02.2-54-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-54 :as sicp-2-54]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-equal?
  (assert-equal true (sicp-2-54/equal? '(1 2 3 4) '(1 2 3 4)))
  (assert-equal false  (sicp-2-54/equal? '(1 2 3 4) '(4 2 3 1)))
  (assert-equal true (sicp-2-54/equal? '(this is a list) '(this is a list)))
  (assert-equal false (sicp-2-54/equal? '(this is a list) '(this  (is a) list))))
