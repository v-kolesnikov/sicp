(ns sicp.chapter02.2-29)

(defn make-mobile
  [left right]
  (list left right))

(defn make-branch
  [lenght structure]
  (list lenght structure))

(defn left-branch
  [mobile]
  (first mobile))

(defn right-branch
  [mobile]
  (second mobile))

(defn branch-lenght
  [branch]
  (first branch))

(defn branch-structure
  [branch]
  (second branch))

(def mobile? list?)

(defn total-weight
  [mobile]
  (let [left (left-branch mobile)
        right (right-branch mobile)
        branch-weight (fn [branch]
                        (let [structure (branch-structure branch)]
                          (if (mobile? structure)
                            (total-weight structure)
                            structure)))]
    (+ (branch-weight left)
       (branch-weight right))))
