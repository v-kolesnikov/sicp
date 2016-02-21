(ns sicp.chapter02.2-58
  (:require [sicp.chapter02.2-56 :refer [=number? eq? same-variable? variable?]]
            [sicp.common :as util]))

(defn simplify
  [expr]
  (if (-> expr rest empty?)
    (first expr)
    expr))

(defn make-sum [a1 a2]
  (cond (=number? a1 0) a2
        (=number? a2 0) a1
        (and (number? a1)
             (number? a2)) (+ a1 a2)
        :else (list a1 '+ a2)))

(defn sum? [x]
  (and (seq? x)
       (eq? (second x) '+)))

(defn addend [[a _ & _]] a)
(defn augend [[_ _ & b]]
  (simplify b))

(defn make-product [m1 m2]
  (cond (or (=number? m1 0)
            (=number? m2 0)) 0
        (=number? m1 1) m2
        (=number? m2 1) m1
        (and (number? m1)
             (number? m2)) (* m1 m2)
        :else (list m1 '* m2)))

(defn product? [x]
  (and (seq? x)
       (eq? (second x) '*)))

(defn multiplier [[a _ & _]] a)
(defn multiplicand [[_ _ & b]]
  (simplify b))

(defn make-exponentiation
  [base exponent]
  (cond (zero? exponent) 1
        (= 1 exponent) base
        :else (list base '** exponent)))

(defn exponentiation? [x]
  (and (seq? x)
       (eq? (second x) '**)))

(defn base [[a _ _]] a)
(defn exponent [[_ _ b]] b)

(defn deriv
  [exp variable]
  (let [sum-rule #(make-sum (deriv (addend exp) variable)
                            (deriv (augend exp) variable))
        product-rule #(let [f (multiplier exp)
                            g (multiplicand exp)]
                        (make-sum (make-product f (deriv g variable))
                                  (make-product (deriv f variable) g)))
        power-rule #(let [x (base exp)
                          r (exponent exp)]
                      (make-product (make-product r (make-exponentiation x (dec r)))
                                    (deriv x variable)))]
    (cond (number? exp) 0
          (variable? exp) (if (same-variable? exp variable) 1 0)
          (sum? exp) (sum-rule)
          (product? exp) (product-rule)
          (exponentiation? exp) (power-rule)
          :else (util/error (str "unknown expression type: DERIV " exp)))))
