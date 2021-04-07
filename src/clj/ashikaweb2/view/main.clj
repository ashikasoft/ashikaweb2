(ns ashikaweb2.view.main
  (:require
    [ashikaweb2.view.parts :as parts]))

(defn render [content]
  (parts/appbase
    [:body
     [:div.banner
      [:img.mr-1 {:src "/img/ashika48.png" :border 0}]
      "Ashikasoft"]

     [:div {:style "padding-top: 10px;"}
      [:ul.nav.nav-pills
       [:li.active [:a "Dictionary"]]]]

[:div.container
     [:h1 "Japanese Dictionary"]
     [:form.inline
      {:method :get
       :action "lookup"}
      [:label.mr-1 "Search:"]
      [:input.mr-1.input-medium.search-query
       {:type :text
        :style {:width "64%"}
        :name "word"}]
      [:input.btn
       {:type :submit
        :value "Go"}]]
     
     [:div#results
      (let [results (:results content)]
        (when (seq results)
        (map-indexed
         (fn [idx entry]
           ^{:key idx}
           [:p (str entry)])
         results)))]]

     [:div#aboutDict {:style {:clear :both}}
      [:div.articleList
       [:div.well
        [:div.lead

         [:p "A minimalist dictionary, based on Japanese dictionary data. Free, no ads, no guarantees." ] 

         [:h2 "Versions"]
         [:ul 
          [:li [:b "App server hosting "] "The site is served from a jvm-based server. On github: " [:a {:href "https://github.com/ashikasoft"} "github.com/ashikasoft"]]
          
          [:li [:b "Static hosting (github pages) "] "The entire site is static, and querying is done by querying files from the client side. May run slowly, but does not need any special application server."]
          [:li [:b "Android "] "This version works faster, because data is installed on the local device.No internet connection needed. "]
          [:li "History of previously looked up words "]
          [:li "Long-pressing makes it easy to copy and paste results."]]
         [:h2 "Licenses"]
         [:h3 "Dictionary Data"]
         [:p "This software uses 3rd party data and is not affiliated with the institutions below."]
         [:ul
          [:li "Name:　The Electronic Dictionary Research and Development Group (Attn: Assoc. Prof. Jim Breen) "]
          [:li "License：Creative Commons Attribution Share alike http://www.edrdg.org/edrdg/licence.html "]
          ]
         [:ul
          [:li "License：http://nlpwww.nict.go.jp/wn-ja/license.txt "]
          [:li " Japanese WordNet Copyright 2009, 2010 by the National Institute of Information and Communications Technology (NICT). All rights reserved. "]
          ] 
         [:h3 "Site Software"]
         [:ul
          [:li "MIT License  (source code only, excluding images and data). Images are Creative Commons Attribution, by Kean Santos. "]]
         [:p "Copyright (C) 2016 - 2021. No warranty. This site makes use of independent data and makes no representation or guarantee of accuracy."]
         ]]]]

     [:br]
     [:br]
     [:div.col-md-4
      [:table.body {:border 0}
       [:tr
        [:td [:img {:src "/img/ashika48.png" :border 0}]]
        [:td [:a.btn.btn-success
              {:href "https://play.google.com/store/apps/details?id=com.ashikasoft.android.dictionary"}
              [:font {:size 5} "Coming back soon on Google Play"]]]]
       [:tr
        [:td {:colspan 2} [:small.pull-right "For Android. Works offline!"]]]]]
     
     ]))


