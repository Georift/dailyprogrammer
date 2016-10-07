; daily programmer
; [2016-09-12] Challenge #283 [Easy] Anagram Detector 

(ns vim.core)
(require '[clojure.string :as str])

; reads the file into a list of pairs
(defn parse-file [s]
  (map split-pairs 
       (parse-lines s)))

; splits the file into a list by line.
(defn parse-lines [s]
  (str/split s #"\n"))

; splits "something" ? "other thing" into a pair
; and removes the surrounding quotes
(defn split-pairs [s]
  (str/split (str/replace s #"\"" "") #" \? "))

; removes chars which shouldn't be considered
(defn clean [s]
  (str/lower-case 
    (str/replace s #"[ ']" "")))

; checks if a pair is an anagram after cleaning 
; it of unwanted chars
(defn anagram? [pair]
  (def cleaned (map clean pair))
  (.equals 
    (frequencies (first cleaned)) 
    (frequencies (last cleaned)))
  )

; checks if a pair is an anagram and prints the line
(defn print-anagram [pair]
  (if (anagram? pair)
    (println (str "\"" (first pair) "\" is an anagram of \"" (last pair) "\""))
    (println (str "\"" (first pair) "\" is NOT an anagram of \"" (last pair) "\""))))

; loop over every pair and print if it's an anagram
(doseq 
  [pair (parse-file (slurp "input.txt"))] 
  (print-anagram pair))
