(ns triangle)

(defn is-valid? [a b c]
  (and
   (> a 0)
   (> b 0)
   (> c 0)
   (<= a (+ b c))
   (<= b (+ a c))
   (<= c (+ a b))))

(defn equilateral? [a b c] ;равносторонний
  (and
   (is-valid? a b c)
   (= a b c)))

(defn isosceles? [a b c] ;равнобедренный
  (and
   (is-valid? a b c)
   (or (= a b) (= b c) (= a c))))

(defn scalene? [a b c] ;все стороны разные
  (and
   (is-valid? a b c)
   (not (= a b c))
   (not (isosceles? a b c))))
