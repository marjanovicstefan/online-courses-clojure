(ns online-courses.domain.dto.courseDto
  (:require [schema.core :as schema]
            [online-courses.domain.model.course :refer [Course]]))

(schema/defschema CourseDto {
                             :courseName            schema/Str
                             :price                 schema/Num
                             :timeToComplete        schema/Str
                             :numberOfArticles      schema/Int
                             :numberOfExcercises    schema/Int
                             :accessOnMobileAndTv   schema/Bool
                             :certificateId         schema/Int
                             :authorId              schema/Int
                             :review                schema/Str
                             :programmingLanguageId schema/Int
                             })