(ns nucleotide-count)

(def nucleotides #{\A \T \C \G})

(defn nucleotide-counts [strand]
  (let [counts (zipmap nucleotides (repeat 0))]
    (merge counts (frequencies strand))))

(defn count [nucleotide strand]
  (if-not (nucleotides nucleotide)
    (throw (Exception. "invalid nucleotide")))
  ((nucleotide-counts strand) nucleotide))

