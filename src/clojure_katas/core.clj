(ns clojure-katas.core
  (:require [clojure.string :as string]))

(defn divides? [input divider]
  (= (mod input divider) 0))

(defn fizzBuzz [input]
  (cond
    (zero? input) 0
    (divides? input 15) "fizzbuzz"
    (divides? input 3) "fizz"
    (divides? input 5) "buzz"
    :else input))

(defn primeFactors [input]
  0)

(defn factorial [input]
  (cond (zero? input) 1
        :else
        (* input (factorial (- input 1)))))

(defn spop [])
  

(defn add100 [number]
  (+ number 100))

(defn dec-maker
  [toDec]
  #(- % toDec))

(defn mapset
  [operation & input]
  (hash-set (map operation input)))

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
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))

(defn matching-part-alien
  [part]
  (hash-set
    {:name (:name part)
     :size (:size part)}
    {:name (clojure.string/replace (:name part) #"^left-" "right-")
     :size (:size part)}
    {:name (clojure.string/replace (:name part) #"^left-" "down-")
     :size (:size part)}
    {:name (clojure.string/replace (:name part) #"^left-" "up-")
     :size (:size part)}
    {:name (clojure.string/replace (:name part) #"^left-" "middle-")
     :size (:size part)}))
(defn multiples3And5 [number]
   (reduce + (filter #(or (divides? % 3) (divides? % 5)) (range 1 number))))

(defn fibonacciNumber [number]
  (if (or (= number 1) (= number 2) (= number 0))
    number
    (+ (fibonacciNumber (- number 1)) (fibonacciNumber (- number 2)))))

(def fib-seq
  ((fn rfib [a b]
     (lazy-seq (cons a (rfib b (+ a b)))))
   0 1))

(defn fib [start range]
  "Creates a vector of fibonnaci numbers"
  (if (<= range 0)
    start
    (recur (let[subvector (subvec start (- (count start) 2))
                x (nth subvector 0)
                y (nth subvector 1)
                z (+ x y)]
             (conj start z))
           (- range 1))))

(defn fib-step [[a b]]
  [b (+ a b)])

(defn fib-seq []
  (map first (iterate fib-step [0 1])))

(defn sumOfEvenFibonacciNumbers [max]
  (reduce + (filter even? (take max (fib-seq)))))

(def vampire-database
  {0 {:makes-blood-puns? false, :has-pulse? true :name "McFishwich"}
   1 {:makes-blood-puns? false, :has-pulse? true :name "McMackson"}
   2 {:makes-blood-puns? true, :has-pulse? false :name "Damon Salvatore"}
   3 {:makes-blood-puns? true, :has-pulse? true :name "Mickey Mouse"}})

(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))

(defn vampire?
  [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record))
       record))

(defn identify-vampire
  [social-security-numbers]
  (first (filter vampire?
                 (map vampire-related-details social-security-numbers))))

(defn- alternate-char-case
  [s]
  (if (= (str s) (string/upper-case s))
    (string/lower-case s)
    (string/upper-case s)))
    

(defn alternate-case [s]
  (apply str (map alternate-char-case (seq s))))

(defn- update-string-at [input index]
  (apply str (update (vec input) index #(Character/toUpperCase %))))

(defn- get-non-space-char-indexes [input]
  (filter #(Character/isLetter (nth input %)) (range (count input))))

(defn wave [input]
    (map #(update-string-at input %)
        (get-non-space-char-indexes input)))
         ;; (let [indexes (get-non-space-char-indexes input)]
         ;;   (if (seq indexes)
         ;;     indexes
         ;;     '(0))))))

(def ^:const conversion-multiplier (/ 1000 3600))
(def ^:const gravitational-constant 9.81)

(defn km-h=>m-s [speed]
  (float (* speed conversion-multiplier)))

(defn ball-height [time speed-in-km-h]
  (let [t (* 0.1 time)]
    (- (* (km-h=>m-s speed-in-km-h) t)
       (* 0.5 t t gravitational-constant))))
  
(defn max-ball [speed-in-km-h]
  (let [heights
        (take-while
               #(<= 0 %)
               (map #(ball-height % speed-in-km-h) (range)))]
      (.indexOf heights (apply max heights))))  

(defn squares-till
  [max-val]
  (map #(* % %) (range (inc max-val))))

(defn nb-dig [max-val digit]
  (count (filter #{(.charAt (str digit) 0)} (apply str (squares-till max-val)))))

(defn scale [strng hor ver]
  "")
