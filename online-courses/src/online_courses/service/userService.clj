(ns online-courses.service.userService
  (:require [online-courses.domain.model.user :refer [User]]
            [toucan.db :as db]
            [ring.util.http-response :refer [ok not-found method-not-allowed request-timeout created]]))

(defn id->created [id]
  (created (str "/users" id) {:id id}))

(defn get-users []
  (->> (db/select User)
       ok))

(defn user-response [User]
  (if User
    (ok User)
    (not-found "User not found")))

(defn get-user [user-id]
  (-> (User user-id)
      user-response))

(defn post-user [add-user]
  (->> (db/insert! User add-user)
       :id
       id->created))

(defn put-user [id user-update]
  (db/update! User id user-update)
  (ok user-update))

(defn delete-user [id]
  (db/delete! User :id id)
  (ok "Deleted successfully!"))
