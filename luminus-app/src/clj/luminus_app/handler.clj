(ns luminus-app.handler
  (:require 
            [luminus-app.layout :refer [error-page]]
            [luminus-app.routes.home :refer [home-routes]]
            [compojure.core :refer [routes wrap-routes]]
            [compojure.route :as route]
            [luminus-app.env :refer [defaults]]
            [mount.core :as mount]
            [luminus-app.middleware :as middleware]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(mount/defstate app
  :start
  (middleware/wrap-base
    (routes
      (-> #'home-routes
          (wrap-routes middleware/wrap-csrf)
          (wrap-routes middleware/wrap-formats))
          (route/not-found
             (:body
               (error-page {:status 404
                            :title "page not found"}))))))

