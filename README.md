online-courses-clojure project

Online-courses-clojure project is project written in Clojure programming language, which is one of the better known functional programming languages.
This project was written by a student of the Master studies for the purpose of successfully finishing the subject Software engineering tools.

This README file contains:
1. Application description
2. How to run an application
3. Technologies used in the application
4. References
 
 

**Application description**

Today, knowledge in the world of programming is highly valued and well paid. The age in which we live has already been called the "age of computers", so more and more people are being educated in the field of computer applications and programming in order to keep up with the times and technologies.
It is necessary to develop a web application that will provide the services of Internet courses for learning programming. This application is a CRUD web application for online courses, written in the clojure programming language. The application contains several controllers, through which the user can read, enter, update and delete data from the database. 

Relational model:

Author(**Id**, firstName, lastName, job, dateOfBirth, about)

Certificate(**Id**, certificateName, dateOfCertificate, signature, textField)

ProgrammingLanguage(**Id**, name, levelOfLanguage, currentVersion)

User(**Id**, firstName, lastName, dateOfBirth, userName, pw, creditCardNumber, roles)

Course(**Id**, price, timeToComplete, numberOfArticles, numberOfExcercises, accessOnMobileAndTv, certificateId, authorId, review, programmingLanguageId)



**How to run an application**

Firstly, it is necessary to install all the necessary dependencies. When we type **lein deps** command in terminal, all necessary dependecies defined in the project will be installed.

**lein run** command will start the application. Once it's started, the output in terminal will be:

![image](https://user-images.githubusercontent.com/73475725/163237064-8b51c2b1-302a-4bd6-b94e-37ad30c1a706.png)

Once we visit: http://localhost:3123/swagger/index.html, we should see swagger page:

![image](https://user-images.githubusercontent.com/73475725/163237177-3e29d044-a2d3-4ad8-b04b-4e20b8c15f36.png)


Typing **lein test** command in terminal wil run all the tests that are written.

![image](https://user-images.githubusercontent.com/73475725/163237366-1cd48813-67d4-4ce5-95fa-3a00e5c6e713.png)

**Technologies used in the application**

**compojure-api** provides a powerful and easy to use way to build web APIs declaratively. It is a API library.

**Ring** is a Clojure web applications library inspired by Python's WSGI and Ruby's Rack. By abstracting the details of HTTP into a simple, unified API, Ring allows web applications to be constructed of modular components that can be shared among a variety of applications, web servers, and web frameworks.

**ring-jetty-adapter** - a Ring adapter that uses the Jetty webserver.

**ring**-cors - Ring middleware for Cross-Origin Resource Sharing.

**Toucan** - provides helper functions for querying the DB and inserting or updating records using Toucan models.

**Schema** is used for describing data shapes, with features like: data validation, annotation...

For data storage, **onlineCourses** mysql database is created. Lines of code listed under are used for database configuration (core.clj file):

:classname   "com.mysql.cj.jdbc.Driver"	

:subprotocol "mysql"

:subname     "//localhost:3306/onlineCourses"

:user        "Marjan"

:password    "1234"



**References**

Clojure for the brave and true: https://www.braveclojure.com/clojure-for-the-brave-and-true/

Compojure api: https://metosin.github.io/compojure-api/doc/

Ring clojure: https://github.com/ring-clojure

Getting started with compojure api: https://www.anthony-galea.com/blog/post/getting-started-with-compojure-api/

Clojure from the scratch: https://oli.me.uk/clojure-projects-from-scratch/

Clojure with database: https://fuqua.io/blog/2013/12/rest-apis-and-relational-databases-in-clojure/

Clojure example: https://www.exoscale.com/syslog/clojure-application-tutorial/

Ring cors: https://github.com/r0man/ring-cors
