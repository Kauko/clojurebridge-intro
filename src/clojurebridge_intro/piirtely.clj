(ns clojurebridge-intro.piirtely
  ; Ota Quil kirjato käyttöön, käytä aliaksena 'q' symbolia.
  (:require [quil.core :as q]))

; Värit esitetään kolmella numerolla jotka kuvaavat punaisen, sinisen ja
; vihreän voimakkuutta. Minimi arvo on 0 ja maksimi 255.
;
; Colors are represented using 3 numbers, for red, blue, and green.
; Minimum is 0, max is 255
;
; blacl        0,   0,   0
; grey         128, 128, 128
; white        255, 255, 255
; red          255,   0,   0
; violet       255, 255,   0

; Muutamia apu-muuttujia:

(def window-width 700)     ; Ikkunan leveys muuttuja
(def window-heigth 600)    ; Ikkunan korkeus muuttuja

;
; Alustus funktio. Tätä kutsutaan vain piirtely-ikkunan
; luonti vaiheessa.
;

(defn init []
  (q/smooth)             ; Reunojen pehmennys päälle.
  (q/frame-rate 30))     ; Piirrä ikkuna 30 kertaa sekunnissa.

;
; Piirtely funktio. Tätä kutsutaan toistuvasti.
;

(defn draw []
  (let [x (q/mouse-x)     ; Hiiren x-koordinaatti
        y (q/mouse-y)     ; Hiiren y-koordinaatti
        ; Kun x kulkee 0 - ikkunan-leveys, punainen kulkee 0 - 255
        red (q/map-range x 0 window-width 0 255)
        ; Kun y kulkee 0 - ikkunan-korkeys, vihrea kulkee 0 - 255
        green (q/map-range y 0 window-heigth 0 255)
        ; Sininen on aina 128
        blue 128]
    ; Reunuksen vahvuus:
    (q/stroke-weight 1)
    ; Reunuksen väri:
    (q/stroke 0 0 0)
    ; Täyttöväri:
    (q/fill red green blue 92)
    ; Piirretään 60 x 60 ellipsi kohtaan x, y:
    (q/ellipse x y 60 60)))

;
; Luodaan Quil 'sketch', eli 'piirtely' -ikkuna.
;

(q/defsketch piirtely-ikkuna
             :title "Piirtelyä"                        ; Otsikko.
             :setup init                            ; Alustus funktio.
             :draw draw                              ; Piirto funktio.
             :features [:keep-on-top]                  ; Taikuutta.
             :size [window-width window-heigth])   ; Piirto-ikkunan koko.
