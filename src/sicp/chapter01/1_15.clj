(ns sicp.chapter01.1-15)

(defn cube [x]
  (* x x x))

(defn p [x]
  (- (* 3 x)
     (* 4 (cube x))))

(defn sine [angle]
  (cond
    (< (Math/abs angle) 0.1) angle
    :else (p (sine (/ angle 3.0)))))
