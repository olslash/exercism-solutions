(ns etl)


(defn transform [scores]
  (->> scores
       (map (fn [[v ks]]
              (zipmap (map clojure.string/lower-case ks)
                      (repeat v))))
       (apply merge)))

