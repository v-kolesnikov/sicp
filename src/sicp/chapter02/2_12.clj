(ns sicp.chapter02.2-12
  (:require [sicp.chapter02.2-07 :as sicp-2-07]))

(defn make-center-width
  [center width]
  (sicp-2-07/make-interval (- center width)
                           (+ center width)))

(defn make-center-percent
  [center tolerance]
  (let [width (/ (* center tolerance) 100.0)]
    (make-center-width center width)))

(defn center
  [i]
  (/ (+ (sicp-2-07/upper-bound i)
        (sicp-2-07/lower-bound i))
     2.0))

(defn percent
  [i]
  (let [l (sicp-2-07/lower-bound i)
        u (sicp-2-07/upper-bound i)]
    (* (/ (- u l)
          (+ u l))
       100.0)))
