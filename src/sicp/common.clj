(ns sicp.common)

(defn square [x]
  (* x x))

(defn avg
  [seq]
  (float (/ (reduce + seq)
            (count seq))))

(defn round
  "Round down a double to the given precision (number of significant digits)"
  [d precision]
  (let [factor (Math/pow 10 precision)]
    (/ (Math/floor (* d
                      factor))
       factor)))
