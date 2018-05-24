(ns test-aj07mm.core
  (:gen-class))

(defn bar
  [acc]
  (if (>= (last acc) 3)
    "yes"
    "no"))

(defn build-vector [m]
  (loop [acc [1]
          n 1]
    (if (>= n m)
      acc
      (recur (conj acc (* n 2)) (* n 2)))))


(defn build-vector-2 [n]
    (loop [acc []
           m 0]
          (if (>= m n)
            acc
            (recur (conj acc m) (inc m)))))

(defn build-a-vector [n]
  (let [stop n]
    (loop [i 0
           acc []]
      (if (= i stop)
        acc
        (recur (inc i) (conj acc i))))))

(defn get-multiples-of
  [n]
  (iterate #(* n %) 1))

(defn forfor
  [coll]
  (for [x coll]
    (inc x)))

(def multiples (take-while #(< % 30) (get-multiples-of 2)))
(defn -main
  []
  (println (map inc [1 2 3 4])))
