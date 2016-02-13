(ns sicp.chapter02.2-49-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-47 :refer [make-frame]]
            [sicp.chapter02.2-48 :refer [make-segment]]
            [sicp.chapter02.2-49 :as sicp-2-49]
            [sicp.test-helper :refer [assert-equal]]))

(def frame (make-frame [0 0] [1.0 0.0] [0.0 1.0]))

(defn paint-f [picture]
  (fn [start-point end-point]
    (swap! picture conj (make-segment start-point end-point))))

(deftest test-frame-painter
  (let [picture (atom [] :validator vector?)
        draw-painter (sicp-2-49/frame-painter (paint-f picture))]
    (assert-equal [[[0.0 0.0]  [0.0 1.0]] [[0.0 1.0]  [1.0 1.0]]
                   [[1.0 1.0]  [1.0 0.0]] [[1.0 0.0]  [0.0 0.0]]]
                  (do (draw-painter frame) @picture))))

(deftest test-x-painter
  (let [picture (atom [] :validator vector?)
        draw-painter (sicp-2-49/x-painter (paint-f picture))]
    (assert-equal [[[0.0 0.0]  [1.0 1.0]]
                   [[0.0 1.0]  [1.0 0.0]]]
                  (do (draw-painter frame) @picture))))

(deftest test-diamond-painter
  (let [picture (atom [] :validator vector?)
        draw-painter (sicp-2-49/diamond-painter (paint-f picture))]
    (assert-equal [[[0.0 0.5] [0.5 1.0]] [[0.5 1.0] [1.0 0.5]]
                   [[1.0 0.5] [0.5 0.0]] [[0.5 0.0] [0.0 0.5]]]
                  (do (draw-painter frame) @picture))))

(deftest test-wave-painter
  (let [picture (atom [] :validator vector?)
        draw-painter (sicp-2-49/wave-painter (paint-f picture))]
    (assert-equal [[[0.4 0.0] [0.5 0.3]] [[0.5 0.3] [0.6 0.0]]
                   [[0.7 0.0] [0.6 0.5]] [[0.6 0.5] [0.7 0.5]]
                   [[0.7 0.5] [1.0 0.3]] [[1.0 0.4] [0.7 0.6]]
                   [[0.7 0.6] [0.6 0.6]] [[0.6 0.6] [0.67 0.83]]
                   [[0.67 0.83] [0.6 1.0]] [[0.4 1.0] [0.33 0.83]]
                   [[0.33 0.83] [0.4 0.6]] [[0.4 0.6] [0.3 0.6]]
                   [[0.3 0.6] [0.2 0.5]] [[0.2 0.5] [0.0 0.7]]
                   [[0.0 0.6] [0.2 0.4]] [[0.2 0.4] [0.3 0.5]]
                   [[0.3 0.5] [0.4 0.5]] [[0.4 0.5] [0.3 0.0]]]
                  (do (draw-painter frame) @picture))))
