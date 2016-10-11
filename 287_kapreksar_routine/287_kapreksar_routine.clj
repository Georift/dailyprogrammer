; reddit.com/r/dailyprogrammer
; [2016-10-10] Challenge #287 [Easy] Kaprekar's Routine
(defn explode-digits [number]
  (map #(Character/digit % 10) (str number)))

(defn largest-digit [number]
  (apply max (explode-digits number)))

(largest-digit 1234)
(largest-digit 3253)
(largest-digit 9800)
(largest-digit 3333)
(largest-digit 120)

(defn pad [n coll]
  (take n (concat coll (repeat 0))))

(defn asc-digits [number]
  (Integer/parseInt
    (clojure.string/join
      (sort (pad 4 (explode-digits number))))))

(defn desc-digits [number]
  (Integer/parseInt
    (clojure.string/join
      (reverse (sort (pad 4 (explode-digits number)))))))

(desc-digits 1234)
(desc-digits 3253)
(desc-digits 9800)
(desc-digits 3333)
(desc-digits 120)

(defn kaprekar [number]
  (- (desc-digits number) (asc-digits number)))

(defn count-to-kaprekar 
  ([number] (count-to-kaprekar number 0))
  ([number i]
   (def found (kaprekar number))
   (if (or (= 6174 number) (= 0 number))
     i
     (count-to-kaprekar found (inc i)))))
    
(count-to-kaprekar 6589)
(count-to-kaprekar 5455)
(count-to-kaprekar 6174)
