(ns sicp.common)

(defn square [x]
  (* x x))

(defn avg
  [seq]
  (float (/ (reduce + seq)
            (count seq))))
