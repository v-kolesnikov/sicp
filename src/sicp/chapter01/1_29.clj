(ns sicp.chapter01.1-29
  (:require [sicp.chapter01.1-30 :refer [sum]]
            [sicp.common :refer [cube]]))

(defn integral
  [f a b dx]
  (let [add-dx (fn [x] (+ x dx))]
    (* (sum f
            (+ a (/ dx 2))
            add-dx
            b)
       dx)))

(defn simpson-rule-integral
  [f a b n]
  (let [h (/ (- b a) n)
        y (fn [k] (f (+ a (* k h))))
        step (fn [i] (+ i 2))]
    (double (* (/ h 3)
               (+ (f a)
                  (* 4 (sum y 1 step n))
                  (* 2 (sum y 2 step (dec n)))
                  (f b))))))
