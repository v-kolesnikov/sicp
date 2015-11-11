(ns sicp.chapter01.1-35)

(def tolerance 0.00001)

(defn fixed-point
  [f first-guess]
  (letfn [(close-enough? [v1 v2]
            (< (Math/abs (- v1
                            v2))
               tolerance))]
    (loop [guess first-guess]
      (let [next (f guess)]
        (if (close-enough? guess next)
          next
          (recur next))))))

(defn golden-ration
  ([]
   (golden-ration 1.0))
  ([first-guess]
   (letfn [(transform [x] (inc (/ 1 x)))]
     (fixed-point transform first-guess))))
