(ns rna-transcription)

(defn valid-dna? [dna-strand]
  (let [valid-nucleotides #{\A \C \G \T}]
    (every? valid-nucleotides dna-strand)))

(defn to-rna [dna-strand]
  {:pre [(valid-dna? dna-strand)]}
  (let [complements {\G \C
                     \C \G
                     \T \A
                     \A \U}]
    (->> dna-strand
         (map complements)
         clojure.string/join)))