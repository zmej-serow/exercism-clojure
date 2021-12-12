(ns scrabble-score)

(defn score-letter [letter]
  (condp contains? (clojure.string/lower-case letter)
    #{"a" "e" "i" "o" "u" "l" "n" "r" "s" "t"} 1
    #{"d" "g"} 2
    #{"b" "c" "m" "p"} 3
    #{"f" "h" "v" "w" "y"} 4
    #{"k"} 5
    #{"j" "x"} 8
    #{"q" "z"} 10))

(defn score-word [word]
  (reduce + (map score-letter word)))
