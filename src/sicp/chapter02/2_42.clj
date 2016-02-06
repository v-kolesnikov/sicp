(ns sicp.chapter02.2-42)

(defn safe?
  [k positions]
  (let [last-row (first positions)
        queen-safe? (fn [col row]
                      (and (not= last-row row)
                           (not= (Math/abs (- last-row row))
                                 (Math/abs (- k col)))))]
    (->> (range 1 k)
         (reverse)
         (reduce (fn [acc i]
                   (if (queen-safe? i (first acc))
                     (rest acc)
                     (reduced false)))
                 (rest positions)))))

(defn queens
  [board-size]
  (let [empty-board '(())
        board-range (range 1 (inc board-size))
        add-queen (fn [queens]
                    (map #(cons % queens) board-range))
        extended-set (fn [positions k]
                       (->> positions
                            (mapcat add-queen)
                            (filter #(safe? k %))))]
    (reduce extended-set
            empty-board
            board-range)))
