(ns sicp.chapter01.1-11)

(defn f-recursive [n]
  (cond
    (< n 3) n
    :else (+ (f-recursive (dec n))
             (f-recursive (- n 2))
             (f-recursive (- n 3)))))

(defn f-iteraive [n]
  (loop [a 2 b 1 c 0 n n]
    (if (zero? n)
      c
      (recur (+ a b c)
             a
             b
             (dec n)))))
