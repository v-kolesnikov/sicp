(ns sicp.chapter02.2-56-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-56 :as sicp-2-56]
            [sicp.common :as sicp]
            [sicp.test-helper :refer [assert-equal assert-true]]))

(deftest test-deriv
  (assert-equal 1 (sicp-2-56/deriv '(+ x 3) 'x))
  (assert-equal 'y (sicp-2-56/deriv '(* x y) 'x))
  (assert-equal '(+ (* x y) (* y (+ x 3))) (sicp-2-56/deriv '(* (* x y) (+ x 3)) 'x))
  (assert-equal '(* (* 5 (** (* 3 x) 4)) 3) (sicp-2-56/deriv '(** (* 3 x) 5) 'x))
  (assert-equal '(* 2 x) (sicp-2-56/deriv '(** x 2) 'x))
  (assert-true (sicp/error? (sicp-2-56/deriv '(! 4 5) 'x))))
