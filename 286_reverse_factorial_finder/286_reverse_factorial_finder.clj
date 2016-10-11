; daily programmer
; [2016-10-03] Challenge #286 [Easy] Reverse Factorial
(ns vim.factorial)

; returns a list of lines from the file
(defn read-file [s]
  (def strs (str/split (slurp s) #"\n"))
  (map #(Integer/parseInt %) strs))

; Recursive function which returns the
; found factorial or nil
(defn factorial 
  ([i] (factorial i 1))
  ([i, j]
  (if (> i 1) 
    (factorial (/ i j) (+ j 1))
    (if (= i 1)
      (- j 1))
    )))

; output a string to the user given the
; result from the factorial function
(defn find-factorial [i]
  (def factor (factorial i))
  (if (some? factor)
    (println (str i " = " factor "!"))
    (println (str i " NONE"))))

(map find-factorial (read-file "factorial.txt"))
