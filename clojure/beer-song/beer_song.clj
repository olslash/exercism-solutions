(ns beer-song)

(defn plural [s n]
  (if (= 1 n) s
              (str s "s")))

(defn verse [n]
  (let [num (if (= n 0) "no more" n)
        minus-1-num (cond (= n 1) "no more"
                          (= n 0) 99
                          :else (dec n))]
    (format "%s %s of beer on the wall, %s %s of beer.\n%s, %s %s of beer on the wall.\n"
            (clojure.string/capitalize num)
            (plural "bottle" n)
            num
            (plural "bottle" n)
            (cond (= n 0) "Go to the store and buy some more"
                  (= n 1) "Take it down and pass it around"
                  :else "Take one down and pass it around")
            minus-1-num
            (plural "bottle" minus-1-num))))

(defn make-song [from to]
  (clojure.string/join "\n" (map verse (range from to -1))))

(defn sing
  ([from]    (make-song from -1))
  ([from to] (make-song from (dec to))))
