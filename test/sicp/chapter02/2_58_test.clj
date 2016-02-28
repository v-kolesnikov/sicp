(ns sicp.chapter02.2-58-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-58 :as sicp-2-58]
            [sicp.common :as sicp]
            [sicp.test-helper :refer [assert-equal assert-true]]))

(deftest test-deriv
  (assert-equal 1 (sicp-2-58/deriv '(x + 3) 'x))
  (assert-equal 4 (sicp-2-58/deriv '(x + (3 * (x + (y + 2)))) 'x))
  (assert-equal 4 (sicp-2-58/deriv '(x + 3 * (x + y + 2)) 'x)))
