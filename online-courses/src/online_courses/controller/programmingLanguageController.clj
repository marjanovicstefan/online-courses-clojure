(ns online-courses.controller.programmingLanguageController
  (:require [online-courses.domain.dto.programmingLanguageDto :refer [ProgrammingLanguageDto]]
            [compojure.api.sweet :refer [GET POST PUT DELETE]]
            [online-courses.service.programmingLanguageService :refer [get-programming-languages
                                                                       get-programming-language
                                                                       post-programming-language
                                                                       put-programming-language
                                                                       delete-programming-language]]
            [schema.core :as schema]))

(def programming-language-routes
  [(GET "/programmingLanguages/all" []
     :tags ["programmingLanguage"]
     :summary "Return all programming languages"
     (get-programming-languages))
   (GET "/programmingLanguages/programmingLanguage/:id" []
     :path-params [id :- schema/Int]
     :summary "Get programming language by id"
     :tags ["programmingLanguage"]
     (get-programming-language id))
   (POST "/programmingLanguages" []
     :tags ["programmingLanguage"]
     :body [add-programming-language ProgrammingLanguageDto]
     :summary "Add programming language"
     :return [ProgrammingLanguageDto]
     (post-programming-language add-programming-language))
   (PUT "/programmingLanguages/programmingLanguage/:id" []
     :tags ["programmingLanguage"]
     :summary "Programming language update"
     :path-params [id :- schema/Int]
     :body [programming-language-update ProgrammingLanguageDto]
     (put-programming-language id programming-language-update))
   (DELETE "/programmingLanguages/programmingLanguage/:id" []
     :tags ["programmingLanguage"]
     :summary "Programming language delete"
     :path-params [id :- schema/Int]
     (delete-programming-language id))])