(ns online-courses.controller.courseController
  (:require [online-courses.domain.dto.courseDto :refer [CourseDto]]
            [compojure.api.sweet :refer [GET]]
             [online-courses.service.courseService :refer [getCourses]]))

(def course-routes
  [(GET "/course/all" []
        (getCourses))])