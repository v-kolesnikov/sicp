(ns sicp.chapter02.2-57
  (:require [sicp.chapter02.2-56 :refer [addend base exponent exponentiation?
                                         make-exponentiation make-product
                                         make-sum multiplier product?
                                         same-variable? sum? variable?]]
            [sicp.common :as sicp]))

(defn augend [[_ _ & b]]
  (if (seq (rest b))
    (cons '+ b)
    (first b)))

(defn multiplicand [[_ _ & b]]
  (if (seq (rest b))
    (cons '* b)
    (first b)))

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
          :else (sicp/error (str "unknown expression type: DERIV " exp)))))
