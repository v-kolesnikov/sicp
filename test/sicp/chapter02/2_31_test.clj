(ns sicp.chapter02.2-31-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-31 :as sicp-2-31]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-square-tree
  (let [tree '(1 (2 (3 4) 5) (6 7))
        sq-tree '(1 (4 (9 16) 25) (36 49))]
    (assert-equal sq-tree (sicp-2-31/square-tree tree))))
