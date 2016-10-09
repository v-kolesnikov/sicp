(ns sicp.chapter02.2-77
  (:require [sicp.common :as sicp]
            [sicp.common.dispatch-table :as dt]
            [sicp.common.pairs :as p]
            [sicp.common.tagged-data :as t])
  (:refer-clojure :exclude [get]))

(def dispatch-table (dt/make-table))
(def put (partial dt/put dispatch-table))
(def get (partial dt/get dispatch-table))

(defn error [msg] (assert nil msg))

(defn apply-generic
  [op & args]
  (let [type-tags (map t/tag args)]
    (if-let [proc (get op type-tags)]
      (apply proc (map t/contents args))
      (error (format "Not found methods for this types -- APPLY-GENERIC: %s %s"
                     op
                     (pr-str type-tags))))))

(defn make-scheme-number [n]
  ((get 'make 'scheme-number) n))

(defn make-rational [n d]
  ((get 'make 'rational) n d))

(defn make-complex-from-real-imag [x y]
  ((get 'make-from-real-imag 'complex) x y))

(defn make-complex-from-mag-angle [r a]
  ((get 'make-from-mag-angle 'complex) r a))

(defn add [x y] (apply-generic 'add x y))
(defn sub [x y] (apply-generic 'sub x y))
(defn mul [x y] (apply-generic 'mul x y))
(defn div [x y] (apply-generic 'div x y))

(defn install-scheme-number-package []
  (letfn [(tag [x] (t/attach-tag 'scheme-number x))]
    (put 'add '(scheme-number scheme-number) (fn [x y] (tag (+ x y))))
    (put 'sub '(scheme-number scheme-number) (fn [x y] (tag (- x y))))
    (put 'mul '(scheme-number scheme-number) (fn [x y] (tag (* x y))))
    (put 'div '(scheme-number scheme-number) (fn [x y] (tag (/ x y))))
    (put 'make 'scheme-number (fn [x] (tag x)))
    'done))

(defn install-rational-package []
  (letfn [(tag [x] (t/attach-tag 'rational x))
          (numer [x] (p/car x))
          (denom [x] (p/cdr x))
          (make [n d]
                (let [g (sicp/gcd n d)]
                  (p/cons (/ n g) (/ d g))))
          (add [x y]
               (make (+ (* (numer x) (denom y))
                        (* (numer y) (denom x)))
                     (* (denom x) (denom y))))
          (sub [x y]
               (make (- (* (numer x) (denom y))
                        (* (numer y) (denom x)))
                     (* (denom x) (denom y))))
          (mul [x y]
               (make (* (numer x) (numer y))
                     (* (denom y) (denom x))))
          (div [x y]
               (make (* (numer x) (denom y))
                     (* (denom x) (numer y))))]
    (put 'add '(rational rational) (fn [x y] (tag (add x y))))
    (put 'sub '(rational rational) (fn [x y] (tag (sub x y))))
    (put 'mul '(rational rational) (fn [x y] (tag (mul x y))))
    (put 'div '(rational rational) (fn [x y] (tag (div x y))))
    (put 'make 'rational (fn [x y] (tag (make x y))))
    'done))

(defn install-complex-package []
  (letfn [(tag [x] (t/attach-tag 'complex x))
          (install-rectangular-package
           []
           (letfn [(tag [x] (t/attach-tag 'rectangular x))
                   (real-part [z] (p/car z))
                   (imag-part [z] (p/cdr z))
                   (make-from-real-imag [x y] (p/cons x y))
                   (magnitude [z] (Math/sqrt (+ (sicp/square (real-part z))
                                                (sicp/square (imag-part z)))))
                   (angle [z] (Math/atan2 (imag-part z)
                                          (real-part z)))
                   (make-from-mag-angle [r a] (p/cons (* r (Math/cos a))
                                                      (* r (Math/sin a))))]
             (put 'real-part '(rectangular) real-part)
             (put 'imag-part '(rectangular) imag-part)
             (put 'magnitude '(rectangular) magnitude)
             (put 'angle '(rectangular) angle)
             (put 'make-from-real-imag 'rectangular
                  (fn [x y] (tag (make-from-real-imag x y))))
             (put 'make-from-mag-angle 'rectangular
                  (fn [r a] (tag (make-from-mag-angle r a))))
             'done))

          (install-polar-package
           []
           (letfn [(tag [x] (t/attach-tag 'polar x))
                   (magnitude [z] (p/car z))
                   (angle [z] (p/cdr z))
                   (make-from-mag-angle [r a] (p/cons r a))
                   (real-part [z] (* (magnitude z)
                                     (Math/cos (angle z))))
                   (imag-part [z]
                              (* (magnitude z)
                                 (Math/sin (angle z))))
                   (make-from-real-imag [x y] (p/cons (Math/sqrt (+ (* x x) (* y y)))
                                                      (Math/atan2 y x)))]

             (put 'real-part '(polar) real-part)
             (put 'imag-part '(polar) imag-part)
             (put 'magnitude '(polar) magnitude)
             (put 'angle '(polar) angle)

             (put 'make-from-real-imag
                  'polar
                  (fn [x y] (tag (make-from-real-imag x y))))

             (put 'make-from-mag-angle
                  'polar
                  (fn [r a] (tag (make-from-mag-angle r a))))
             'done))

          ; Complex ariphmethic
          (make-from-real-imag [x y] ((get 'make-from-real-imag 'rectangular) x y))
          (make-from-mag-angle [x y] ((get 'make-from-mag-angle 'polar) x y))

          (real-part [z] (apply-generic 'real-part z))
          (imag-part [z] (apply-generic 'imag-part z))
          (magnitude [z] (apply-generic 'magnitude z))
          (angle [z] (apply-generic 'angle z))

          (add [z1 z2] (make-from-real-imag (+ (real-part z1) (real-part z2))
                                            (+ (imag-part z1) (imag-part z2))))
          (sub [z1 z2] (make-from-real-imag (- (real-part z1) (real-part z2))
                                            (- (imag-part z1) (imag-part z2))))
          (mul [z1 z2]
               (make-from-mag-angle (* (magnitude z1) (magnitude z2))
                                    (+ (angle z1) (angle z2))))
          (div [z1 z2] (make-from-mag-angle (/ (magnitude z1) (magnitude z2))
                                            (- (angle z1) (angle z2))))]
    (install-rectangular-package)
    (install-polar-package)

    (put 'real-part '(complex) real-part)
    (put 'imag-part '(complex) imag-part)
    (put 'magnitude '(complex) magnitude)
    (put 'angle '(complex) angle)

    (put 'add '(complex complex) (fn [x y] (tag (add x y))))
    (put 'sub '(complex complex) (fn [x y] (tag (sub x y))))
    (put 'mul '(complex complex) (fn [x y] (tag (mul x y))))
    (put 'div '(complex complex) (fn [x y] (tag (div x y))))
    (put 'make-from-real-imag 'complex (fn [x y] (tag (make-from-real-imag x y))))
    (put 'make-from-mag-angle 'complex (fn [x y] (tag (make-from-mag-angle x y))))
    'done))
