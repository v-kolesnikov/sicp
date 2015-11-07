(ns sicp.chapter01.1-32)

(defn accumulate-recursive
  [combiner null-value term a next-term b]
  (letfn [(iter [a b]
            (if (> a b)
              null-value
              (combiner (term a)
                        (iter (next-term a) b))))]
    (combiner null-value (iter a b))))

(defn accumulate
  [combiner null-value term a next-term b]
  (loop [a a
         acc null-value]
    (if (> a b)
      acc
      (recur (next-term a)
             (combiner acc (term a))))))

(defn sum
  [a b]
  (accumulate + 0 identity a inc b))

(defn product
  [a b]
  (accumulate * 1 identity a inc b))
