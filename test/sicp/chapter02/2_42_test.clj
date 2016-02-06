(ns sicp.chapter02.2-42-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-42 :as sicp-2-42]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-queens
  (assert-equal '((3 1 4 2) (2 4 1 3)) (sicp-2-42/queens 4))
  (assert-equal 10 (count (sicp-2-42/queens 5)))
  (assert-equal 04 (count (sicp-2-42/queens 6)))
  (assert-equal 40 (count (sicp-2-42/queens 7)))
  (assert-equal 92 (count (sicp-2-42/queens 8))))
