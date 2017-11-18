(ns sicp.chapter03.wirelang)

; Wire

(defn call-each
  [procs]
  (if-not (empty? procs)
    (do ((first procs))
        (call-each (rest procs)))
    :done))

(defn make-wire []
  (let [signal-value (atom 0)
        action-procs (atom [])]
    (letfn [(set-signal! [value]
              {:pre [(contains? [0 1] value)]}
              (if-not (= @signal-value value)
                (do (reset! signal-value value)
                    (call-each @action-procs))
                :done))
            (accept-action-proc! [proc]
                                 (swap! action-procs conj proc)
                                 (proc))]
      {:get-signal (fn [] @signal-value)
       :set-signal! set-signal!
       :add-action! accept-action-proc!
       :actions (fn [] @action-procs)})))

(defn get-signal [wire] ((wire :get-signal)))
(defn set-signal! [wire signal] ((wire :set-signal!) signal))
(defn add-action! [wire action] ((wire :add-action!) action))

; Queue
(defn make-queue
  ([] (atom clojure.lang.PersistentQueue/EMPTY))
  ([items] (atom (reduce conj clojure.lang.PersistentQueue/EMPTY items))))

(defn delete-queue! [queue] (swap! queue pop))
(defn insert-queue! [queue item] (swap! queue conj item))
(defn empty-queue?  [queue] (empty? @queue))
(defn front-queue   [queue] (peek @queue))

; Segments
(defn make-time-segment [t queue] {:time t :queue queue})
(defn segment-time [segment] (:time segment))
(defn segment-queue [segment] (:queue segment))

; Agenda
(defn make-agenda [] (atom {:time 0, :segments []}))
(defn segments [agenda] (:segments @agenda))
(defn current-time [agenda] (:time @agenda))
(defn empty-agenda? [agenda] (empty? (segments agenda)))

(defn set-current-time! [agenda t]
  (swap! agenda assoc :time t))

(defn set-segments! [agenda segments]
  (swap! agenda assoc :segments segments))

(defn first-segment [agenda] (first (segments agenda)))
(defn rest-segments [agenda] (rest (segments agenda)))

(defn first-agenda-item [agenda]
  (if (empty-agenda? agenda)
    (throw (Exception.  "Agenda is empty -- FIRST-AGENDA-ITEM"))
    (let [first-seg (first-segment agenda)]
      (set-current-time! agenda (segment-time first-seg))
      (front-queue (segment-queue first-seg)))))

(defn remove-first-agenda-item! [agenda]
  (if (empty-agenda? agenda)
    (throw (Exception.  "Agenda is empty -- FIRST-AGENDA-ITEM"))
    (let [queue (segment-queue (first-segment agenda))]
      (delete-queue! queue)
      (if (empty-queue? queue)
        (set-segments! agenda (rest-segments agenda))))))

(defn add-to-agenda!
  [agenda timestamp action]
  (if-let [same-time-segment (some #(when (= timestamp (:time %)) %)
                                   (segments agenda))]
    (insert-queue! (:queue same-time-segment) action)
    (set-segments! agenda
                   (concat (take-while #(> timestamp (:time %)) (segments agenda))
                           (list (make-time-segment timestamp (make-queue [action])))
                           (drop-while #(> timestamp (:time %)) (segments agenda))))))

(def the-agenda (make-agenda))
(def inverter-delay 2)
(def and-gate-delay 3)
(def or-gate-delay 5)

(defn after-delay
  [delay-time action]
  (add-to-agenda! the-agenda
                  (-> the-agenda current-time (+ delay-time))
                  action))

(defn propagate []
  (if (empty-agenda? the-agenda)
    :done
    (let [first-item (first-agenda-item the-agenda)]
      (first-item)
      (remove-first-agenda-item! the-agenda)
      (propagate))))

; Binary logic
(defn logical-not
  [signal]
  (cond (= signal 0) 1
        (= signal 1) 0
        :else (throw (Exception. (str "Unknown signal" signal)))))

(defn logical-and
  [s1 s2]
  (if (= 1 s1 s2) 1 0))

(defn logical-or
  [s1 s2]
  (if (or (= 1 s1) (= 1 s2)) 1 0))

; Elements
(defn inverter
  [input output]
  (let [invert-input
        (fn []
          (let [value (logical-not (get-signal input))
                proc (after-delay inverter-delay
                                  (fn [] (set-signal! output value)))]
            (after-delay inverter-delay
                         (fn [] (set-signal! output value)))))]
    (add-action! input invert-input)
    :ok))

(defn and-gate
  [a1 a2 output]
  (let [and-proc
        (fn []
          (let [value (logical-and (get-signal a1)
                                   (get-signal a2))]
            (after-delay and-gate-delay
                         (fn [] (set-signal! output value)))))]
    (add-action! a1 and-proc)
    (add-action! a2 and-proc)
    :ok))

(defn or-gate
  [a1 a2 output]
  (let [or-proc
        (fn []
          (let [value (logical-or (get-signal a1)
                                  (get-signal a2))]
            (after-delay or-gate-delay
                         (fn [] (set-signal! output value)))))]
    (add-action! a1 or-proc)
    (add-action! a2 or-proc)
    :ok))

(defn half-adder
  [a b s c]
  (let [d (make-wire)
        e (make-wire)]
    (or-gate  a b d)
    (and-gate a b c)
    (inverter c e)
    (and-gate d e s)
    :ok))

(defn full-adder
  [a b c-in c-out sum]
  (let [s (make-wire)
        c1 (make-wire)
        c2 (make-wire)]
    (half-adder b c-in s c1)
    (half-adder a s sum c2)
    (or-gate c1 c2 c-out)
    :ok))

(defn probe [name wire]
  (add-action! wire
               (fn []
                 (println name
                          (current-time the-agenda)
                          "New-value ="
                          (get-signal wire)))))

(comment
  (let []
    (def the-agenda (make-agenda))

    (def input-1 (make-wire))
    (def input-2 (make-wire))
    (def sum (make-wire))
    (def carry (make-wire))

    (probe 'sum sum)
    (probe 'carry carry)

    (half-adder input-1 input-2 sum carry)

    (set-signal! input-1 1)
    (propagate)

    (assert (= 1 (get-signal sum)))
    (assert (= 0 (get-signal carry)))
    (assert (= 8 (current-time the-agenda)))

    (set-signal! input-2 1)
    (propagate)

    (assert (= 0 (get-signal sum)))
    (assert (= 1 (get-signal carry)))
    (assert (= 16 (current-time the-agenda)))))
