(ns burn3.bios
  (:require [stencil.core :as must]
            [clojure.java.io :as io]))

(def raw {:sametribe {:name "Sally King and SameTribe"
                      :double? true}
          :cloudbird {:name "Cloud Bird"
                      :double? true}
          :matt      {:name "Matt Thomson"}
          :bamboo    {:name "Mr Bamboo"
                      :double? true}
          :elisabeth {:name "Elizabeth Robinson"}
          :drt       {:name "Dr. T"}
          :dani      {:name "Dani Karis"}
          :tony      {:name "Tony Wilson"}
          :nathan    {:name "Mr Harvey"}
          :balaclava {:name "Balaclava Weather"
                      :double? true}
          :october   {:name "Born in October"}
          :what8was4 {:name "WHAT8WAS4"}
          :jasmine   {:name "Jasmine Beth"}
          :rocky     {:name "The Rocky Hillbillies"
                      :double? true}
          :laser     {:name "LASER"}
          :street    {:name "Street Party"}
          :chesher   {:name "John Chesher"}
          :nick      {:name "Nick Rheinberger"
                      :double? true}
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
                  (act :cloudbird)
                  (act :balaclava)]])))

