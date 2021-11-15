(ns armstrong-numbers
  (:require [clojure.edn    :as edn]
            [clojure.string :as str]))

(defn pow
  "Exponentiation function"
  [x n]
  (reduce *' (repeat n x)))

(defn reducer
  "Reducing function"
  [n acc x]
  (+ acc (pow x n)))

(defn armstrong?
  "An Armstrong number is a number that is the sum of its own digits each raised to the power of the number of digits.
   For example:
   9 is an Armstrong number, because 9 = 9^1 = 9
   10 is not an Armstrong number, because 10 != 1^2 + 0^2 = 1
   153 is an Armstrong number, because: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
   154 is not an Armstrong number, because: 154 != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190"
  [num]
  (let [p  (count (str num))
        re (partial reducer p)]
    (= num
       (as-> num n
          (str n)
          (str/split n #"")
          (map edn/read-string n)
          (reduce re 0 n))))) 
