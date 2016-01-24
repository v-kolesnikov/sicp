(ns sicp.chapter02.2-32-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-32 :as sicp-2-32]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-subsets
  (assert-equal '(() (3) (2) (2 3) (1) (1 3) (1 2) (1 2 3))
                (sicp-2-32/subsets '(1 2 3))))
