; daily programmer
; [2016-10-05] Challenge #286 [Intermediate] 
; Zeckendorf Representations of Positive Integers
(use '[clojure.string :only (join)])

(defn fib-upto 
  "Generate a list of fib numbers up-to a number"
  ([number] (fib-upto '(1 1) number))
  ([fibs number]
    (if (< (first fibs) number)
      (fib-upto (conj fibs (+ (first fibs) (second fibs))) number)
      (rest fibs))))

(defn zeckendorf
  "Find a sequence of fib numbers which add to a number"
  ([number] (zeckendorf (fib-upto number) number 0))
  ([fibs number upto]
   (if (not= number upto)
     (let [nextFound (+ (first fibs) upto)]
       (if (<= nextFound number)
         (conj (zeckendorf (rest fibs) number nextFound) (first fibs))
         (zeckendorf (rest fibs) number upto)))))))

; Display the list in a nice format
(defn display-zeckendorf
  [number]
  (str number " = " (join " + " (zeckendorf number))))

; Sample Input/Output
(for [x '(3 4 100 30)]
  (println (display-zeckendorf x)))

; Challenge Input/Output
(for [x '(5 120 34 88 90 320)]
  (println (display-zeckendorf x)))
