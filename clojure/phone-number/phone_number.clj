(ns phone-number)

(defn valid-phone-number? [number]
  (let [length (count number)]
    (not (or (< length 10)
             (> length 11)
             (and (= length 11)
                  (not= \1 (first number)))))))

(defn number [in]
  (let [number (filter #(Character/isDigit %) in)]
    (if (valid-phone-number? number)
      (apply str (take-last 10 number))
      "0000000000")))

(defn area-code [in]
  (->> in
       number
       (take 3)
       (apply str)))


(defn pretty-print [in]
  (let [num (number in)]
    (format "(%s) %s-%s"
            (subs num 0 3) (subs num 3 6) (subs num 6))))
