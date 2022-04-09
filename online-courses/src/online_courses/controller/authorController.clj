(ns online-courses.controller.authorController
    (:require [online-courses.domain.dto.authorDto :refer [AuthorDto]]
      [compojure.api.sweet :refer [GET POST PUT DELETE]]
      [online-courses.service.authorService :refer [get-authors
                                                    get-author
                                                    post-author
                                                    put-author
                                                    delete-author]]
      [schema.core :as schema]))

(def author-routes
  [(GET "/authors/all" []
        :tags ["author"]
        :summary "Return all authors"
        (get-authors))
   (GET "/authors/author/:id" []
        :path-params [id :- schema/Int]
        :summary "Get author by id"
        :tags ["author"]
        (get-author id))
   (POST "/authors/author" []
         :tags ["author"]
         :body [add-course AuthorDto]
         :summary "Add author"
         :return [AuthorDto]
         (post-author add-course))
   (PUT "/authors/author/:id" []
        :tags ["author"]
        :summary "Author update"
        :path-params [id :- schema/Int]
        :body [course-update AuthorDto]
        (put-author id course-update))
   (DELETE "/authors/author/:id" []
           :tags ["author"]
           :summary "Author delete"
           :path-params [id :- schema/Int]
           (delete-author id))])
