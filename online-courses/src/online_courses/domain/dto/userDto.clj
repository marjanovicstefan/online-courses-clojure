(ns online-courses.domain.dto.userDto
  (:require [schema.core :as schema]
            [online-courses.domain.model.user :refer [User]]))

(schema/defschema UserDto {
                           :firstName            schema/Str
                           :lastName             schema/Str
                           :dateOfBirth          schema/Inst
                           :userName             schema/Str
                           :pw                   schema/Str
                           :creditCardNumber     schema/Str
                           :roles                schema/Str
                           })
