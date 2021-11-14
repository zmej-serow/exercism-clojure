(ns acronym
  (:require [clojure.string :as str]))

(defn acronym [s]
  (->> s
       (re-seq #"[A-Z]+[a-z]*|[a-z]+")
       (map (comp first str/upper-case))
       (str/join)))
