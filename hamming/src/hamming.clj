(ns hamming)

(defn calc-distance [[a b]]
  (if (= a b) 0 1))

(defn distance [strand1 strand2]
  (if (= (count strand1) (count strand2))
    (reduce + (map calc-distance (map vector strand1 strand2)))
    nil))
