(ns online-courses.domain.dto.certificateDto
  (:require [schema.core :as schema]
            [online-courses.domain.model.certificate :refer [Certificate]]))

(schema/defschema CertificateDto {
                             :certificateName       schema/Str
                             :dateOfCertificate     schema/Inst
                             :signature             schema/Str
                             :textField             schema/Str
                             })
