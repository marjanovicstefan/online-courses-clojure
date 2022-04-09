(ns online-courses.controller.userController
  (:require [online-courses.domain.dto.userDto :refer [UserDto]]
            [compojure.api.sweet :refer [GET POST PUT DELETE]]
            [online-courses.service.userService :refer [get-users
                                                          get-user
                                                          post-user
                                                          put-user
                                                          delete-user]]
            [schema.core :as schema]))

(def user-routes
  [(GET "/users/all" []
     :tags ["user"]
     :summary "Return all users"
     (get-users))
   (GET "/users/user/:id" []
     :path-params [id :- schema/Int]
     :summary "Get user by id"
     :tags ["user"]
     (get-user id))
   (POST "/users/user" []
     :tags ["user"]
     :body [add-user UserDto]
     :summary "Add user"
     :return [UserDto]
     (post-user add-user))
   (PUT "/users/user/:id" []
     :tags ["user"]
     :summary "User update"
     :path-params [id :- schema/Int]
     :body [user-update UserDto]
     (put-user id user-update))
   (DELETE "/users/user/:id" []
     :tags ["user"]
     :summary "User delete"
     :path-params [id :- schema/Int]
     (delete-user id))])

