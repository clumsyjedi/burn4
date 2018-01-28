(ns burn3.index
  (:require [stencil.core :as must]
            [burn3.bios :as bios]))

(defn render []
  (must/render-file "html/index.html" {:rows (bios/rows)}))
