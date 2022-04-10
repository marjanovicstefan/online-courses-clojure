(ns online-courses.service.programmingLanguageService
  (:require [online-courses.domain.model.programmingLanguage :refer [ProgrammingLanguage]]
            [toucan.db :as db]
            [ring.util.http-response :refer [ok not-found method-not-allowed request-timeout created]]))

(defn id->created [id]
  (created (str "/programming-languages" id) {:id id}))

(defn get-programming-languages []
  (->> (db/select ProgrammingLanguage)
       ok))

(defn get-programming-language [programming-language-id]
  (-> (ProgrammingLanguage programming-language-id)
      ok))

(defn post-programming-language [add-programming-language]
  (->> (db/insert! ProgrammingLanguage add-programming-language)
       :id
       id->created))

(defn put-programming-language [id programming-language-update]
  (db/update! ProgrammingLanguage id programming-language-update)
  (ok programming-language-update))

(defn delete-programming-language [id]
  (db/delete! ProgrammingLanguage :id id)
  (ok))