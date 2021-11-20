(ns accumulate)

(defn accumulate [f xs] ;; <- arglist goes here
  (loop [[x & rest] xs, acc []]
    (if (nil? x)
      acc
      (recur rest (conj acc (f x))))))
