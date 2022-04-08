(ns online-courses.service.courseService
  (:require [online-courses.domain.model.course :refer [Course]]
            [toucan.db :as db]
            [ring.util.http-response :refer [ok not-found method-not-allowed request-timeout created]]))

(defn getCourses []
  (->> (db/select Course)
       ok))
