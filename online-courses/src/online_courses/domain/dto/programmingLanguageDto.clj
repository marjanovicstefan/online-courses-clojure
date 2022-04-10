(ns online-courses.domain.dto.programmingLanguageDto
  (:require [schema.core :as schema]
            [online-courses.domain.model.programmingLanguage :refer [ProgrammingLanguage]]))

(schema/defschema ProgrammingLanguageDto {
                             :name                  schema/Str
                             :levelOfLanguage       schema/Str
                             :currentVersion        schema/Str
                             })
