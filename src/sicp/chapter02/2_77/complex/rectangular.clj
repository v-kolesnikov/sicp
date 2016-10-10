(ns sicp.chapter02.2-77.complex.rectangular
  (:require [sicp.common :as sicp]
            [sicp.common.dispatch-table :as dt]
            [sicp.common.pairs :as p]
            [sicp.common.tagged-data :as t]))

(defn tag [x]
  (t/attach-tag 'rectangular x))

(defn real-part [z] (p/car z))
(defn imag-part [z] (p/cdr z))

(defn make-from-real-imag
  [x y]
  (p/cons x y))

(defn magnitude
  [z]
  (Math/sqrt (+ (sicp/square (real-part z))
                (sicp/square (imag-part z)))))

(defn angle
  [z]
  (Math/atan2 (imag-part z)
              (real-part z)))

(defn make-from-mag-angle
  [r a]
  (p/cons (* r (Math/cos a))
          (* r (Math/sin a))))

(defn install-package [table]
  (letfn [(register [op types method]
            (dt/put table op types method))]
    (register 'real-part '(rectangular) real-part)
    (register 'imag-part '(rectangular) imag-part)
    (register 'magnitude '(rectangular) magnitude)
    (register 'angle     '(rectangular) angle)
    (register 'make-from-real-imag 'rectangular (comp tag make-from-real-imag))
    (register 'make-from-mag-angle 'rectangular (comp tag make-from-mag-angle))
    'done))
