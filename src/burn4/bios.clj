(ns burn4.bios
  (:require [stencil.core :as must]
            [clojure.java.io :as io]))

(def raw {:hammer    {:name "Hammer Switch"
                      :double? true}
          :cloudbird {:name "Cloud Bird"
                      :double? true}
          :matt      {:name "Matt Thomson"}
          :bamboo    {:name "Mr Bamboo"
                      :double? true}
          :tony      {:name "Tony Wilson"}
          :balaclava {:name "Balaclava Weather"
                      :double? true}
          :jasmine   {:name "Jasmine Beth"}
          :stump     {:name "The Stump Jumpers"
                      :double? true}
          :laser     {:name "LASER"}
          })

(defn act [id]
  (let [{:keys [double?] :as act} (id raw)
        bio (io/resource (str "html/" (name id)  ".html"))]
    (assoc act
           :image (name id)
           :width (if double? "two" "")
           :center (if double? false true)
           :bio (when bio (slurp bio)))))

(defn rows []
  (shuffle (map (fn [acts]
                  {:acts (shuffle acts)})
                [[(act :matt)
                  (act :balaclava)]
                 [(act :cloudbird)
                  (act :jasmine)]
                 [(act :october)
                  (act :bamboo)]
                 [(act :hammer)
                  (act :tony)]
                 [(act :stump)
                  (act :laser)]])))

