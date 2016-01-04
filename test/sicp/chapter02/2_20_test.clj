(ns sicp.chapter02.2-20-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-20 :as sicp-2-20]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-same-parity
  (assert-equal '(2 4 6) (sicp-2-20/same-parity 2 3 4 5 6 7))
  (assert-equal '(1 3 5 7) (sicp-2-20/same-parity 1 2 3 4 5 6 7)))
