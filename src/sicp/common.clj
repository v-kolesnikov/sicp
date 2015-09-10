(ns sicp.common)

; since 1.1.4
(defn square [x]
  (* x x))

(defn avg
  ; Return the average value of the collection
  [coll]
  (float (/ (reduce + coll)
            (count coll))))
