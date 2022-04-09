(ns online-courses.service.courseService
  (:require [online-courses.domain.model.course :refer [Course]]
            [toucan.db :as db]
            [ring.util.http-response :refer [ok not-found method-not-allowed request-timeout created]]))

(defn id->created [id]
  (created (str "/courses" id) {:id id}))

(defn get-courses []
  (->> (db/select Course)
       ok))

(defn get-course [course-id]
  (-> (Course course-id)
      ok))

(defn post-course [add-course]
  (->> (db/insert! Course add-course)
       :id
       id->created))

(defn put-course [id course-update]
  (db/update! Course id course-update)
  (ok course-update))

(defn delete-course [id]
  (db/delete! Course :id id)
  (ok))
