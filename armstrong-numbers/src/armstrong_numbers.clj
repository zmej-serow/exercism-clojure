(ns armstrong-numbers)

(defn pow
  "Exponentiation function"
  [x n]
  (reduce * 1 (repeat n x)))

(defn reducer
  [acc x n]
  (+ acc (pow x n)))

(defn to-digits
  [n]
  (loop [num n
         digits nil]
    (if (< num 10)
      (conj digits num)
      (recur (quot num 10)
             (conj digits (rem num 10))))))

(defn armstrong?
  "An Armstrong number is a number that is the sum of its own digits each raised to the power of the number of digits.
   For example:
   9 is an Armstrong number, because 9 = 9^1 = 9
   10 is not an Armstrong number, because 10 != 1^2 + 0^2 = 1
   153 is an Armstrong number, because: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
   154 is not an Armstrong number, because: 154 != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190"
  [num]
  (let [digits       (to-digits num)
        digits-count (count digits)] 
    (= num (reduce #(reducer %1 %2 digits-count) 0 digits))))
