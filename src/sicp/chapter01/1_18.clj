(ns sicp.chapter01.1-18)

(defn dub [x]
  (+ x x))

(defn halve [x]
  (/ x 2))

(defn fast-mult [a b]
  (loop [a a
         b b
         acc 0]
    (cond
      (zero? a) acc
      (even? a) (recur (halve a)
                       (dub b)
                       acc)
      (pos? a) (recur (halve (dec a))
                      (dub b)
                      (+ acc b))
      :else (recur (halve (inc a))
                   (dub b)
                   (- acc b)))))
