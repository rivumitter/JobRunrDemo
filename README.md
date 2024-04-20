application runs on port 9090 
job runner dashboard runs on port 8000 ( http://localhost:8000/dashboard )
uses in-memory h2 ( feel free to add your own DB )

How to test the application : 

* Run the main class
* api : http://localhost:9090/{name}/{date}
* Example:
* curl --location 'http://localhost:9090/rivu/2024-04-20T21:36:08' \
   --header 'Accept: application/json'
* Date Time format YYYY-MM-DDTHH:mm:ss
