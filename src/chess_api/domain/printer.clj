(ns chess-api.domain.printer)

(defn K[color] {:color color :name "king"})
(defn Q[color] {:color color :name "queen"})
(defn B[color] {:color color :name "bishop"})
(defn N[color] {:color color :name "knight"})
(defn R[color] {:color color :name "rook"})
(defn P[color] {:color color :name "pawn"})
(defn E[color] {:color color :name "empty"})

(defn can-pawn [state move](

                            ))

(defn can-move? [piece]
  (case (piece :name)
    "pawn" (can-pawn (piece :color))
    "king" (can-king (piece :color))
    "rook" (can-rook (piece :color))
    "bishop" (can-bishop (piece :color))
    "knight" (can-knight (piece :color))
    "queen" (can-queen (piece :color))
    "empty" (can-empty)
    ()
    ))

(def inital-state {
                   :board {
                           :1 {:a (R "black"), :b (N "black"), :c (B "black"), :d (K "black"), :e (Q "black"), :f (B "black"), :g (N "black"), :h (R "black")}
                           :2 {:a (P "black"), :b (P "black"), :c (P "black"), :d (P "black"), :e (P "black"), :f (P "black"), :g (P "black"), :h (P "black")}
                           :3 {:a (E "black"), :b (E "black"), :c (E "black"), :d (E "black"), :e (E "black"), :f (E "black"), :g (E "black"), :h (E "black")}
                           :4 {:a (E "black"), :b (E "black"), :c (E "black"), :d (E "black"), :e (E "black"), :f (E "black"), :g (E "black"), :h (E "black")}
                           :5 {:a (E "black"), :b (E "black"), :c (E "black"), :d (E "black"), :e (E "black"), :f (E "black"), :g (E "black"), :h (E "black")}
                           :6 {:a (E "black"), :b (E "black"), :c (E "black"), :d (E "black"), :e (E "black"), :f (E "black"), :g (E "black"), :h (E "black")}
                           :7 {:a (P "white"), :b (P "white"), :c (P "white"), :d (P "white"), :e (P "white"), :f (P "white"), :g (P "white"), :h (P "white")}
                           :8 {:a (R "white"), :b (N "white"), :c (B "white"), :d (K "white"), :e (Q "white"), :f (B "white"), :g (N "white"), :h (R "white")}
                           }
                   }
  )

(defn next-state [state](
                         println state
                         ))

(defn is-black? [color]
  (if (= color "black") true false))

(defn print-queen [color] (printf (if (is-black? color) "♕" "♛")))
(defn print-king [color] (printf (if (is-black? color) "♕" "♚")))
(defn print-bishop [color] (printf (if (is-black? color) "♗" "♝")))
(defn print-knight [color] (printf (if (is-black? color) "♘" "♞")))
(defn print-rook [color] (printf (if (is-black? color) "♖" "♜")))
(defn print-pawn [color] (printf (if (is-black? color) "♙" "♟")))
(defn print-empty [] (printf "."))
(defn print-spacer [] (printf " "))

(defn print-piece [piece]
  (case (piece :name)
    "pawn" (print-pawn (piece :color))
    "king" (print-king (piece :color))
    "rook" (print-rook (piece :color))
    "bishop" (print-bishop (piece :color))
    "knight" (print-knight (piece :color))
    "queen" (print-queen (piece :color))
    "empty" (print-empty)
    (print-spacer)
    ))

(defn print-board [state]
  (doseq [[number rows] (state :board)]
    (println "")
    (print number " ")
    (doseq [[letter column] rows] 
      (print-piece column)
      (print-spacer)
      ))
  (println "\n    a b c d e f g h"))

(comment
  (print-board inital-state)
  )
