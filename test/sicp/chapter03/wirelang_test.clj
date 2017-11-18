(ns sicp.chapter03.wirelang-test
  (:require [clojure.test :refer :all]
            [sicp.chapter03.wirelang :refer :all]))

(deftest test-call-each
  (is (let [results (atom [])
            procs [(fn [] (swap! results conj "Ho-ho!"))
                   (fn [] (swap! results conj "Ha-ha!"))]]
        (call-each procs)
        (= @results ["Ho-ho!" "Ha-ha!"]))))

(deftest test-make-wire
  (is (let [wire (make-wire)]
        (zero? (get-signal wire))))
  (is (let [wire (make-wire)]
        (set-signal! wire 1)
        (= 1 (get-signal wire))))
  (is (let [wire (make-wire)
            counter (atom 0)]
        (add-action! wire (fn [] (swap! counter inc)))
        (set-signal! wire 1)
        (= 2 @counter))))

(deftest test-queue
  (is (let [queue (make-queue)]
        (empty-queue? queue)))
  (is (let [queue (make-queue)]
        (nil? (front-queue queue))))

  (let [queue (make-queue [1 2 3])]
    (is (= 1 (front-queue queue)))
    (delete-queue! queue)
    (is (= 2 (front-queue queue)))
    (delete-queue! queue)
    (is (= 3 (front-queue queue))))

  (let [queue (make-queue)
        proc1 (fn [] nil)
        proc2 (fn [] nil)]
    (insert-queue! queue proc1)
    (is (= proc1 (front-queue queue)))
    (insert-queue! queue proc2)
    (is (= proc1 (front-queue queue)))
    (delete-queue! queue)
    (is (= proc2 (front-queue queue)))))

(deftest test-make-agenda
  (is (let [agenda (make-agenda)]
        (empty-agenda? agenda)))
  (is (let [agenda (make-agenda)]
        (= [] (segments agenda))))
  (is (let [agenda (make-agenda)]
        (zero? (current-time agenda))))
  (is (let [agenda (make-agenda)]
        (set-current-time! agenda 2)
        (= 2 (current-time agenda))))
  (is (let [agenda (make-agenda)]
        (set-segments! agenda [{:time 2, :queue []}])
        (= [{:time 2 :queue []}] (segments agenda)))))

(deftest test-first-agenda-item
  (is (thrown? Exception (first-agenda-item (make-agenda))))

  (let [agenda (make-agenda)
        noop-fn (fn [] nil)
        segment (let [queue (make-queue)]
                  (insert-queue! queue noop-fn)
                  (make-time-segment 2 queue))]
    (set-segments! agenda [segment])
    (is (= 0 (current-time agenda)))
    (is (= noop-fn (first-agenda-item agenda)))
    (is (= 2 (current-time agenda)))))

(deftest test-remove-first-agenda-item!
  (is (thrown? Exception (remove-first-agenda-item! (make-agenda))))

  ; When agenda has one segment with one action
  (let [agenda (make-agenda)
        noop-fn (fn [] nil)
        segment (let [queue (make-queue)]
                  (insert-queue! queue noop-fn)
                  (make-time-segment 1 queue))]
    (set-segments! agenda [segment])
    (remove-first-agenda-item! agenda)
    (is (empty-agenda? agenda)))

  ; When agenda has one segment with two actions
  (let [agenda (make-agenda)
        noop-fn1 (fn [] nil)
        noop-fn2 (fn [] nil)
        segment (let [queue (make-queue)]
                  (insert-queue! queue noop-fn1)
                  (insert-queue! queue noop-fn2)
                  (make-time-segment 2 queue))]
    (set-segments! agenda [segment])
    (remove-first-agenda-item! agenda)
    (is (not (empty-agenda? agenda)))
    (is (= noop-fn2 (first-agenda-item agenda))))

  ; When agenda has two segments
  (let [agenda (make-agenda)
        noop-fn1 (fn [] nil)
        noop-fn2 (fn [] nil)
        segment1 (let [queue (make-queue)]
                   (insert-queue! queue noop-fn1)
                   (make-time-segment 1 queue))
        segment2 (let [queue (make-queue)]
                   (insert-queue! queue noop-fn2)
                   (make-time-segment 2 queue))]
    (set-segments! agenda [segment1 segment2])
    (remove-first-agenda-item! agenda)
    (is (not (empty-agenda? agenda)))
    (is (= [segment2] (segments agenda)))
    (is (= noop-fn2 (first-agenda-item agenda)))))

(deftest test-add-to-agenda!
  ; When agenda has no any segments
  (let [agenda (make-agenda)]
    (add-to-agenda! agenda 1 (fn [] :noop))
    (is (= 1 (-> agenda segments count))))

  ; When agenda has same time segment
  (let [agenda (make-agenda)]
    (set-segments! agenda [(make-time-segment 1 (make-queue))])
    (add-to-agenda! agenda 1 (fn [] :noop))
    (is (= 1 (-> agenda segments count)))
    (is (= :noop ((first-agenda-item agenda)))))

  ; When agenda has segments with other time
  (let [agenda (make-agenda)]
    (set-segments! agenda [(make-time-segment 1 (make-queue))
                           (make-time-segment 3 (make-queue))])
    (add-to-agenda! agenda 2 (fn [] nil))
    (is (= 3 (-> agenda segments count)))))

(deftest test-full-adder
  (let [input-a (make-wire)
        input-b (make-wire)
        carry-input (make-wire)
        carry-output (make-wire)
        output-sum (make-wire)]
    (full-adder input-a
                input-b
                carry-input
                carry-output
                output-sum)
    (set-signal! input-a 1)
    (set-signal! input-b 1)
    (propagate)
    (is (= 0 (get-signal output-sum)))
    (is (= 1 (get-signal carry-output)))))
