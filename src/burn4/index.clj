(ns burn4.index
  (:require [stencil.core :as must]
            [burn4.bios :as bios]))

(defn render []
  (must/render-file "html/index.html" {:rows (bios/rows)}))
