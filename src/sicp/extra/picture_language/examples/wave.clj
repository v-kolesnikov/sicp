(ns sicp.extra.picture-language.examples.wave
  (:require [quil.core :as q]
            [sicp.extra.picture-language.core :refer :all]
            [sicp.extra.picture-language.frames :refer :all]))

(def width 800)
(def height 800)

(def main-frame (make-frame [0 height] [width 0] [0 (- height)]))

(defn wave-painter
  [frame]
  (let [segments [[[0.4 0.0] [0.5 0.3]] [[0.5 0.3] [0.6 0.0]]
                  [[0.7 0.0] [0.6 0.5]] [[0.6 0.5] [0.7 0.5]]
                  [[0.7 0.5] [1.0 0.3]] [[1.0 0.4] [0.7 0.6]]
                  [[0.7 0.6] [0.6 0.6]] [[0.6 0.6] [0.67 0.83]]
                  [[0.67 0.83] [0.6 1.0]] [[0.4 1.0] [0.33 0.83]]
                  [[0.33 0.83] [0.4 0.6]] [[0.4 0.6] [0.3 0.6]]
                  [[0.3 0.6] [0.2 0.5]] [[0.2 0.5] [0.0 0.7]]
                  [[0.0 0.6] [0.2 0.4]] [[0.2 0.4] [0.3 0.5]]
                  [[0.3 0.5] [0.4 0.5]] [[0.4 0.5] [0.3 0.0]]]
        painter (segments->painter q/line segments)]
    (painter frame)))

(defn smile-wave-painter
  [frame]
  (let [smile-painter (segments->painter q/line [[[0.45 0.7] [0.55 0.7]]])]
    (wave-painter frame)
    (smile-painter frame)))

(defn draw []
  (q/background 255)
  ((corner-split (flipped-pairs smile-wave-painter) 4) main-frame))

(defn show-sketch []
  (q/sketch
   :title "Wave"
   :draw draw
   :size [width height]))

(defn -main [& args]
  (show-sketch))
