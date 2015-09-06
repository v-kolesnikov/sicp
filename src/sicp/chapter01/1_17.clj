(ns sicp.chapter01.1-17)

(defn dub [x]
  (+ x x))

(defn halve [x]
  (/ x 2))

(defn fast-mult [a b]
  (cond
    (zero? a) 0
    (even? a) (fast-mult (halve a)
                         (dub b))
    (pos? a) (+ (fast-mult (halve (dec a))
                           (dub b))
                b)
    :else (- (fast-mult (halve (inc a))
                        (dub b))
             b)))
