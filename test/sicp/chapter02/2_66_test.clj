(ns sicp.chapter02.2-66-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-64 :as sicp-2-64]
            [sicp.chapter02.2-66 :as sicp-2-66]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-lookup
  (let [records '({:id 5 :data 55}
                  {:id 4 :data 44}
                  {:id 7 :data 77})
        tree (->> records (sort-by :id) sicp-2-64/list->tree)]
    (assert-equal nil (sicp-2-66/lookup 3 tree))
    (assert-equal {:id 4 :data 44} (sicp-2-66/lookup 4 tree))
    (assert-equal {:id 5 :data 55} (sicp-2-66/lookup 5 tree))
    (assert-equal {:id 7 :data 77} (sicp-2-66/lookup 7 tree))))
