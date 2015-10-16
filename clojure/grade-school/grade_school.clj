(ns grade-school)

;; from algo.generic.functor
(defn fmap
  [f m]
  (into (empty m) (for [[k v] m] [k (f v)])))



(defn add [db student grade]
  (update db grade
          (fnil conj []) student))

(defn grade [db grade]
  (db grade []))

(defn sorted [db]
  (into (sorted-map) (fmap sort db)))
