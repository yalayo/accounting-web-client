(ns views.movements.show-movement
  (:require [specs.movements.core :as spec]
            [clojure.spec.alpha :as s]
            [re-frame.core :as re-frame]))

(defn show-movement-component [model]
  [:div
   [:p (get model :topic)]
   [:p (get model :user)]])

