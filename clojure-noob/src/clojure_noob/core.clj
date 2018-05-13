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
