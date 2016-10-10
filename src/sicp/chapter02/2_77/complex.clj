(ns sicp.chapter02.2-77.complex
  (:require [sicp.chapter02.2-77.complex.polar :as complex-polar]
            [sicp.chapter02.2-77.complex.rectangular :as complex-rectangular]
            [sicp.common.dispatch-table :as dt]
            [sicp.common.tagged-data :as t]))

(defn tag [x] (t/attach-tag 'complex x))

(defn install-package [table apply-fn]
  (letfn [(make-from-real-imag
            [x y]
            ((dt/get table 'make-from-real-imag 'rectangular) x y))
          (make-from-mag-angle
           [x y]
           ((dt/get table 'make-from-mag-angle 'polar) x y))
          (real-part [z] (apply-fn 'real-part z))
          (imag-part [z] (apply-fn 'imag-part z))
          (magnitude [z] (apply-fn 'magnitude z))
          (angle     [z] (apply-fn 'angle     z))
          (add [z1 z2]
               (make-from-real-imag (+ (real-part z1) (real-part z2))
                                    (+ (imag-part z1) (imag-part z2))))
          (sub
           [z1 z2]
           (make-from-real-imag (- (real-part z1) (real-part z2))
                                (- (imag-part z1) (imag-part z2))))
          (mul
           [z1 z2]
           (make-from-mag-angle (* (magnitude z1) (magnitude z2))
                                (+ (angle z1) (angle z2))))
          (div
           [z1 z2]
           (make-from-mag-angle (/ (magnitude z1) (magnitude z2))
                                (- (angle z1) (angle z2))))]
    ; Install package
    (complex-rectangular/install-package table)
    (complex-polar/install-package table)

    (dt/put table 'real-part '(complex) (comp tag real-part))
    (dt/put table 'imag-part '(complex) (comp tag imag-part))
    (dt/put table 'magnitude '(complex) (comp tag magnitude))
    (dt/put table 'angle '(complex) (comp tag angle))

    (dt/put table 'add '(complex complex) (comp tag add))
    (dt/put table 'sub '(complex complex) (comp tag sub))
    (dt/put table 'mul '(complex complex) (comp tag mul))
    (dt/put table 'div '(complex complex) (comp tag div))

    (dt/put table 'make-from-real-imag 'complex (comp tag make-from-real-imag))
    (dt/put table 'make-from-mag-angle 'complex (comp tag make-from-mag-angle))
    'done))
