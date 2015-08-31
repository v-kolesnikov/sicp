(ns sicp.chapter01.1-06)

(defn new-if [predicate then-clause else-clause]
  (cond
    predicate then-clause
    :else else-clause))

; (defn sqrt-iter [guess x]
;   (new-if (good-enough? guess x)
;           guess
;           (sqrt-iter (improve guess x)
;                      x)))
