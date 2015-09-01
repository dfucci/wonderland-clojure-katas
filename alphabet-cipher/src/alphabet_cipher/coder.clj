(ns alphabet-cipher.coder)

;Constants
(def alphabet (String. "abcdefghijklmnopqrstuvwxyz"))
(def alphabet-count (count alphabet))

;Match a single letter to its encoded version by keyword
(defn- encode-single [m k] 
  (nth alphabet (mod (+ (.indexOf alphabet (str k)) (.indexOf alphabet (str m))) alphabet-count)))

;and the other way around
(defn- decode-single [m k]
  (nth alphabet (mod  (+ (.indexOf alphabet (str m))  (- (count alphabet) (.indexOf alphabet (str k)))) alphabet-count)))

(defn encode [keyword message]
  (apply str (map encode-single message (cycle keyword))))

(defn decode [keyword message]
  (apply str (map decode-single message (cycle keyword))))
