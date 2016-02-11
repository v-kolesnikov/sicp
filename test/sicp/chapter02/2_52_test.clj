(ns sicp.chapter02.2-52-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-47 :refer [make-frame]]
            [sicp.chapter02.2-52 :as sicp-2-52]
            [sicp.test-helper :refer [assert-equal]]))

(def frame (make-frame [0 0] [1 0] [0 1]))

(defn canvas []
  (atom [] :validator vector?))

(defn draw [picture]
  (fn [start-point end-point]
    (swap! picture conj [start-point end-point])))

(deftest test-smile-wave-painter
  (let [picture (atom [] :validator vector?)
        draw-painter (sicp-2-52/smile-wave-painter (draw picture))]
    (assert-equal [[[0.4 0.0] [0.5 0.3]] [[0.5 0.3] [0.6 0.0]]
                   [[0.7 0.0] [0.6 0.5]] [[0.6 0.5] [0.7 0.5]]
                   [[0.7 0.5] [1.0 0.3]] [[1.0 0.4] [0.7 0.6]]
                   [[0.7 0.6] [0.6 0.6]] [[0.6 0.6] [0.67 0.83]]
                   [[0.67 0.83] [0.6 1.0]] [[0.4 1.0] [0.33 0.83]]
                   [[0.33 0.83] [0.4 0.6]] [[0.4 0.6] [0.3 0.6]]
                   [[0.3 0.6] [0.2 0.5]] [[0.2 0.5] [0.0 0.7]]
                   [[0.0 0.6] [0.2 0.4]] [[0.2 0.4] [0.3 0.5]]
                   [[0.3 0.5] [0.4 0.5]] [[0.4 0.5] [0.3 0.0]]
                   [[0.45 0.7]  [0.55 0.7]]] ; <- smile
                  (do (draw-painter frame) @picture))))
