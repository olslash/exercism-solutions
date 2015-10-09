(ns word-count
  (require [clojure.string :refer [join lower-case]]))

(defn word-character? [c]
  (or (Character/isDigit c)
      (Character/isLetter c)))

(defn word-count [phrase]
  (->> phrase
       (partition-by word-character?)
       (filter #(word-character? (first %)))
       (map join)
       (map lower-case)
       (map #(identity {% 1}))
       (apply merge-with +)))



