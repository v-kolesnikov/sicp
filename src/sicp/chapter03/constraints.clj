(ns sicp.chapter03.constraints)

(defn error
  [& args]
  (throw (Exception. (apply str args))))

(defn has-value? [connector] (connector :has-value?))
(defn get-value  [connector] (connector :value))

(defn set-value!
  [connector value informant]
  ((connector :set-value!) value informant))

(defn forget-value!
  [connector retractor]
  ((connector :forget) retractor))

(defn connect
  [connector constraint]
  ((connector :connect) constraint))

(defn for-each-except
  [exception procedure coll]
  (loop [[x & xs :as items] coll]
    (cond (empty? items) :done
          (= x exception) (recur xs)
          :else (do (procedure x)
                    (recur xs)))))

(defn inform-about-value [constraint]
  (constraint :I-have-a-value))

(defn inform-about-no-value [constraint]
  (constraint :I-lost-my-value))

(defn make-connector []
  (let [value (atom nil)
        counter (atom 0)
        informant (atom nil)
        constraints (atom [])]
    (letfn [(set-my-value [newval setter]
              (cond (not (has-value? me))
                    (do (reset! value newval)
                        (reset! informant setter)
                        (for-each-except setter
                                         inform-about-value
                                         @constraints))

                    (not (= @value newval)) (error "Error" [@value newval])
                    :else :ignored))
            (forget-my-value [retractor]
                             (if (= retractor @informant)
                               (do (reset! informant false)
                                   (for-each-except retractor
                                                    inform-about-no-value
                                                    @constraints))
                               :ignored))
            (connect [new-constraint]
                     (swap! counter inc)
                     (if-not (some #(= % new-constraint) @constraints)
                       (swap! constraints conj new-constraint))
                     (if (has-value? me)
                       (inform-about-no-value new-constraint))
                     :done)
            (me [request]
                (cond (= request :has-value?) (if @informant true false)
                      (= request :value) @value
                      (= request :set-value!) set-my-value
                      (= request :forget) forget-my-value
                      (= request :connect) connect
                      :else (error "Unknown operation -- CONNECTOR" request)))]
      me)))

(defn constant
  [value connector]
  (letfn [(me [request]
            (error "Unknown request -- CONSTANT" request))]
    (connect connector me)
    (set-value! connector value me)
    me))

(defn adder
  [a1 a2 sum]
  (letfn [(process-new-value []
            (let [new-sum (fn [] (+ (get-value a1) (get-value a2)))
                  new-a2 (fn [] (- (get-value sum) (get-value a1)))
                  new-a1 (fn [] (- (get-value sum) (get-value a2)))]
              (cond (and (has-value? a1) (has-value?  a2)) (set-value! sum (new-sum) me)
                    (and (has-value? a1) (has-value? sum)) (set-value! a2 (new-a2) me)
                    (and (has-value? a2) (has-value? sum)) (set-value! a1 (new-a1) me))))
          (process-forget-value []
                                (forget-value! sum me)
                                (forget-value! a1 me)
                                (forget-value! a2 me)
                                (process-new-value))
          (me [request]
              (cond (= request :I-have-a-value) (process-new-value)
                    (= request :I-lost-my-value) (process-forget-value)
                    :else (error "Unknown request -- ADDER" request)))]
    (connect a1 me)
    (connect a2 me)
    (connect sum me)
    me))

(defn multiplier
  [m1 m2 product]
  (letfn [(process-new-value []
            (cond (or (and (has-value? m1) (zero? (get-value m1)))
                      (and (has-value? m2) (zero? (get-value m2))))
                  (set-value! product 0 me)

                  (and (has-value? m1) (has-value? m2))
                  (set-value! product (* (get-value m1) (get-value m2)) me)

                  (and (has-value? product) (has-value? m1))
                  (set-value! m2 (/ (get-value product) (get-value m1)) me)

                  (and (has-value? product) (has-value? m2))
                  (set-value! m1 (/ (get-value product) (get-value m2)) me)))
          (process-forget-value []
                                (forget-value! product me)
                                (forget-value! m1 me)
                                (forget-value! m2 me)
                                (process-new-value))
          (me [request]
              (cond (= request :I-have-a-value) (process-new-value)
                    (= request :I-lost-my-value) (process-forget-value)
                    :else (error "Unknown request -- MULTIPLIER" request)))]
    (connect m1 me)
    (connect m2 me)
    (connect product me)
    me))

(defn probe
  [name connector]
  (letfn [(print-probe [value]
            (println (str "Probe: " name " = " value)))
          (process-new-value [] (print-probe (get-value connector)))
          (process-forget-value [] (print-probe "?"))
          (me [request] (cond (= request :I-have-a-value) (process-new-value)
                              (= request :I-lost-my-value) (process-forget-value)
                              :else (error "Unknown request -- PROBE" request)))]
    (connect connector me)
    me))

(defn celsius-fahrenheit-converter
  [celsius-connector fahrenheit-connector]
  (let [u (make-connector)
        v (make-connector)
        w (make-connector)
        x (make-connector)
        y (make-connector)]
    (multiplier celsius-connector w u)
    (multiplier v x u)
    (adder v y fahrenheit-connector)
    (constant 9 w)
    (constant 5 x)
    (constant 32 y)
    :ok))
