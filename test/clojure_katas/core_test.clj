(ns clojure-katas.core-test
  (:require
   [clojure-katas.core :refer :all]
   [midje.sweet :refer [facts fact provided => roughly anything]]))

(facts "test fizz buzz"
       (fact "zero"
             (fizzBuzz 0) => 0)
       (fact "one"
             (fizzBuzz 1) => 1)
       (fact "fizz"
             (fizzBuzz 3) => "fizz")
       (fact "buzz"
             (fizzBuzz 5) => "buzz")
       (fact "fizz multiple"
             (fizzBuzz 6) => "fizz")
       (fact "buzz multiple"
             (fizzBuzz 10) => "buzz")
       (fact "fizzBuzz"
             (fizzBuzz 15) => "fizzbuzz"))

(facts "test factorial"
       (fact "1"
             (factorial 1) => 1)
       (fact "2"
             (factorial 2) => 2)
       (fact "3"
             (factorial 3) => 6)
       (fact "4"
             (factorial 4) => 24))

(facts "test stack"
       (fact "pop empty stack returns empty"
             (spop) => nil)
       (fact "pop with one element return element"))
             ;(push 0)
             ;(spop) => 0

(facts "test multiple 3 and 5"
       (fact "given 0"
             (multiples3And5 0) => 0)
       (fact "given 1"
             (multiples3And5 1) => 0)
       (fact "given 3"
             (multiples3And5 3) => 0)
       (fact "given 4"
             (multiples3And5 4) => 3)
       (fact "given 5"
             (multiples3And5 5) => 3)
       (fact "given 6"
             (multiples3And5 6) => 8)
       (fact "given 10 returns 23"
             (multiples3And5 10) => 23))

(facts "test equal sum of fibonacci numbers"
       (fact "given 0"
             (sumOfEvenFibonacciNumbers 0) => 0)
       (fact "given 1"
             (sumOfEvenFibonacciNumbers 1) => 0)
       (fact "given 2"
             (sumOfEvenFibonacciNumbers 2) => 0)
       ;; (fact "given 3"
       ;;       (sumOfEvenFibonacciNumbers 3) => 2)
       (fact "given 11"
             (sumOfEvenFibonacciNumbers 11) => 44))

(facts "test fibonacci number"
       (fact "given 0"
             (fibonacciNumber 0) => 0)
       (fact "given 1"
             (fibonacciNumber 1) => 1)
       (fact "given 2"
             (fibonacciNumber 2) => 2)
       (fact "given 3"
             (fibonacciNumber 3) => 3)
       (fact "given 4"
             (fibonacciNumber 4) => 5)
       (fact "given 5"
             (fibonacciNumber 5) => 8)
       (fact "given 6"
             (fibonacciNumber 6) => 13)
       (fact "given 10"
             (fibonacciNumber 10) => 89))

(facts "swap Case"
       (fact "given empty"
             (alternate-case "") => "")
       (fact "given char"
             (alternate-case "a") => "A"
             (alternate-case "A") => "a"
             (alternate-case "C") => "c")
       (fact "given string"
             (alternate-case "ab") => "AB"
             (alternate-case "aB") => "Ab"
             (alternate-case "aBcDefG") => "AbCdEFg"))

(fact "mexican wave"
      (wave "") => []
      (wave "a") => ["A"]
      (wave " a ") => [" A "]
      (wave "ab") => ["Ab" "aB"])

(facts "max-ball"
       (fact "no speed"
             (max-ball 0) => 0)
       (fact "examples"
             (max-ball 15) => 4
             (provided
              (ball-height 3 anything) => 0.808
              (ball-height 4 anything) => 0.881 ;; (partial > ..before..)
              (ball-height 5 anything) => -1
              (ball-height anything anything) => 0.1)))

(facts (fact "zero ms"
             (ball-height 0 15) => 0.0)
       (fact "after more ms"
             (ball-height 1 15) => (roughly 0.367 0.001)
             (provided
              (km-h=>m-s 15) => 4.166)
             (ball-height 2 15) => (roughly 0.637 0.001)
             (provided
              (km-h=>m-s 15) => 4.166)))

(facts "km-h=>m-s"
       (fact "zero"
             (km-h=>m-s 0) => 0.0)
       (fact "more"
             (km-h=>m-s 9) => 2.5))
(facts
 (fact "zero numbers"
       (nb-dig 0 0) => 1
       (nb-dig 0 1) => 0)
 (fact "one number"
       (nb-dig 1 0) => 1
       (nb-dig 1 1) => 1
       (nb-dig 1 2) => 0)
 (fact "squared number single digit"
       (nb-dig 2 0) => 1
       (nb-dig 2 1) => 1
       (nb-dig 2 2) => 0
       (nb-dig 2 4) => 1
       (nb-dig 3 3) => 0
       (nb-dig 3 0) => 1
       (nb-dig 3 1) => 1
       (nb-dig 3 4) => 1
       (nb-dig 3 9) => 1))

(fact "empty"
      (scale "" 0 0) => "")
