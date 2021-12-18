(ns luhn)

(defn valid-input? [s]
  (nil? (re-seq #"[^\d|\s]" s)))

(defn only-numbers [s]
  (seq (apply str (re-seq #"\d+" s))))

(defn char-to-int [c]
  (- (int c) (int \0)))

(defn fix-overflow [x]
  (if (> x 9)
    (- x 9)
    x))

(defn luhn-double [xs]
  (map * (cycle [1 2]) (reverse xs)))

(defn valid? [n]
  (let [digits (only-numbers n)]
    (and (valid-input? n) (< 1 (count digits))
         (let [numbers (map char-to-int digits)
               luhn-doubled (map fix-overflow (luhn-double numbers))
               sum (reduce + luhn-doubled)]
           (zero? (rem sum 10))))))
