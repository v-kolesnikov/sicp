(ns sicp.chapter02.2-03
  (:require [sicp.chapter02.2-02 :refer :all]))

(defn make-rect
  ([top-left bottom-right]
   (vector top-left
           bottom-right))
  ([top-left width height]
   (let [bottom-right
         (make-point (+ (x-point top-left)
                        width)
                     (- (y-point top-left)
                        height))]
     (make-rect top-left bottom-right))))

(defn top-left
  [rect]
  (first rect))

(defn bottom-right
  [rect]
  (second rect))

(defn rect-width
  [rect]
  (- (x-point (bottom-right rect))
     (x-point (top-left rect))))

(defn rect-height
  [rect]
  (- (y-point (top-left rect))
     (y-point (bottom-right rect))))

(defn rect-half-perimeter
  [rect]
  (+ (rect-width rect)
     (rect-height rect)))

(defn rect-perimeter
  [rect]
  (* (rect-half-perimeter rect) 2))

(defn rect-area
  [rect]
  (* (rect-width rect)
     (rect-height rect)))
