(ns sicp.chapter01.1-44
  (:require [sicp.chapter01.1-43 :refer [repeated]]
            [sicp.common :refer [avg]]))

(defn smooth
  [f dx]
  (fn [x] (avg [(f x)
                (f (- x dx))
                (f (+ x dx))])))

(defn smooth-fold
  [f dx n]
  ((repeated (fn [g]
               (smooth g dx))
             n) f))
