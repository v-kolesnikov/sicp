(ns sicp.chapter02.2-57-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-57 :as sicp-2-57]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-deriv
  (assert-equal 1 (sicp-2-57/deriv '(+ x 3) 'x))
  (assert-equal 'y (sicp-2-57/deriv '(* x y) 'x))
  (assert-equal '(+ 2 (+ 3 y)) (sicp-2-57/deriv '(+ (* 2 x) (* 3 x) (* x y)) 'x))
  (assert-equal '(+ (* x y) (* x y)) (sicp-2-57/deriv '(* x x y) 'x))
  (assert-equal '(+ (* x y) (* y (+ x 3))) (sicp-2-57/deriv '(* x y (+ x 3)) 'x)))
