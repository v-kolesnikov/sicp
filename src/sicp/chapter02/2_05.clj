(ns sicp.chapter02.2-05)

(defn cons-
  [a b]
  (* (Math/pow 2 a)
     (Math/pow 3 b)))

(defn factor
  [base n]
  (loop [i n
         acc 0]
    (if (zero? (rem i base))
      (recur (/ i base) (inc acc))
      acc)))

(defn car [z]
  (factor 2 z))

(defn cdr [z]
  (factor 3 z))
