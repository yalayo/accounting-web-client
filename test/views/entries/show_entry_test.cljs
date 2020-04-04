(ns views.entries.show-entry-test
  (:require [views.entries.show-entry :refer [show-entry-component]]
            [specs.movements.core :as spec]
            [clojure.spec.alpha :as s]
            [clojure.test.check.generators :as gen]
            [devcards.core :refer-macros [defcard defcard-rg]]))

(defn- show-entry* [m]
  (if (s/valid? ::spec/entry m)
    [show-entry-component m]
    [:div.error
     [:h4 "Bad input"]
     [:pre [:code (s/explain-str ::spec/entry m)]]]))

(defcard-rg show-entry
  [:div
   [:h1 [:i "Initial state"]]
   [show-entry* {:id #uuid "f95c18f9-2d73-4d6c-a44a-bb3f35a79517", :amount 0.5, :debit-account {:id #uuid "f95c18f9-2d73-4d6c-a44a-bb3f35a79517", :code "001", :name "Debit account", :level 1}, :credit-account {:id #uuid "f95c18f9-2d73-4d6c-a44a-bb3f35a79517", :code "001", :name "Credit account", :level 1}, :post-date #inst "1970-01-01T00:00:00.000-00:00", :movement {:id #uuid "f95c18f9-2d73-4d6c-a44a-bb3f35a79517", :topic "topic1", :owner-account {:id #uuid "f95c18f9-2d73-4d6c-a44a-bb3f35a79571", :name "user1"}, :produced-at #inst "1970-01-01T00:00:00.000-00:00", :consumed-at #inst "1970-01-01T00:00:00.000-00:00", :user "user1"}}]])

(defcard-rg generated-show-entry
  (let [models (gen/sample (s/gen ::spec/entry))]
    [:div
     (map-indexed (fn [i m]
                    [:div {:key i}
                     [:pre (pr-str m)]
                     [show-entry* m]])
                  models)]))
