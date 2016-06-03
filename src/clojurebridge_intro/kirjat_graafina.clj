(ns clojurebridge-intro.kirjat-graafina
  (:require [clojurebridge-intro.tiedonkasittely :as t]
            [quil.core :as q]))


;                Genre:        Pun  Vih  Sin
(def genre-color {:fantasia   [32   178  62]
                 :mysteeri    [182  42   42]
                 :klassikko   [142  142  182]
                 :romantiikka [255  155  155]
                 :sci-fi      [230  20   192]})

; Function that takes a book and returns a color

(defn book-color [book]
  (let [genre (get book :genre)
        colors (get genre-color genre)
        red (nth colors 0)
        green (nth colors 1)
        blue (nth colors 2)]
    (q/color red green blue)))

; Funktio joka ottaa kirjan ja palauttaa x-koordinaatin
; kirjan sivumäärän perusteella:

(defn book-x-coordinate [book]
  (let [pages (get book :sivuja)]
    (q/map-range pages
                 0 670    ; min and max page count
                 0 600))) ; min and max x-coordinate

; Funktio joka ottaa kirjan ja palauttaa y-koordinaatin
; kirjan hinnan perusteella:

(defn book-y-coordinate [book]
  (let [price (get book :hinta)]
    (q/map-range price
                 0 30     ; min ja max hinta
                 0 600))) ; min ja max y-koordinaatti

  ; Piirtää yhden kirjan:

(defn draw-book [book]
  (let [color (book-color book)
        x (book-x-coordinate book)
        y (book-y-coordinate book)
        r 50]
    (q/fill color)
    (q/ellipse x y r r)
    (q/fill 0)
    (q/text (get book :nimi) x y)))

; Tyhjentää ruudun:

(defn clear []
  (q/background 190 190 190)      ;; Harmaa tausta
  (q/fill 0 0 0)                  ;; Täyttö väri
  (q/stroke 255 255 255)          ;; Viivan väri
  (q/stroke-weight 5)             ;; Viivan paksuus
  (q/text-align :center :center)) ;; Tekstin keskitys


; Piirtää ruudun:

(defn draw []
  (clear)
  (doseq [book t/books]
    (draw-book book)))

; Alustus:

(defn init []
  ; Kirjaisimen asetus:
  (q/text-font (q/create-font "SansSerif" 36 true))
  (q/text-size 15)
  (q/smooth)           ;; Reunojen pehmennys
  (q/frame-rate 8))    ;; Päivitys tiheys

; Avaa uuden piirto-ikkunan:

(defn open-new-window []
  (q/defsketch kirjat-graafina
               :title "Kirjat palloina"     ;; Otsikko
               :setup init               ;; Alustus funktio
               :draw draw                 ;; Piirto funktio
               :features [:keep-on-top]     ;; Taikuutta
               :size [685 600]))            ;; Koko

(comment
  ; Maalaa tämä ja paina (win) ctrl+enter (mac) cmd+enter
  (open-new-window)
  )
