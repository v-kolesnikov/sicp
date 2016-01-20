(ns sicp.chapter02.2-25-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-25 :as sicp-2-25]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-solutions
  (assert-equal 7 (sicp-2-25/solution1 '(1 3 (5 7) 9)))
  (assert-equal 7 (sicp-2-25/solution2 '((7))))
  (assert-equal 7 (sicp-2-25/solution3 '(1 (2 (3 (4 (5 (6 7)))))))))
