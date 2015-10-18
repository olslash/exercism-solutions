(ns leap)

(defn evenly-divisible? [a b]
  (= (rem b a) 0))

(defn leap-year? [year]
  (condp evenly-divisible? year
    400 true
    100 false
    4 true
    false))
