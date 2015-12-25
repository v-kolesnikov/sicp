(ns sicp.chapter01.1-20)

(defn gcd
  [a b]
  (loop [a (Math/abs a)
         b (Math/abs b)]
    (if (zero? b) a,
        (recur b (mod a b)))))
