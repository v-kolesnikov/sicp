(ns sicp.chapter02.2-66)

(defn lookup
  [given-key set-of-records]
  (loop [[{id :id :as entry} l-branch r-branch :as tree] set-of-records]
    (cond (empty? tree) nil
          (= given-key id) entry
          (< given-key id) (recur l-branch)
          (> given-key id) (recur r-branch))))
