(ns bob
  (:require [clojure.string :as str]))

(defn letters? [x]
  (re-seq #"[a-z|A-Z]" x))

(defn question? [x]
  (= \? (last x)))

(defn forceful-question? [x]
  (and (question? x)
       (letters? x)
       (= x (str/upper-case x))))

(defn yelling? [x]
  (and (= x (str/upper-case x))
       (letters? x)))

(defn nothing? [x]
  (= x ""))

(defn response-for [input] ;; <- arglist goes here
  (let [s (str/trim input)]
  (cond
    (forceful-question? s) "Calm down, I know what I'm doing!"
    (question? s) "Sure."
    (nothing? s) "Fine. Be that way!"
    (yelling? s) "Whoa, chill out!"
    :else "Whatever.")))
