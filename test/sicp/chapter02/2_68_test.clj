(ns sicp.chapter02.2-68-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter02.2-67-test :refer [sample-tree]]
            [sicp.chapter02.2-68 :as sicp-2-68]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-encode
  (let [sample-message '(A D A B B C A)]
    (assert-equal '(0 1 1 0 0 1 0 1 0 1 1 1 0) (sicp-2-68/encode sample-tree sample-message))
    (is (thrown? Exception (sicp-2-68/encode sample-tree '(A B C D E))))))
