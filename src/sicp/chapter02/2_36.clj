(ns sicp.chapter02.2-36)

(defn accumulate-n-v1
  [op init seqs]
  (when (seq (first seqs))
    (cons (reduce op init (map first seqs))
          (accumulate-n-v1 op init (map rest seqs)))))

(defn accumulate-n-v2
  [op init seqs]
  (loop [colls seqs
         acc '()]
    (if (-> colls first seq)
      (let [heads (map first colls)
            tails (map rest  colls)]
        (recur tails
               (cons (reduce op init heads)
                     acc)))
      (reverse acc))))
