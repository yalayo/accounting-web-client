(ns views.accounts.show-account
  (:require [specs.accounts.core :as spec]
            [clojure.spec.alpha :as s]
            [re-frame.core :as re-frame]))

(defn show-account-component [model]
  [:div
   [:p (get model :code)]
   [:p (get model :name)]
   [:p (get model :level)]])

