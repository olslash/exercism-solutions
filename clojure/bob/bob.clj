(ns bob)

(defn all-upper-case? [sentence]
  (let [letters (->> sentence
                     (filter #(re-matches #"[^\d\W]" (str %)))
                     clojure.string/join)]
    (and (not-empty letters)
         (= (clojure.string/upper-case letters) letters))))

(defn question? [sentence]
  (= (last sentence) \?))

(defn response-for [message]
  (let [message (clojure.string/trim message)]
    (cond
      (empty? message) "Fine. Be that way!"
      (all-upper-case? message) "Woah, chill out!"
      (question? message) "Sure."
      :else "Whatever.")))
