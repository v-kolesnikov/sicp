(ns sicp.chapter01.1-30)

(defn sum
  [term a next-element b]
  (letfn [(iter [a acc]
            (if (> a b)
              acc
              (iter (next-element a) (+ acc (term a)))))]
    (iter a 0)))
