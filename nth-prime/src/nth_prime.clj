(ns nth-prime)

(defn divides-wo-remainder? [a b]
  (zero? (rem a b)))

(def primes
  (lazy-seq
    (filter (fn [i] (not-any? #(divides-wo-remainder? i %)
                              (take-while #(<= (* % %) i) primes)))
            (drop 2 (range)))))

(defn nth-prime [n]
  (if (zero? n)
    (throw (IllegalArgumentException.))
    (first (drop (dec n) primes))))
