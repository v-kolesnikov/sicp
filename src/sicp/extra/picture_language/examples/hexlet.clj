(ns sicp.extra.picture-language.examples.hexlet
  (:require [quil.core :as q]
            [sicp.extra.picture-language.core :refer :all]
            [sicp.extra.picture-language.frames :refer :all]))

(def width 800)
(def height 800)

(def main-frame (make-frame [0 height] [width 0] [0 (- height)]))

(defn image-painter
  [image]
  (fn [{[ox oy] :origin
        [e1x e1y] :edge1
        [e2x e2y] :edge2}]
    (q/image image ox oy e1x e2y)))

(defn hexlet-painter
  [frame]
  ((->> "images/extra/picture_language/Hexlet.jpg" q/load-image image-painter) frame))

(defn draw []
  (q/background 255)
  ((corner-split hexlet-painter 4) main-frame))

(defn show-sketch []
  (q/sketch
   :title "Hexlet"
   :draw draw
   :size [width height]))

(defn -main [& args]
  (show-sketch))
