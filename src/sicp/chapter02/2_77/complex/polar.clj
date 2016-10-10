(ns sicp.chapter02.2-77.complex.polar
  (:require [sicp.common.dispatch-table :as dt]
            [sicp.common.pairs :as p]
            [sicp.common.tagged-data :as t]))

(defn tag [x]
  (t/attach-tag 'polar x))

(defn magnitude
  [z]
  (p/car z))

(defn angle
  [z]
  (p/cdr z))

(defn make-from-mag-angle
  [r a]
  (p/cons r a))

(defn real-part
  [z]
  (* (magnitude z)
     (Math/cos (angle z))))

(defn imag-part [z]
  (* (magnitude z)
     (Math/sin (angle z))))

(defn make-from-real-imag
  [x y]
  (p/cons (Math/sqrt (+ (* x x) (* y y)))
          (Math/atan2 y x)))

(defn install-package [table]
  (letfn [(register [op types method]
            (dt/put table op types method))]
    (register 'real-part '(polar) real-part)
    (register 'imag-part '(polar) imag-part)
    (register 'magnitude '(polar) magnitude)
    (register 'angle     '(polar) angle)
    (register 'make-from-real-imag 'polar (comp tag make-from-real-imag))
    (register 'make-from-mag-angle 'polar (comp tag make-from-mag-angle))
    'done))
