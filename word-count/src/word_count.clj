(ns word-count
  (:require [clojure.string :as string]))

(defn remove-front-ticks [s]
  (apply str (drop-while #(= \' %) s)))

(defn remove-enclosing-ticks [word]
  (-> word
      (remove-front-ticks)
      (string/reverse)
      (remove-front-ticks)
      (string/reverse)))

(defn word-count [input]
  (as-> input s
        (re-seq #"[a-zA-Z0-9\'\s]" s)
        (apply str s)
        (string/lower-case s)
        (string/split s #"\s+")
        (map remove-enclosing-ticks s)
        (frequencies s)))

