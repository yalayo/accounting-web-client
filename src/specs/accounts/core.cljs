(ns specs.accounts.core
  (:require [clojure.spec.alpha :as s]))

(s/def ::id uuid?)
(s/def ::code string?)
(s/def ::name string?)
(s/def ::level int?)
(s/def ::amount float?)
(s/def ::user string?)

(s/def ::book-account (s/keys :req-un [::id ::code ::name ::level]))
(s/def ::debit-account ::book-account)
(s/def ::credit-account ::book-account)

(s/def ::system-account (s/keys :req-un [::id ::name]))
(s/def ::owner-account ::system-account)

