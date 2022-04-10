(ns online-courses.service.certificateService
  (:require [online-courses.domain.model.certificate :refer [Certificate]]
            [toucan.db :as db]
            [ring.util.http-response :refer [ok not-found method-not-allowed request-timeout created]]))

(defn id->created [id]
  (created (str "/certificates" id) {:id id}))

(defn get-certificates []
  (->> (db/select Certificate)
       ok))

(defn get-certificate [certificate-id]
  (-> (Certificate certificate-id)
      ok))

(defn post-certificate [add-certificate]
  (->> (db/insert! Certificate add-certificate)
       :id
       id->created))

(defn delete-certificate [id]
  (db/delete! Certificate :id id)
  (ok))