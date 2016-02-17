(ns sicp.chapter02.2-54)

(defn equal?
  [a b]
  (if (and (seq a) (seq b))
    (and (= (first a) (first b))
         (equal? (rest a) (rest b)))
    (= a b)))
