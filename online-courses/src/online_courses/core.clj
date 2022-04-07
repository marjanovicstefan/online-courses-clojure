(ns online-courses.core
  (:require
  [toucan.db :as db])
  (:gen-class))

(def db-conf
  {:classname   "com.mysql.cj.jdbc.Driver"
   :subprotocol "mysql"
   :subname     "//localhost:3306/onlineCourses"
   :user        "Marjan"
   :password    "1234"
   :useSSL      false
   })

(defn -main
  [& args]
  (db/set-default-db-connection! db-conf)
  (db/set-default-quoting-style! :mysql)
  (println "Online Courses is up!"))
