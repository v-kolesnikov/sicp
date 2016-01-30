(ns sicp.chapter02.2-41-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-41 :as sicp-2-41]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-enumerate-threes
  (assert-equal '() (sicp-2-41/enumerate-threes 1))
  (assert-equal '() (sicp-2-41/enumerate-threes 2))
  (assert-equal '((1 2 3)) (sicp-2-41/enumerate-threes 3))
  (assert-equal '((1 2 3)
                  (1 2 4) (1 3 4) (2 3 4))
                (sicp-2-41/enumerate-threes 4))
  (assert-equal '((1 2 3)
                  (1 2 4) (1 3 4) (2 3 4)
                  (1 2 5) (1 3 5) (2 3 5) (1 4 5) (2 4 5) (3 4 5))
                (sicp-2-41/enumerate-threes 5)))

(deftest test-find-threes
  (assert-equal '((1 3 4) (1 2 5)) (sicp-2-41/find-threes 5 8))
  (assert-equal '((2 3 4) (1 3 5)) (sicp-2-41/find-threes 5 9)))
