(ns sicp.extra.y-combinator)

(defn factorial
  [n]
  (let [y (fn [f] (f f))
        f (fn [g] (fn [n] (if (zero? n) 1 (* n ((g g) (dec n))))))]
    ((y f) n)))

(assert (= 24  (factorial 4)))
(assert (= 120 (factorial 5)))
(assert (= 720 (factorial 6)))
