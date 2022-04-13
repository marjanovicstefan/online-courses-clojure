(ns online-courses.core-test
  (:require [clojure.test :refer :all]
            [online-courses.core :refer :all]
            [online-courses.service.authorService :as authorService]
            [online-courses.service.certificateService :as certificateService]
            [online-courses.service.programmingLanguageService :as programmingLanguageService]
            [toucan.db :as db]))

(db/set-default-quoting-style! :mysql)

(db/set-default-db-connection!
  {
   :classname   "com.mysql.cj.jdbc.Driver"
   :subprotocol "mysql"
   :subname     "//localhost:3306/onlineCourses"
   :user        "Marjan"
   :password    "1234"
   })

(deftest get-authors-test
  (testing "All authors"
    (def authors (count ((authorService/get-authors) :body)))
    (authorService/post-author {
                                  :firstName   "firstName"
                                  :lastName    "lastName"
                                  :job         "Job"
                                  :dateOfBirth "2022-04-10"
                                  :about       "about"
                                })
    (is (= (inc authors) (count ((authorService/get-authors) :body))))
    )
  )

(deftest delete-author-test
  (testing "Test delete author"
    (let [author (authorService/post-author {
                                              :firstName   "firstName"
                                              :lastName    "lastName"
                                              :job         "Job"
                                              :dateOfBirth "2022-04-10"
                                              :about       "about"
                                             })]
      (authorService/delete-author ((author :body) :id))
      (is (= "Author not found" ((authorService/get-author ((author :body) :id)) :body)))
      )))

(deftest get-certificates-test
  (testing "All certificates"
    (def certificates (count ((certificateService/get-certificates) :body)))
    (certificateService/post-certificate {
                                            :certificateName   "certificateName"
                                            :dateOfCertificate "2022-04-10"
                                            :signature         "signature"
                                            :textField         "textField"
                                          }
    )
    (is (= (inc certificates) (count ((certificateService/get-certificates) :body))))
    )
  )

(deftest delete-certificate-test
  (testing "Test delete certificate"
    (let [certificate (certificateService/post-certificate {
                                                              :certificateName   "certificateName"
                                                              :dateOfCertificate "2022-04-10"
                                                              :signature         "signature"
                                                              :textField         "textField"
                                                            })]
      (certificateService/delete-certificate ((certificate :body) :id))
      (is (= "Certificate not found" ((certificateService/get-certificate ((certificate :body) :id)) :body)))
      )))

(deftest get-programming-languages-test
  (testing "All programming languages"
    (def programmingLanguages (count ((programmingLanguageService/get-programming-languages) :body)))
    (programmingLanguageService/post-programming-language
      {
        :name                   "Certificate name"
        :levelOfLanguage        "High level"
        :currentVersion         "Current version"
      }
    )
    (is (= (inc programmingLanguages) (count ((programmingLanguageService/get-programming-languages) :body))))
    )
  )

(deftest delete-programming-language-test
  (testing "Test delete programming language"
    (let [programmingLanguage (programmingLanguageService/post-programming-language
                                {
                                  :name                   "Certificate name"
                                  :levelOfLanguage        "High level"
                                  :currentVersion         "Current version"
                                }
                              )
          ]
      (programmingLanguageService/delete-programming-language ((programmingLanguage :body) :id))
      (is (= "Programming language not found" ((programmingLanguageService/get-programming-language
                                                 ((programmingLanguage :body) :id)) :body)))
      )))
