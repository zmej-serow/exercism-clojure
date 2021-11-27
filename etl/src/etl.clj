(ns etl)

(defn transform [data] ;; <- arglist goes here
  (reduce-kv
    (fn [m k v]
      (merge m
             (zipmap
               (map clojure.string/lower-case v)
               (repeat k))))
    {} data))
