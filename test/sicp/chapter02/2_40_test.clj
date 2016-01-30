(ns sicp.chapter02.2-40-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-40 :as sicp-2-40]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-unique-pairs
  (assert-equal '((2 1)
                  (3 1) (3 2)
                  (4 1) (4 2) (4 3)
                  (5 1) (5 2) (5 3) (5 4)
                  (6 1) (6 2) (6 3) (6 4) (6 5))
                (sicp-2-40/unique-pairs 6)))

(deftest test-prime-sum-pairs
  (assert-equal '((3 2 1) (5 3 2) (5 4 1) (7 4 3) (7 5 2) (7 6 1) (11 6 5))
                (sicp-2-40/prime-sum-pairs 6)))
