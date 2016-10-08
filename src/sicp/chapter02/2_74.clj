(ns sicp.chapter02.2-74
  (:refer-clojure :exclude [get])
  (:require [sicp.common.pairs :as p]))

(def dispatch-table (atom (list)))

(defn attach-tag
  [type-tag contents]
  (p/cons type-tag contents))

(defn make-table-item
  [op tag item]
  (p/cons op (attach-tag tag item)))

(defn operation
  [item]
  (p/car item))

(defn tag
  [item]
  (p/car (p/cdr item)))

(defn contents
  [item]
  (p/cdr (p/cdr item)))

(defn put
  [op tag item]
  (let [method (make-table-item op tag item)]
    (swap! dispatch-table conj method)))

(defn get
  [op t]
  (loop [[item & table] @dispatch-table]
    (cond (nil? item) false
          (and (= (operation item) op)
               (= (tag item) t)) (contents item)
          :else (recur table))))

(defn apply-generic
  [op & [t & args]]
  (apply (get op t) args))

; Generic operations
(defn get-record
  [dep name]
  (apply-generic 'get-record dep name))

(defn get-salary
  [dep name]
  (let [employee (get-record dep name)]
    (apply-generic 'get-salary dep employee)))

(defn find-employee-record
  [files name]
  (->> files
       (keep #(get-record %1 name))
       first))

; Engeneering departament package
(defn install-engineering-department []
  (letfn [(make-employee
            [name position salary]
            (p/cons name (p/cons position salary)))

          (get-name
           [employee]
           (p/car employee))

          (get-position
           [employee]
           (p/car (p/cdr employee)))

          (get-salary
           [employee]
           (p/cdr (p/cdr employee)))

          (employees
           []
           (list (make-employee 'Hugo 'junior 60000)
                 (make-employee 'Alyssa 'senior 90000)
                 (make-employee 'Eva 'lead 100000)
                 (make-employee 'Ben 'senior 110000)))

          (get-employee
           [name]
           (letfn [(find-employee [[person & others]]
                     (cond (nil? person) nil
                           (= name (get-name person)) person
                           :else (find-employee others)))]
             (find-employee (employees))))]
    (put 'get-record 'engineering get-employee)
    (put 'get-salary 'engineering get-salary)
    'done))

; Sales departament package
(defn install-sales-department []
  (letfn [(make-record [name salary experience]
            (list 'employee name salary experience))

          (get-record-name
           [[_ name & _]]
           name)

          (get-record-salary
           [[_ _ salary & _]]
           salary)

          (get-record-experience
           [[_ _ _ exp]]
           exp)

          (get-salesman
           [who]
           (cond (= who 'Mike) (make-record 'Mike 200000 5)
                 (= who 'Jennifer) (make-record 'Jennifer 180000 3)
                 (= who 'Scott) (make-record 'Scott 250000 10)
                 :else nil))]
    (put 'get-record 'sales get-salesman)
    (put 'get-salary 'sales get-record-salary)
    'done))
