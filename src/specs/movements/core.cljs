(ns specs.movements.core
  (:require [clojure.spec.alpha :as s]
            [specs.accounts.core :as a]))

(s/def ::id uuid?)
(s/def ::user string?)
(s/def ::topic string?)
(s/def ::produced-at inst?)
(s/def ::consumed-at inst?)
(s/def ::post-date inst?)
(s/def ::amount double?)

(s/def ::movement (s/keys :req-un [::id ::topic ::a/owner-account ::produced-at ::consumed-at ::user]))

(s/def ::entry (s/keys :req-un [::id ::amount ::a/debit-account ::a/credit-account ::post-date ::movement]))

