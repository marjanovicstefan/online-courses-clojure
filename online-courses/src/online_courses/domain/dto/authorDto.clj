(ns online-courses.domain.dto.authorDto
  (:require [schema.core :as schema]
            [online-courses.domain.model.author :refer [Author]]))

(schema/defschema AuthorDto {
                             :firstName             schema/Str
                             :lastName              schema/Str
                             :job                   schema/Str
                             :dateOfBirth           schema/Inst
                             :about                 schema/Str
                             })
