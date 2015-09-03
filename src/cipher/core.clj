(ns cipher.core
  (:gen-class)
  (:use [clojure.string :as str :only [lower-case]]))

;;; http://en.wikipedia.org/wiki/Caesar_cipher
;;;
;;; Problem 1 - Rotation Cipher
;;;
;;; "Esp qtcde nzyqpcpynp zy esp ezatn zq Lcetqtntlw Tyepwwtrpynp hld spwo le Olcexzfes Nzwwprp ty estd jplc."
;;;
;;; Take the input string and interatively try the following
;;; where x is 1 to 26
;;;
;;; First we translate all of our characters to numbers, 'a'=0, 'b'=1, 'c'=2, ... , 'z'=25
;;;
;;; The decryption function is :
;;;
;;; x is the character represented as a number where a=0, ... z=25
;;; k is the shift amount
;;; e(x) == (x-k) (mod 26)

(def input "Esp qtcde nzyqpcpynp zy esp ezatn zq Lcetqtntlw Tyepwwtrpynp hld spwo le Olcexzfes Nzwwprp ty estd jplc." )

(def alphabet (map char (range 97 123)))

;; (map char (concat (range 65 91) (range 97 123)))

(defn xth [x]
  (nth alphabet x))

(defn lth [l]
  (.indexOf alphabet l))


(defn shift-c [c amount]
  (let [x (lth c)
        y (mod (+ amount x) 26)]
    (xth  y)))


(defn isspace [c] (= \space c))

(defn isperiod [c] (= \. c))

(defn process [in]
  (doseq [d (range 1 25)]
    (doseq [c in]
      (if (or (isspace c) (isperiod c))
        (print c)
        (print (shift-c c d))))
    (print "\n")))

(defn decipher [str]
  (process (str/lower-case str)))



(defn -main
  "Print input then solutions"
  [& args]
  (do
    (println "Input:")
    (println input)
    (println "")
    (println "Output:")
    (decipher input)
    (println "--")))


;; ftq rudef oazrqdqzoq az ftq fabuo ar mdfuruoumx uzfqxxusqzoq ime tqxp mf pmdfyagft oaxxqsq uz ftue kqmd.
;; gur svefg pbasrerapr ba gur gbcvp bs negvsvpvny vagryyvtrapr jnf uryq ng qnegzbhgu pbyyrtr va guvf lrne.
;; hvs twfgh qcbtsfsbqs cb hvs hcdwq ct ofhwtwqwoz wbhszzwusbqs kog vszr oh rofhacihv qczzsus wb hvwg msof.
;; iwt uxghi rdcutgtcrt dc iwt idexr du pgixuxrxpa xcitaaxvtcrt lph wtas pi spgibdjiw rdaatvt xc iwxh ntpg.
;; jxu vyhij sedvuhudsu ed jxu jefys ev qhjyvysyqb ydjubbywudsu mqi xubt qj tqhjcekjx sebbuwu yd jxyi ouqh.
;; kyv wzijk tfewvivetv fe kyv kfgzt fw rikzwztzrc zekvcczxvetv nrj yvcu rk urikdflky tfccvxv ze kyzj pvri.
;; lzw xajkl ugfxwjwfuw gf lzw lghau gx sjlaxauasd aflwddaywfuw osk zwdv sl vsjlegmlz ugddwyw af lzak qwsj.
;; max ybklm vhgyxkxgvx hg max mhibv hy tkmbybvbte bgmxeebzxgvx ptl axew tm wtkmfhnma vheexzx bg mabl rxtk.
;; nby zclmn wihzylyhwy ih nby nijcw iz ulnczcwcuf chnyffcayhwy qum byfx un xulngionb wiffyay ch nbcm syul.
;; ocz admno xjiazmzixz ji ocz ojkdx ja vmodadxdvg diozggdbzixz rvn czgy vo yvmohjpoc xjggzbz di ocdn tzvm.
;; pda benop ykjbanajya kj pda pkley kb wnpebeyewh ejpahhecajya swo dahz wp zwnpikqpd ykhhaca ej pdeo uawn.
;; qeb cfopq zlkcbobkzb lk qeb qlmfz lc xoqfcfzfxi fkqbiifdbkzb txp ebia xq axoqjlrqe zliibdb fk qefp vbxo.
;; rfc dgpqr amldcpclac ml rfc rmnga md yprgdgagyj glrcjjgeclac uyq fcjb yr byprkmsrf amjjcec gl rfgq wcyp.
;; sgd ehqrs bnmedqdmbd nm sgd snohb ne zqshehbhzk hmsdkkhfdmbd vzr gdkc zs czqslntsg bnkkdfd hm sghr xdzq.
;; the first conference on the topic of artificial intelligence was held at dartmouth college in this year.
;; uif gjstu dpogfsfodf po uif upqjd pg bsujgjdjbm joufmmjhfodf xbt ifme bu ebsunpvui dpmmfhf jo uijt zfbs.
;; vjg hktuv eqphgtgpeg qp vjg vqrke qh ctvkhkekcn kpvgnnkigpeg ycu jgnf cv fctvoqwvj eqnngig kp vjku agct.
;; wkh iluvw frqihuhqfh rq wkh wrslf ri duwlilfldo lqwhooljhqfh zdv khog dw gduwprxwk froohjh lq wklv bhdu.
;; xli jmvwx gsrjivirgi sr xli xstmg sj evxmjmgmep mrxippmkirgi aew liph ex hevxqsyxl gsppiki mr xlmw ciev.
;; ymj knwxy htskjwjshj ts ymj ytunh tk fwynknhnfq nsyjqqnljshj bfx mjqi fy ifwyrtzym htqqjlj ns ymnx djfw.
;; znk loxyz iutlkxktik ut znk zuvoi ul gxzoloiogr otzkrromktik cgy nkrj gz jgxzsuazn iurrkmk ot znoy ekgx.
;; aol mpyza jvumlylujl vu aol avwpj vm hyapmpjphs pualsspnlujl dhz olsk ha khyatvbao jvsslnl pu aopz flhy.
;; bpm nqzab kwvnmzmvkm wv bpm bwxqk wn izbqnqkqit qvbmttqomvkm eia pmtl ib lizbuwcbp kwttmom qv bpqa gmiz.
;; cqn orabc lxwonanwln xw cqn cxyrl xo jacrorlrju rwcnuurpnwln fjb qnum jc mjacvxdcq lxuunpn rw cqrb hnja.


;; Answer:
;; the first conference on the topic of artificial intelligence was held at dartmouth college in this year.

;; http://www.livinginternet.com/i/ii_ai.htm
;; 1956
