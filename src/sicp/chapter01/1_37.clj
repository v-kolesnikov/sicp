(ns sicp.chapter01.1-37)

(defn cont-frac-recursive
  [n d k]
  (letfn [(iter [i]
            (if (= i k)
              (/ (n i)
                 (d i))
              (/ (n i)
                 (+ (d i)
                    (iter (inc i))))))]
    (iter 0)))

(defn cont-frac-iterative
  [n d k]
  (loop [i k
         acc 0]
    (let [acc (/ (n i)
                 (+ (d i)
                    acc))
          i (dec i)]
      (if (pos? i)
        (recur i acc)
        acc))))

(defn golden-ration-approximation
  [n]
  (let [one (fn [x] 1.0)]
    (/ 1 (cont-frac-iterative one one n))))
