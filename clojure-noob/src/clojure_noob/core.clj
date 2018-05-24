(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "foobar123")
  (println "asdasdasod"))

(defn train
  []
  (println "Choo choo!"))

(defn foo
  []
  (println "bar"))

(defn bar
  []
  (println "foo"))

(defn foobar
  []
  (println "foobar"))

(defn foobar123
  []
  (println "foobar123"))

(if true
  (do (println "success")
      "by zeus's hammer")
  (do (println "failure")
      "by aquaman trident"))

(when true
  (println "success in do")
  "abra cadabra")

(if "bar"
  (println "barbar"))

(if (or false false)
    (println "true in or")
    (println "false in or"))

(def foo
  "yashiro")

(defn get-name
  [name]
  (println name))

(defn error-message
  [severity]
  (str "oh god, disaster! we're "
       (if (= severity :mild)
         "ok"
         "fucked")))

(def lil-map
  {"foo" 1})
(def big-map
  (hash-map :a 1 :b 2))

(def u
  (get {:a 0 :b 1} :c "unicorn")) ;; if nil get "unicorn"
(def y
  (:a {:a 0 :b 1}))

(def i
  (get [3 2 1] 0))

(def vectu
  (vector "creep" "blood"))
(def vectu2
  [1 2 3])
(def vectu3
  (conj vectu2 "foobar"))


(def lil-list
  '(1 2 3))
(def lil-set
  #{"foobar" 20 :s})
(def big-set
  (hash-set 1 1 2 2))


(defn too-enthusiastic
  "return a cheer that might be a bit too enthusiastic"
  [name]
  (str "Oh my " name))


(defn multi-arity
  ([n1 n2]
   (+ n1 n2))
  ([n1 n2 n3]
   (* n1 n2 n3))
  ([n1 n2 n3 n4]
   (- n1 n2 n3 n4)))


(defn multi-arity-2
  ([n1 n2]
   (println "2"))
  ([n1 n2 n3]
   (println "3"))
  ([n1 n2 n3 n4]
   (println "4")))

(defn add-space
  [name]
  (str name " "))

(defn get-them-all
  [& names]
  (clojure.string/join " " names))

(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println first-choice)
  (println second-choice)
  (println (clojure.string/join ", " unimportant-choices)))

(defn announce-treasure-location
  [{lat :lat lng :lng}]
  (println lat)
  (println lng))

(defn announce-treasure-location-2
  [{:keys [lat lng]}]
  (println lat)
  (println lng))

(defn announce-treasure-location-3
  [{:keys [lat lng] :as treasure-location}]
  (println lat)
  (println lng)
  (println treasure-location))

(defn get-magoo
  [[& names]]
  (map (fn [name] (str "cat " name)) names))

(def my-special-multiplier (fn [x] (* x 3)))
(def my-special-multiplier-2 #(* % 3)) ; % is the input variable

;; Hobbit violence!
(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])


(defn matching-part
  [part]
  { :name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})


;; inifinite loop
(defn inifnite-loop
  []
  (loop [iteration 0]
    (println iteration)
    (recur (inc iteration))))


(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  ;; remaining-asym-parts is asym-body-parts
  ;; final-body-parts is []
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      ;; if true return final-body-part
      final-body-parts
      ;; else process all entire shit
      (let [[part & remaining] remaining-asym-parts],
        ;; calls the same function again with new args, in this case loop as function target
        (recur remaining
               (into final-body-parts ;; merge vector with set and return the first type
                     (set [part (matching-part part)])))))))


;;(symmetrize-body-parts asym-hobbit-body-parts)


(defn try-loop
  [body-parts]
  (loop [body-parts body-parts]
    (if (empty? body-parts)
      (println body-parts))))

(try-loop [{:name "julio" :size 123}])

(defn try-loop-2
  [body-parts]
  (loop [body-parts body-parts]
    (if (empty? body-parts)
      (println body-parts)
      (let [[part & remaining] body-parts]
        (recur remaining)))))

(defn foo-loop
  [count]
  (if (< count 10)
    (do
      (println count)
      (recur (+ count 1)))
    count))

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part] ;; acc, part
            (into final-body-parts ;; merge this part
                  (set [part (matching-part part)]))) ;; with this part 
          [] ;; as final-body-parts
          asym-body-parts)) ;; as asym-body-parts


(defn hit
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (println accumulated-size)
      (println part)
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))

;; (def dec9 (dec-maker 9))
;; (dec9 10)
;; (mapset inc [1 1 2 2]) ;; #{2 3}


(defn filter-reduce
  [new-map]
  (let [filter-reduce-fn (fn [acc, coll]
          (if (> (coll 1) 123)
            (assoc acc (coll 0) (coll 1))
            acc))]
    (reduce filter-reduce-fn {} new-map)))


(defn filter-reduce-2
  [new-map]
  (let [filter-reduce-fn (fn [acc, coll] (println (coll 0)))]
        (reduce filter-reduce-fn {} new-map)))
