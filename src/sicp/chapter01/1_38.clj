(ns sicp.chapter01.1-38)

(defn cont-frac
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

(defn euler-number
  [k]
  (let [n (fn [_] 1.0)
        d (fn [x] (if (= (rem x 3) 2)
                    (* (/ (inc x)
                          3)
                       2)
                    1))]
    (+ 2 (cont-frac n d k))))
