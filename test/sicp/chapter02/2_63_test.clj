(ns sicp.chapter02.2-63-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-63 :as sicp-2-63]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-tree->list-1
  (assert-equal '(1 3 5 7 9 11) (sicp-2-63/tree->list-1 '(7 (3 (1) (5)) (9 () (11)))))
  (assert-equal '(1 3 5 7 9 11) (sicp-2-63/tree->list-1 '(3 (1) (7 (5) (9 () (11))))))
  (assert-equal '(1 3 5 7 9 11) (sicp-2-63/tree->list-1 '(5 (3 (1) ()) (9 (7) (11))))))

(deftest test-tree->list-2
  (assert-equal '(1 3 5 7 9 11) (sicp-2-63/tree->list-2 '(7 (3 (1) (5)) (9 () (11)))))
  (assert-equal '(1 3 5 7 9 11) (sicp-2-63/tree->list-2 '(3 (1) (7 (5) (9 () (11))))))
  (assert-equal '(1 3 5 7 9 11) (sicp-2-63/tree->list-2 '(5 (3 (1) ()) (9 (7) (11))))))
