(ns online-courses.core
  (:require
  [toucan.db :as db]
  [toucan.models :as models]
  [ring.adapter.jetty :refer [run-jetty]]
  [compojure.api.sweet :refer [api routes]]
  [ring.util.http-response :refer :all]
  [ring.middleware.cors :refer [wrap-cors]]
  [online-courses.controller.courseController :refer [course-routes]]
  [online-courses.controller.authorController :refer [author-routes]]
  [online-courses.controller.userController :refer [user-routes]]
  [online-courses.controller.certificateController :refer [certificate-routes]]
  [online-courses.controller.programmingLanguageController :refer [programming-language-routes]])
  (:gen-class))

(def db-conf
  {:classname   "com.mysql.cj.jdbc.Driver"
   :subprotocol "mysql"
   :subname     "//localhost:3306/onlineCourses"
   :user        "Marjan"
   :password    "1234"
   :useSSL      false
   })

(def swagger-config
  {
   :ui      "/swagger"
   :spec    "/swagger.json"
   :options {:ui   {:validatorUrl nil}
             :data {:info {:version "1.0.0", :title "Online courses"}}}
   })

(def app
  (-> (api {:swagger swagger-config} (apply routes course-routes author-routes user-routes certificate-routes
                                            programming-language-routes))
      (wrap-cors :access-control-allow-origin #"http://localhost:4200"
                 :access-control-allow-methods [:get :post :put :delete])))


(defn -main
  [& args]
  (db/set-default-db-connection! db-conf)
  (db/set-default-quoting-style! :mysql)
  (models/set-root-namespace! `online_courses.domain.model)
  (run-jetty app {:port 3123})
  (println "OnlineCourses app is running!"))
