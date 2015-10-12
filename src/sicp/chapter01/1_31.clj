(ns sicp.chapter01.1-31)

(defn product-recursive
  [term a next-element b]
  (if (> a b)
    1
    (* (term a)
       (product-recursive term
                          (next-element a)
                          next-element
                          b))))

(defn product
  [term a next-term b]
  (letfn [(iter [a acc]
            (if (> a b)
              acc
              (iter (next-term a) (* acc (term a)))))]
    (iter a 1)))

(defn factorial
  [n]
  (product identity 1 inc n))

(defn wallis-range
  [n]
  (float (product #(/ (* (dec %) (inc %)) (* % %)) 3 #(+ 2 %) n)))

(defn pi
  ([]
   (pi 1111))
  ([n]
   (* 4
      (wallis-range n))))
