(ns sicp.chapter02.2-63)

(defn entry [tree] (first tree))
(defn left-branch [[_ left _]] left)
(defn right-branch [[_ _ right]] right)
(defn make-tree [entry left right]
  (list entry left right))

(defn tree->list-1
  [tree]
  (if (empty? tree)
    '()
    (concat (tree->list-1 (left-branch tree))
            (cons (entry tree)
                  (tree->list-1 (right-branch tree))))))

(defn tree->list-2
  [tree]
  (letfn [(copy-to-list [tree result-list]
            (if (empty? tree)
              result-list
              (copy-to-list (left-branch tree)
                            (cons (entry tree)
                                  (copy-to-list (right-branch tree)
                                                result-list)))))]
    (copy-to-list tree '())))
