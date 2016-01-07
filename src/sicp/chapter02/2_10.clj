(ns sicp.chapter02.2-10
  (:require [clojure.test.check.generators :as gen]
            [sicp.chapter02.2-07 :as sicp-2-07]
            [sicp.common :as sicp]))

(defn contains
  [item interval]
  (and (<= (sicp-2-07/lower-bound interval) item)
       (>= (sicp-2-07/upper-bound interval) item)))

(defn div-interval
  [a b]
  (if (contains 0 b)
    (sicp/error "Division by interval that contains zero")
    (let [inverse-b (sicp-2-07/make-interval (/ 1.0 (sicp-2-07/upper-bound b))
                                             (/ 1.0 (sicp-2-07/lower-bound b)))]
      (sicp-2-07/mul-interval a inverse-b))))

(def gen-zero-contains-interval
  (gen/fmap #(apply sicp-2-07/make-interval %)
            (gen/tuple gen/s-neg-int gen/s-pos-int)))
