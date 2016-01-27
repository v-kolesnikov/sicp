(ns sicp.chapter02.2-36)

(defn accumulate-n-v1
  [op init seqs]
  (when (seq (first seqs))
    (cons (reduce op init (map first seqs))
          (accumulate-n-v1 op init (map rest seqs)))))

(defn accumulate-n-v2
  [op init seqs]
  (loop [colls seqs
         acc (list)]
    (if (seq (first colls))
      (recur (map rest colls)
             (cons (reduce op init (map first colls))
                   acc))
      (reverse acc))))
