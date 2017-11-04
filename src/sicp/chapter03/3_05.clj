(ns sicp.chapter03.3-05
  (:require [sicp.common :refer [gcd]]))

(defn circle
  [center-x center-y radius]
  (fn [x y]
    (<= (+ (Math/pow (- x center-x) 2)
           (Math/pow (- y center-y) 2))
        (Math/pow radius 2))))

(defn rand-in-range [low high]
  (+ (rand (Math/abs (- high low))) low))

(defn monte-carlo [trials pred]
  (loop [remaining trials
         passed 0]
    (cond (zero? remaining) (/ passed trials)
          (pred) (recur (dec remaining) (inc passed))
          :else  (recur (dec remaining) passed))))

(defn estimate-integral
  [function x1 y1 x2 y2 trials]
  (let [square (Math/abs (* (- x1 x2) (- y2 y1)))
        test-f #(function (rand-in-range x1 x2)
                          (rand-in-range y1 y2))]
    (float (* (monte-carlo trials test-f) square))))

(defn estimate-pi [trials]
  (estimate-integral (circle 1 1 1) 0 0 2 2 trials))
