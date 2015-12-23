(ns sicp.chapter01.1-30)

(defn sum
  [term a next-element b]
  (loop [i a
         acc 0]
    (if (> i b)
      acc
      (recur (next-element i)
             (+ acc (term i))))))
