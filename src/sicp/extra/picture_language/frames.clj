(ns sicp.extra.picture-language.frames
  (:require [sicp.extra.picture-language.vectors :refer :all]))

(defn make-frame
  [origin edge1 edge2]
  {:origin origin :edge1 edge1 :edge2 edge2})

(defn origin-frame
  [{origin :origin}]
  origin)

(defn edge1-frame
  [{edge1 :edge1}]
  edge1)

(defn edge2-frame
  [{edge2 :edge2}]
  edge2)

(defn frame-coord-map
  [{:keys [origin edge1 edge2]}]
  (fn [[x y]]
    (add-vect origin
              (add-vect (scale-vect x edge1)
                        (scale-vect y edge2)))))
