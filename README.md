This is a test.
This is only a test.

This was developed using intelliJ, Java 8, and Spring boot.

Please clone the repository, and run the application using:
gradle bootRun
(or gradlew, or ./gradle, or ....)

you should be able to use a browser to see an event at http://localhost:8080/event/0
you should be able to use postman to submit (POST) an event at http://localhost:/8080/event
   Initial json event structure:
   {
     "title": "A title",
     "description": "A description"
   }