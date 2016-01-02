(ns sicp.chapter02.2-11
  (:require [sicp.chapter02.2-07 :as sicp-2-07]))

(defn mul-interval
  [x y]
  (let [xl (sicp-2-07/lower-bound x)
        xu (sicp-2-07/upper-bound x)
        yl (sicp-2-07/lower-bound y)
        yu (sicp-2-07/upper-bound y)]
    (cond (>= xl 0) (cond (>= yl 0) (sicp-2-07/make-interval (* xl yl)
                                                             (* xu yu))
                          (<= yu 0) (sicp-2-07/make-interval (* xu yl)
                                                             (* xl yu))
                          :else (sicp-2-07/make-interval (* xu yl)
                                                         (* xu yu)))
          (<= xu 0) (cond (>= yl 0) (sicp-2-07/make-interval (* xl yu)
                                                             (* xu yl))
                          (<= yu 0) (sicp-2-07/make-interval (* xu yu)
                                                             (* xl yl))
                          :else (sicp-2-07/make-interval (* xl yu)
                                                         (* xl yl)))
          :else (cond (>= yl 0) (sicp-2-07/make-interval (* xl yu)
                                                         (* xu yu))
                      (<= yu 0) (sicp-2-07/make-interval (* xu yl)
                                                         (* xl yl))
                      :else (sicp-2-07/make-interval (min (* xl yu)
                                                          (* xu yl))
                                                     (max (* xl yl)
                                                          (* xu yu)))))))
