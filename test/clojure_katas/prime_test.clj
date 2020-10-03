(ns clojure-katas.prime-test
  (:require [midje.sweet :refer [=> facts fact]]
            [clojure-katas.core :refer :all]))

(facts "test prime"
       (fact "zero"
             (primeFactors 0) => 0))
