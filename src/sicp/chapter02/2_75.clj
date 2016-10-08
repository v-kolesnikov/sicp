(ns sicp.chapter02.2-75
  (:require [sicp.common :as sicp]))

(defn apply-generic [op arg]
  (arg op))

(defn real-part [x]
  (apply-generic 'real-part x))

(defn imag-part [x]
  (apply-generic 'imag-part x))

(defn magnitude [x]
  (apply-generic 'magnitude x))

(defn angle [x]
  (apply-generic 'angle x))

(defn make-from-real-imag
  [real imag]
  (letfn [(dispatch [op]
            (cond
              (= op 'real-part) real
              (= op 'imag-part) imag
              (= op 'magnitude) (Math/sqrt (+ (sicp/square real)
                                              (sicp/square imag)))
              (= op 'angle) (Math/atan2 imag real)
              :else (sicp/error (str "Unknown op -- MAKE-FROM-REAL-IMAG " op))))]
    dispatch))

(defn make-from-mag-ang
  [mag ang]
  (letfn [(dispatch [op]
            (cond
              (= op 'real-part) (* mag (Math/cos ang))
              (= op 'imag-part) (* mag (Math/sin ang))
              (= op 'magnitude) mag
              (= op 'angle) ang
              :else (sicp/error (str "Unknown op -- MAKE-FROM-REAL-IMAG " op))))]
    dispatch))
