(ns fwpd.core)
(def filename "suspects.csv")

; first param: (cycle [inc identity])
; second param: [1 2 3 4 ...]
; (map #(%1 %2) (cycle [inc identity]) [1 2 3 4 5 6 7 8 9 10])

;;(defn -main
;;  "I don't do a whole lot ... yet."
;;  [& args]
;;  (println "Hello, World!"))

(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

; (map vector [1 2 3] [4 5 6])
; (map (fn[a, b] [a b]) [1 2 3] [ 4 5 6])

;(defn foo
;  ([vals] (sum vals 0))
;  ([vals acc]
;   (sum [1 2 3])))

;(defn sum-foo
;  ([vals] (sum vals 0)) 
;  ([vals accumulating-total]
;   (if (empty? vals)  
;     accumulating-total
;     (sum (rest vals) (+ (first vals) accumulating-total)))))

;(defn sum-foo-2
;  ([vals] (sum vals 0)) 
;  ([vals accumulating-total]
;   (10)))


(defn sum-foo
  ([vals] []) 
  ([vals accumulating-total]
   10))

(defn string->integer 
  ([s] (string->integer s 10))
  ([s base] (Integer/parseInt s base)))


(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})
(def c-int (comp :intelligence :attributes))
(def c-str (comp :strength :attributes))
(def c-dex (comp :dexterity :attributes))

(c-int character)
; => 10

(c-str character)
; => 4

(c-dex character)
; => 5


(fn [c] (:strength (:attributes c)))

(defn spell-slots
  [char]
  (int (inc (/ (c-int char) 2))))

(spell-slots character)
; => 6

(def spell-slots-comp (comp int inc #(/ % 2) c-int))

(defn two-comp
  [f g]
  (fn [& args]
    (f (apply g args))))
