(ns views.accounts.show-account-test
  (:require [views.accounts.show-account :refer [show-account-component]]
            [specs.accounts.core :as spec]
            [clojure.spec.alpha :as s]
            [clojure.test.check.generators :as gen]
            [devcards.core :refer-macros [defcard defcard-rg]]))

(defn- show-account* [m]
  (if (s/valid? ::spec/book-account m)
    [show-account-component m]
    [:div.error
     [:h4 "Bad input"]
     [:pre [:code (s/explain-str ::spec/book-account m)]]]))

(defcard-rg show-account
  [:div
   [:h1 [:i "Initial state"]]
   [show-account* {:id #uuid "f95c18f9-2d73-4d6c-a44a-bb3f35a79517", :code "001", :name "Account", :level 1}]])

(defcard-rg generated-show-account
  (let [models (gen/sample (s/gen ::spec/book-account))]
    [:div
     (map-indexed (fn [i m]
                    [:div {:key i}
                     [:pre (pr-str m)]
                     [show-account* m]])
                  models)]))
