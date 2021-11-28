(ns anagram
  (:require [clojure.string :as str]))

(defn is-anagram? [word prospect]
  (let [prospect-word (str/lower-case prospect)]
    (and
      (= (frequencies word) (frequencies prospect-word))
      (not (= word prospect-word)))))

(defn anagrams-for [word prospect-list]
  (filter (partial is-anagram? (str/lower-case word)) prospect-list))
