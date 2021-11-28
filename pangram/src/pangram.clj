(ns pangram)

(def ascii-letter-a 97)
(def ascii-letter-z 123)

(def all-ascii-letters (map char (range ascii-letter-a ascii-letter-z)))

(defn is-ascii-letter? [character]
  (let [ascii-code (int character)]
    (and (<= ascii-letter-a ascii-code)
         (>= ascii-letter-z ascii-code))))

(defn letters-in-input [s]
  (->> s
       clojure.string/lower-case
       (filter is-ascii-letter?)
       frequencies
       keys
       set))

(defn pangram? [s]
  (= (set all-ascii-letters) (letters-in-input s)))
