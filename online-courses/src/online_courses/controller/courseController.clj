(ns online-courses.controller.courseController
  (:require [online-courses.domain.dto.courseDto :refer [CourseDto]]
            [compojure.api.sweet :refer [GET POST PUT DELETE]]
            [online-courses.service.courseService :refer [get-courses
                                                          get-course
                                                          post-course
                                                          put-course
                                                          delete-course]]
            [schema.core :as schema]))

(def course-routes
  [(GET "/courses/all" []
        :tags ["course"]
        :summary "Return all courses"
        (get-courses))
   (GET "/courses/course/:id" []
     :path-params [id :- schema/Int]
     :summary "Get course by id"
     :tags ["course"]
     (get-course id))
   (POST "/courses" []
         :tags ["course"]
         :body [add-course CourseDto]
         :summary "Add course"
         :return [CourseDto]
         (post-course add-course))
   (PUT "/courses/course/:id" []
        :tags ["course"]
        :summary "Course update"
        :path-params [id :- schema/Int]
        :body [course-update CourseDto]
        (put-course id course-update))
   (DELETE "/courses/course/:id" []
           :tags ["course"]
           :summary "Course delete"
           :path-params [id :- schema/Int]
           (delete-course id))])