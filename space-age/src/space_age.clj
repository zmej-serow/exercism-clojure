(ns space-age)

(def earth-secs-in-year 31557600)

(defn on-earth [age] ;; <- arglist goes here
  (/ age earth-secs-in-year))

(defn on-mercury [age] ;; <- arglist goes here
  (/ (on-earth age) 0.2408467))

(defn on-venus [age] ;; <- arglist goes here
  ;; your code goes here
  (/ (on-earth age) 0.61519726))

(defn on-mars [age] ;; <- arglist goes here
  (/ (on-earth age) 1.8808158))

(defn on-jupiter [age] ;; <- arglist goes here
  (/ (on-earth age) 11.862615))

(defn on-saturn [age] ;; <- arglist goes here
  (/ (on-earth age) 29.447498))

(defn on-neptune [age] ;; <- arglist goes here
  (/ (on-earth age) 164.79132))

(defn on-uranus [age] ;; <- arglist goes here
  (/ (on-earth age) 84.016846))
