(ns online-courses.service.authorService
  (:require [online-courses.domain.model.author :refer [Author]]
            [toucan.db :as db]
            [ring.util.http-response :refer [ok not-found method-not-allowed request-timeout created]]))

(defn id->created [id]
  (created (str "/authors" id) {:id id}))

(defn get-authors []
  (->> (db/select Author)
       ok))

(defn get-author [author-id]
  (-> (Author author-id)
      ok))

(defn post-author [add-author]
  (->> (db/insert! Author add-author)
       :id
       id->created))

(defn put-author [id author-update]
  (db/update! Author id author-update)
  (ok author-update))

(defn delete-author [id]
  (db/delete! Author :id id)
  (ok))
