(ns sicp.chapter02.2-44)

(defn below
  [bottom-painter top-painter]
  ; some thiings
  (fn [frame]
    ; draw bottom-painter
    ; draw top-painter
    nil))

(defn beside
  [left-painter right-painter]
  ; some things
  (fn [frame]
    ; draw left-painter
    ; draw right-painter
    nil))

(defn up-split-v1
  [painter n]
  (if (zero? n)
    painter
    (let [smaller (up-split-v1 painter (dec n))]
      (->> smaller
           (beside smaller)
           (below painter)))))

(defn up-split-v2
  [painter n]
  (let [f (fn [p _]
            (->> p
                 (beside p)
                 (below painter)))]
    (reduce f painter (range 0 n))))
