(ns jaheshgeeks.core
  (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(println "This text is printed from src/jaheshgeeks/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))
(reset! app-state {:currencyList []})
(swap! app-state update-in [:text] #(str "Salam " %))


(defn Nav []
  [:nav.white
   [:div.nav-wrapper
    [:ul.nav-mobile.right.hide-on-med-and-down
     [:li
      [:a {:href "#s2"} "لیست آخرین تاریخ و ساعت به روز شدن قیمت ها"]]
     [:li [:a {:href "#s1"} "لیست انواع ارزها و قیمت"]]
     [:li [:a {:href "#home"} "صفحه اصلی"]]]]]
  )

(defn Slider []
  [:div.slider
   [:ul.slides
    [:li
     [:img {:src "images/1.jpg"}]
      [:div.caption.right-align
       [:h3 "تبلیغ 1"]
       [:h5.light.grey-text.text-lighten-3 "توضیح توضیح توضیح توضیح توضیح توضیح توضیح توضیح توضیح توضیح توضیح توضیح"]
       ]
      ]
    [:li
     [:img {:src "images/2.jpg"}]
     [:div.caption.right-align
      [:h3 "تبلیغ 2"]
      [:h5.light.grey-text.text-lighten-3 "توضیح توضیح توضیح توضیح توضیح توضیح توضیح توضیح توضیح توضیح توضیح توضیح"]
      ]
     ]
    [:li
     [:img {:src "images/1.jpg"}]
     [:div.caption.right-align
      [:h3 "تبلیغ 3"]
      [:h5.light.grey-text.text-lighten-3 "توضیح توضیح توضیح توضیح توضیح توضیح توضیح توضیح توضیح توضیح توضیح توضیح"]
      ]
     ]
    ]
   ]
)

(defn Currency []
  [:div.row.Content
   [:div.col.s4.m4.l4.center "dolar"]
   [:div.col.s4.m4.l4.center "3665 rial"]
   [:div.col.s4.m4.l4.center.up "+5%"]]
  )

(defn CurrencyList []
  [:div.row
   [:div.col.s12.m9.l9
    [:div.holder.z-depth-1
     [:div.s1.row.subtitle.center.teal.lighten-4.scrollSpy
      [:span "لیست انواع ارزها و قیمت آنها"]
      [:i.material-icons "trending_up"]]
     [:div.ContentHolder
      [:div.row.Subject
       [:div.col.s4.m4.l4.center "واحد"]
       [:div.col.s4.m4.l4.center "نرخ"]
       [:div.col.s4.m4.l4.center "نسبت به روز گذشته"]]
      [Currency]
      ]
     ]
    ]
   ]
  )

(defn hello-world []
  [:div
   [Nav]
   [Slider]
   [CurrencyList]
   ]
  )

(defn handler [response]
  (.log js/console (str response)))

(defn error-handler [{:keys [status status-text]}]
  (.log js/console (str "something bad happened: " status " " status-text)))

(reagent/render-component [hello-world]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
