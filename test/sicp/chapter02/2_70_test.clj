(ns sicp.chapter02.2-70-test
  (:require [clojure.string :as s]
            [clojure.test :refer [deftest]]
            [sicp.chapter02.2-67 :as sicp-2-67]
            [sicp.chapter02.2-68 :as sicp-2-68]
            [sicp.chapter02.2-70 :as sicp-2-70]
            [sicp.test-helper :refer [assert-equal]]))

(def song-message
  (->> '(Get a job
             Sha na na na na na na na na
             Get a job
             Sha na na na na na na na na
             Wah yip yip yip yip yip yip yip yip yip
             Sha boom)
       (map (comp symbol s/upper-case))))

(deftest test-rock-songs-alphabet
  (let [tree sicp-2-70/rock-songs-alphabet
        encoded-message (sicp-2-68/encode tree song-message)]
    (assert-equal '(1 1 1 1 1 1 1 1 1 0 1 1 0 0 1 1 1 0 0 0 0 0
                      0 0 0 0 1 1 1 1 1 1 1 1 1 0 1 1 0 0 1 1 1
                      0 0 0 0 0 0 0 0 0 1 1 0 1 1 1 0 1 0 1 0 1
                      0 1 0 1 0 1 0 1 0 1 0 1 1 1 0 1 1 0 1 0)
                  encoded-message)
    (assert-equal song-message (sicp-2-67/decode encoded-message tree))
    (assert-equal 84 (count encoded-message))
    (assert-equal 108 (* 3 (count song-message)))))
