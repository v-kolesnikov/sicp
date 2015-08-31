(ns sicp.chapter01.1-03)

(defn solution
  [a b c]
  (letfn [(square [x]
            (* x x))]
    (+ (square (max a
                    b))
       (square (max b
                    c)))))
