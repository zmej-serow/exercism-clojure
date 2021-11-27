(ns armstrong-numbers)

(defn pow
  "Exponentiation function"
  [x n]
  (apply * (repeat n x)))

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
  [num]
  (let [digits       (to-digits num)
        digits-count (count digits)] 
    (= num (reduce #(reducer %1 %2 digits-count) 0 digits))))
