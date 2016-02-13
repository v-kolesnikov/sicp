(ns sicp.chapter02.2-50-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-47 :refer [make-frame]]
            [sicp.chapter02.2-50 :as sicp-2-50]
            [sicp.test-helper :refer [assert-equal]]))

(def frame-painter identity)

(deftest test-flip-horiz
  (let [f (sicp-2-50/flip-horiz frame-painter)]
    (assert-equal (make-frame [1 0] [-1.0 0.0] [0.0 1.0])
                  (f (make-frame [0 0] [1 0] [0 1])))
    (assert-equal (make-frame [3 2] [-1.0 0.0] [0.0 1.0])
                  (f (make-frame [2 2] [1 0] [0 1])))
    (assert-equal (make-frame [-1 2.5] [-1.0 0.0] [0.0 1.0])
                  (f (make-frame [-2 2.5] [1 0] [0 1])))))

(deftest test-rotate-counterclockwise-180
  (let [f (sicp-2-50/rotate-counterclockwise-180 frame-painter)]
    (assert-equal (make-frame [1.0 1.0] [-1.0 0.0] [0.0 -1.0])
                  (f (make-frame [0 0] [1 0] [0 1])))
    (assert-equal (make-frame [3.0 3.0] [-1.0 0.0] [0.0 -1.0])
                  (f (make-frame [2 2] [1 0] [0 1])))
    (assert-equal (make-frame [-1.0 3.5] [-1.0 0.0] [0.0 -1.0])
                  (f (make-frame [-2 2.5] [1 0] [0 1])))))

(deftest test-rotate-counterclockwise-270
  (let [f (sicp-2-50/rotate-counterclockwise-270 frame-painter)]
    (assert-equal (make-frame [0.0 1.0] [0.0 -1.0] [1.0 0.0])
                  (f (make-frame [0 0] [1 0] [0 1])))
    (assert-equal (make-frame [2.0 3.0] [0.0 -1.0] [1.0 0.0])
                  (f (make-frame [2 2] [1 0] [0 1])))
    (assert-equal (make-frame [-2.0 3.5] [0.0 -1.0] [1.0 0.0])
                  (f (make-frame [-2 2.5] [1 0] [0 1])))))
