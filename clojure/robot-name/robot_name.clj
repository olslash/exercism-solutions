(ns robot-name)

(defn rand-chars-in-range [low high]
  (let [chars (map char (range low high))]
    (repeatedly #(rand-nth chars))))

(defn select-random-digits [n]
  (take n (rand-chars-in-range 48 57)))

(defn select-random-letters [n]
  (take n (rand-chars-in-range 65 91)))

(defn make-name []
  (->> (into (vec (select-random-letters 3))
             (select-random-digits 3))
       (apply str)))

(defn robot []
  (atom
    {:name (make-name)}))

(defn robot-name [robot]
  (:name @robot))

(defn reset-name [robot]
  (swap! robot assoc :name (make-name)))
