(ns sicp.chapter02.2-73
  (:require [sicp.chapter02.2-56 :refer [make-exponentiation make-product
                                         make-sum same-variable? variable?]]
            [sicp.common :as sicp])
  (:refer-clojure :exclude [get]))

(defn install-package-deriv []
  (defmulti get (fn [method operator]
                  (keyword (str method) (str operator))))

  (defn addend [[a _]] a)
  (defn augend [[_ b]] b)

  (defn multiplier [[a _]] a)
  (defn multiplicand [[_ b]] b)

  (defn base [[a _]] a)
  (defn exponent [[_ b]] b)

  (defn operator [[op & _]] op)
  (defn operands [[_ & op]] op)

  (defn deriv
    [exp variable]
    (cond (number? exp) 0
          (variable? exp) (if (same-variable? exp variable) 1 0)
          :else (let [derive-f (get 'deriv (operator exp))]
                  (derive-f (operands exp) variable))))

  (defmethod get :deriv/+ [_ _]
    (fn [exp variable]
      (make-sum (deriv (base exp) variable)
                (deriv (augend exp) variable))))

  (defmethod get :deriv/* [_ _]
    (fn [exp variable]
      (make-sum
       (make-product (multiplier exp)
                     (deriv (multiplicand exp) variable))
       (make-product (deriv (multiplier exp) variable)
                     (multiplicand exp)))))

  (defmethod get :deriv/** [_ _]
    (fn [exp variable]
      (let [x (base exp)
            n (exponent exp)]
        (make-product (make-product n (make-exponentiation x (dec n)))
                      (deriv x variable)))))

  (defmethod get :default [_ _]
    (fn [exp _]
      (sicp/error (str "unknown expression type: DERIV " exp))))
  'done)
