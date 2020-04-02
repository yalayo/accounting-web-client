(ns views.accounts.show-account
  (:require [specs.accounts.core :as spec]
            [clojure.spec.alpha :as s]
            [re-frame.core :as re-frame]))

(defn show-account-component [model]
  (let [product (get model :product)
        name (get product :name)
        image (get product :image)]
    [:div
     [:p name]
     [:p image]]))

