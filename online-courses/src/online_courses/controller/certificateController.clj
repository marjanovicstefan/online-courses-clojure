(ns online-courses.controller.certificateController
  (:require [online-courses.domain.dto.certificateDto :refer [CertificateDto]]
            [compojure.api.sweet :refer [GET POST PUT DELETE]]
            [online-courses.service.certificateService :refer [get-certificates
                                                          get-certificate
                                                          post-certificate
                                                          delete-certificate]]
            [schema.core :as schema]))

(def certificate-routes
  [(GET "/certificates/all" []
     :tags ["certificate"]
     :summary "Return all certificates"
     (get-certificates))
   (GET "/certificates/certificate/:id" []
     :path-params [id :- schema/Int]
     :summary "Get certificate by id"
     :tags ["certificate"]
     (get-certificate id))
   (POST "/certificates" []
     :tags ["certificate"]
     :body [add-certificate CertificateDto]
     :summary "Add certificate"
     :return [CertificateDto]
     (post-certificate add-certificate))
   (DELETE "/certificates/certificate/:id" []
     :tags ["certificate"]
     :summary "Certificate delete"
     :path-params [id :- schema/Int]
     (delete-certificate id))])