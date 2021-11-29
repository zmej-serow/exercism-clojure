(ns nucleotide-count
  (:require [clojure.set :as s]))

(def valid-nucleotides-init {\A 0 \C 0 \G 0 \T 0})
(def valid-nucleotides (set (keys valid-nucleotides-init)))

(defn check-nucleotides [n]
  (if (not (= valid-nucleotides (s/union valid-nucleotides (set (str n)))))
    (throw (Exception. "Valid nucleotides are: A C G T"))
    n))

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (count (filter #(= (check-nucleotides nucleotide) %)
                 (check-nucleotides strand))))

(defn nucleotide-counts [strand]
  (merge valid-nucleotides-init
  (->> strand
       check-nucleotides
       frequencies)))

(comment "
much cleaner solution follows (not mine):

(defn count [nucleotide sequence]
  {:pre [(contains? #{\A \T \G \C} nucleotide)]}
  (get (nucleotide-counts sequence) nucleotide))

(defn nucleotide-counts [sequence]
  {:post [(= #{\A \T \C \G}
             (set (keys %)))]}
  (merge {\A 0 \T 0 \C 0 \G 0}
         (frequencies sequence)))
")
