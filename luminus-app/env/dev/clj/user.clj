(ns user
  (:require [luminus-app.config :refer [env]]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]
            [luminus-app.core :refer [start-app]]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'luminus-app.core/repl-server))

(defn stop []
  (mount/stop-except #'luminus-app.core/repl-server))

(defn restart []
  (stop)
  (start))


