(ns sicp.chapter02.2-41)

(defn enumerate-threes
  [n]
  (let [f (fn [g m]
            (mapcat g (range 1 m)))]
    (f (fn [i]
         (f (fn [j]
              (map #(list % j i)
                   (range 1 j)))
            i))
       (inc n))))

(defn find-threes
  [n s]
  (filter #(= (reduce + %) s)
          (enumerate-threes n)))
