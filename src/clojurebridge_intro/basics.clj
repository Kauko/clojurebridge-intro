(ns clojurebridge-intro.basics)

;;
;; Getting to know clojure syntax:
;;

; Comments

; Numbers

; Booleans

; Strings (Merkkijonot)

; Keywords, eli avain-sanat

; Calling functions

; Exercise:
; Turn these to clojure:
; 15 + 5
; 10 + 5 * 10
; 10 / (2 + 3)

;;
;; Using your own variables
;;

; Exercise
; Give the name my-number to a number of your choosing
; Turn this to Clojure: 10 + my-number
; Try changing the value of my-number, evaluate that again :)

; Creating your own functions

; Exercise
; Create different functions for each of these:
; Adds together two numbers
; Divides a given number by two
; Returns the average of two numbers (Reuse the two functions you defined before!)

;;
;; Tietorakenteet:
;;

; Vektori
; - count
; - conj
; - first
; - nth

; Exercise
; Let's rewrite our average function to take any number of arguments!
; Hint: Something like this:
; (defn my-function [& args]) <-- args is a vector!
; Remember, get a vectors number of elements by using count

; Map
; - get
; - assoc
; - dissoc
; - merge
; - update

;;
;; if, let
;;
