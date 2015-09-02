(ns wonderland-number.finder)
;Make sure the number is in range
(def number-range (range 100000 1000000))

;Check that two given numbers have the same digits, as done in finder_test
;How to avoid ns collission?
(defn same-digits? [n1 n2]
  (let [s1 (set (str n1))
        s2 (set (str n2))]
    (= s1 s2)))
  
;Generate a sequence of a number multiplied by 2 3 4 5 6
(defn multiplier  [n]  (let  [mults  (range 2 7)]  (map #(* n %) mults)))

;Take the first number for which all the digits in the multiplied sequence are the same in the sequence of 6-digits number
(defn wonderland-number []
  (first (filter
            #(every? true? (map same-digits? (multiplier %) (rest (multiplier %))))
            number-range)))
