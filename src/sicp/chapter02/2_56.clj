(ns sicp.chapter02.2-56
  (:require [sicp.common :as sicp]))

(def eq? =)

(defn =number?
  [exp n]
  (and (number? exp)
       (= exp n)))

(defn variable? [x] (symbol? x))

(defn same-variable? [v1 v2]
  (and (variable? v1)
       (variable? v2)
       (eq? v1 v2)))

(defn make-sum [a1 a2]
  (cond (=number? a1 0) a2
        (=number? a2 0) a1
        (and (number? a1)
             (number? a2)) (+ a1 a2)
        :else (list '+ a1 a2)))

(defn sum? [x]
  (and (seq? x)
       (eq? (first x) '+)))

(defn addend [[_ a _]] a)
(defn augend [[_ _ b]] b)

(defn make-product [m1 m2]
  (cond (or (=number? m1 0)
            (=number? m2 0)) 0
        (=number? m1 1) m2
        (=number? m2 1) m1
        (and (number? m1)
             (number? m2)) (* m1 m2)
        :else (list '* m1 m2)))

(defn product? [x]
  (and (seq? x)
       (eq? (first x) '*)))

(defn multiplier [[_ a _]] a)
(defn multiplicand [[_ _ b]] b)

(defn make-exponentiation
  [base exponent]
  (cond (zero? exponent) 1
        (= 1 exponent) base
        :else (list '** base exponent)))

(defn exponentiation? [x]
  (and (seq? x)
       (eq? (first x) '**)))

(defn base [[_ a _]] a)
(defn exponent [[_ _ b]] b)

(defn deriv
  [exp variable]
  (cond (number? exp) 0
        (variable? exp) (if (same-variable? exp variable) 1 0)
        (sum? exp) (make-sum (deriv (addend exp) variable)
                             (deriv (augend exp) variable))
        (product? exp) (make-sum
                        (make-product (multiplier exp)
                                      (deriv (multiplicand exp) variable))
                        (make-product (deriv (multiplier exp) variable)
                                      (multiplicand exp)))
        (exponentiation? exp) (let [x (base exp)
                                    n (exponent exp)]
                                (make-product (make-product n (make-exponentiation x (dec n)))
                                              (deriv x variable)))
        :else (sicp/error (str "unknown expression type: DERIV " exp))))
