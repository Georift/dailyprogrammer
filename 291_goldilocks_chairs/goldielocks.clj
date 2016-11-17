; daily programmer
; [2016-11-07] Challenge #291 [Easy] 
; Goldilocks' Bear Necessities
(ns vim.goldielocks)
(use '[clojure.string :only (split-lines split)])

; convert the vector string pair to integers
(defn pair-to-int [vect]
  (vec (map #(Integer/parseInt %) vect)))

; read the input file
(defn read-file [file]
  (def i 0)
  (map-indexed
    #(into (pair-to-int (split %2 #" ")) [%1])
    (split-lines (slurp file))))

; perform the chair lookup
((fn help-goldy []
  (def input (read-file "src/vim/input_file.txt"))
  (def goldy (first input))

  (def goodChairs
    (filter (fn [ch]
              (and (> (first ch) (first goldy))
                   (< (second ch) (second goldy))))
            (rest input)))
  (reduce #(str %1 " " %2) (map last goodChairs))))
