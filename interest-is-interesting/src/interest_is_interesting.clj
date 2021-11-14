(ns interest-is-interesting)

(defn interest-rate
  "TODO: add docstring"
  [balance]
  (cond
    (neg? balance)   -3.213
    (> 1000 balance) 0.5
    (> 5000 balance) 1.621
    :else            2.475))

(defn annual-balance-update
  "TODO: add docstring"
  [balance]
  (let [balance-change (* (bigdec (interest-rate balance)) (/ balance 100))]
    (if (neg? balance)
      (- balance balance-change)
      (+ balance balance-change))))

(defn amount-to-donate
  "TODO: add docstring"
  [balance tax-free-percentage]
  (if (neg? balance)
    0
    (int (* 2
      (* tax-free-percentage (/ balance 100))))))
