(ns sicp.chapter02.2-40
  (:require [sicp.chapter01.1-23 :as sicp-2-23]))

(defn unique-pairs
  [n]
  (let [enumerate-interval #(range %1 (inc %2))
        make-pairs (fn [i]
                     (map #(list i %)
                          (range 1 i)))]
    (->> n
         (enumerate-interval 1)
         (mapcat make-pairs))))

(defn prime-sum-pairs
  [n]
  (let [prime-sum? #(->> %
                         (reduce +)
                         sicp-2-23/prime?)
        make-pair-sum #(->> %
                            (reduce +)
                            (conj %))]
    (->> n
         (unique-pairs)
         (filter prime-sum?)
         (map make-pair-sum))))
