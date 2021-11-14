(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [[f _]]
    f)

(defn second-card
  "Returns the second card from deck."
  [[_ s _]]
    s)

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [[f s & rest]]
  (if (nil? rest)
    [s f]
    (flatten [s f rest])))

(defn discard-top-card
  "Returns a vector containing the first card and
   a vector of the remaining cards in the deck."
  [[f & rest]]
    [f rest])

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [[f & rest]]
  (cond
    (nil? f)    face-cards
    (nil? rest) (flatten [f face-cards])
    :else (flatten [f face-cards rest])))
