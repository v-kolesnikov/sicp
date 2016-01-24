(ns sicp.chapter02.2-30-test
  (:require [clojure.test :refer [deftest]]
            [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-30 :as sicp-2-30]
            [sicp.test-helper :refer [assert-equal]]))

(ct/defspec spec-square-tree
  20
  (prop/for-all [v (gen/list (gen/list gen/int))]
                (= (sicp-2-30/square-tree-v1 v)
                   (sicp-2-30/square-tree-v2 v))))

(deftest test-square-tree
  (let [tree '(1 (2 (3 4) 5) (6 7))
        sq-tree '(1 (4 (9 16) 25) (36 49))]
    (assert-equal sq-tree (sicp-2-30/square-tree-v1 tree))
    (assert-equal sq-tree (sicp-2-30/square-tree-v2 tree))))
