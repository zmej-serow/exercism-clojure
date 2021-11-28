(ns pangram)

(def ascii-code-for-letter-a (int \a))
(def ascii-code-for-letter-z (int \z))

(def all-ascii-letters
  (map char
       (range
         ascii-code-for-letter-a
         (+ 1 ascii-code-for-letter-z))))

(defn is-ascii-letter? [character]
  (let [ascii-code (int character)]
    (and (<= ascii-code-for-letter-a ascii-code)
         (>= ascii-code-for-letter-z ascii-code))))

(defn letters-in-input [s]
  (->> s
       clojure.string/lower-case
       (filter is-ascii-letter?)
       frequencies
       keys
       set))

(defn pangram? [s]
  (= (set all-ascii-letters) (letters-in-input s)))
