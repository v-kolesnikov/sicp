(ns sicp.chapter02.2-53-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-53 :as sicp-2-53]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-memq
  (assert-equal false (sicp-2-53/memq 'red '((red shoes) (blue socks))))
  (assert-equal '(red shoes blue socks) (sicp-2-53/memq 'red '(red shoes blue socks))))

(deftest test-lists
  (assert-equal '(a b c) (list 'a 'b 'c))
  (assert-equal '((george)) (list (list 'george)))
  (assert-equal '((y1 y2)) (rest '((x1 x2) (y1 y2))))
  (assert-equal '(y1 y2) ((comp first rest) '((x1 x2) (y1 y2))))
  (assert-equal false (list? (first '(a short list)))))
