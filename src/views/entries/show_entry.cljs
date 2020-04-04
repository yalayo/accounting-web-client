(ns views.entries.show-entry
  (:require [specs.movements.core :as spec]
            [clojure.spec.alpha :as s]
            [re-frame.core :as re-frame]))

(defn show-entry-component [model]
  [:div
   [:p (get (get model :debit-account) :name)]
   [:p (get (get model :credit-account) :name)]
   [:p (str (get model :amount))]])
