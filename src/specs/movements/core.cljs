(ns specs.movements.core
  (:require [clojure.spec.alpha :as s]
            [specs.accounts.core :as a]))

(s/def ::id uuid?)
(s/def ::user string?)
(s/def ::topic string?)
(s/def ::produced-at inst?)
(s/def ::consumet-at inst?)
(s/def ::post-date inst?)

(s/def ::movement (s/keys :req [::id ::topic ::a/owner-account ::produced-at ::consumet-at ::user]))

(s/def ::entry (s/keys :req [::id ::amount ::a/debit-account ::a/credit-account ::post-date ::movement]))

