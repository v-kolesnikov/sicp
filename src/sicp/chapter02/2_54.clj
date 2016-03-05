(ns sicp.chapter02.2-54)

(defn equal?
  [a b]
  (if (and (seq? a) (seq? b))
    (cond (and (empty? a) (empty? b)) true
          (or (empty? a) (empty? b)) false
          (and (equal? (first a) (first b))
               (equal? (rest a) (rest b))) true
          :else false)
    (= a b)))
