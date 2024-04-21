application runs on port 9090 
job runner dashboard runs on port 8000 ( http://localhost:8000/dashboard ) ( enable it from JobRunnerConfig.java L22)
uses mysql docker image

How to test the application : 

* Go to compose.yaml path and do docker compose up
* OR If you are using intellij idea run it from ide
* * If port 3361 is used feel free to change it
* Run the main class
* api : http://localhost:9090/{name}/{date}
* Example:
* curl --location 'http://localhost:9090/rivu/2024-04-20T21:36:08' \
   --header 'Accept: application/json'
* Date Time format YYYY-MM-DDTHH:mm:ss
