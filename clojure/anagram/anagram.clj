(ns anagram
  (require [clojure.string :refer [lower-case]]))


(defn anagrams-for [s possibilities]
  (let [lower-s       (lower-case s)
        lower-s-freqs (frequencies lower-s)]
    (filter #(and (= (frequencies (lower-case %))
                     lower-s-freqs)
                  (not= lower-s (lower-case %)))
            possibilities)))
