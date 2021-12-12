(ns scrabble-score)

(defn score-letter [letter]
  (let [lowercase-letter (clojure.string/lower-case letter)]
    (cond
      (contains? #{"a" "e" "i" "o" "u" "l" "n" "r" "s" "t"} lowercase-letter) 1
      (contains? #{"d" "g"} lowercase-letter) 2
      (contains? #{"b" "c" "m" "p"} lowercase-letter) 3
      (contains? #{"f" "h" "v" "w" "y"} lowercase-letter) 4
      (contains? #{"j" "x"} lowercase-letter) 8
      (contains? #{"q" "z"} lowercase-letter) 10
      :else 5)))

(defn score-word [word]
  (reduce + (map score-letter (seq word))))
