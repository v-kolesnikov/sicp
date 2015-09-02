(ns sicp.chapter01.1-10)

(defn A [x y]
  (cond
    (zero? y) 0
    (zero? x) (* 2 y)
    (= y 1) 2
    :else (A (dec x)
             (A x
                (dec y)))))

(defn f [n] (A 0 n))
(defn g [n] (A 1 n))
(defn h [n] (A 2 n))
