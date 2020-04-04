(ns views.movements.show-movement-test
  (:require [views.movements.show-movement :refer [show-movement-component]]
            [specs.movements.core :as spec]
            [clojure.spec.alpha :as s]
            [clojure.test.check.generators :as gen]
            [devcards.core :refer-macros [defcard defcard-rg]]))

(defn- show-movement* [m]
  (if (s/valid? ::spec/movement m)
    [show-movement-component m]
    [:div.error
     [:h4 "Bad input"]
     [:pre [:code (s/explain-str ::spec/movement m)]]]))

(defcard-rg show-movement
  [:div
   [:h1 [:i "Initial state"]]
   [show-movement* {:id #uuid "f95c18f9-2d73-4d6c-a44a-bb3f35a79517", :topic "topic1", :owner-account {:id #uuid "f95c18f9-2d73-4d6c-a44a-bb3f35a79571", :name "user1"}, :produced-at #inst "1970-01-01T00:00:00.000-00:00", :consumed-at #inst "1970-01-01T00:00:00.000-00:00", :user "user1"}]])

(defcard-rg generated-show-movement
  (let [models (gen/sample (s/gen ::spec/movement))]
    [:div
     (map-indexed (fn [i m]
                    [:div {:key i}
                     [:pre (pr-str m)]
                     [show-movement* m]])
                  models)]))
