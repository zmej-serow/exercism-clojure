(ns cars-assemble)

(def default-cars-per-hour 221)

(defn success-rate [speed]
  (cond
    (= speed 0)  0
    (< speed 5)  100
    (< speed 9)  90
    (< speed 10) 80
    :else        77))

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (float
    (* (success-rate speed)
       (/ (* speed default-cars-per-hour) 100))))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int
    (/ (production-rate speed) 60)))
