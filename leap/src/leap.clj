(ns leap)

(defn flip [f x y] (f y x))

(defn evenly-divisible-by? [x y]
  (zero? (rem x y)))

(defn year-evenly-divisible-by? [x]
  (partial flip evenly-divisible-by? x))

(def year-evenly-divisible-by-4 (year-evenly-divisible-by? 4))
(def year-evenly-divisible-by-100 (year-evenly-divisible-by? 100))
(def year-evenly-divisible-by-400 (year-evenly-divisible-by? 400))

(defn leap-year? [year]
  (and
    (year-evenly-divisible-by-4 year)
    (or
      (year-evenly-divisible-by-400 year)
      (not (year-evenly-divisible-by-100 year)))))
