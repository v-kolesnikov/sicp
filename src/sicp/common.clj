(ns sicp.common)

(defn square [x]
  (* x x))

(defn cube [x]
  (* x x x))

(defn avg
  [seq]
  (float (/ (reduce + seq)
            (count seq))))

(defn gcd
  [a b]
  (loop [a (Math/abs a)
         b (Math/abs b)]
    (if (zero? b) a,
        (recur b (mod a b)))))

(defn round
  "Round down a double to the given precision (number of significant digits)"
  [d precision]
  (let [factor (Math/pow 10 precision)]
    (/ (Math/floor (* d
                      factor))
       factor)))
