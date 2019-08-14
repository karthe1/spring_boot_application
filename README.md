# project description

* This is a spring boot application that exposes REST APIs for performing CRUD operations in MySQL Database.
* The application has been dockerized and deployed on the docker-machine.
* We made the two containers (Container running with Spring boot app & Container running with MySQL Database) to be communicated with each other.


# Steps to download and deploy the application 

* Check out the git repo in your local directory. ( git clone https://github.com/karthe1/spring_boot_application.git ).

* Import the spring boot project using the existing maven project option in your IDE

* Dockerize the spring boot application and dockerize the MySQL Database.
  
  * Launch 'Docker Quickstart Terminal' to login into the docker-machine.
  
  * Run the MySQL Database on the container. For this, there is already an image file that will be present on the docker hub.
  
  * Download the image file and run on the container.
  
        docker run -p 6603:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=profileInfo" mysql
  
  * Specify the MySQL container name (docker-mysql) in the application.properties file for connecting to the DB which is running on container.

        spring.datasource.url=jdbc:mysql://docker-mysql:3306/profileInfo
    
  * Create image file for spring boot application 
    
     Go to the project directory from the docker terminal (eg: ~/workspace1/spring_boot_application).
     
     There is already a dockerfile created and placed under the directory 'spring_boot_application/dockerfile'.
  
        docker build -f dockerfile -t springbootapp-docker.
     
        docker images (For checking the created image)
  
  * Once both the images are containerized, link both the containers to be communicated with each other by executing the below command.
  
        docker run -t --name springbootapp-docker --link docker-mysql:mysql -p 8080:8080 springbootapp-docker
   
  * Check the status of both the containers by executing the below command.
  
        docker ps
  
 * If both the containers are up and running, expose below REST calls using POSTMAN REST client from localhost.

      GET: http://localhost:8080/addProfile

       {
          "profileName": "karthick_rajendran",
          "firstName": "karthick",
          "lastName": "rajendran"
       }

      GET : http://localhost:8080/getProfiles/{profileId}

      GET : http://localhost:8080/getProfiles

      DELETE : http://localhost:8080/deleteProfile/{profileId}

      PUT : http://localhost:8080/updateProfile/{profileId}

       {
          "profileName": "karthick_raj",
          "firstName": "karthick",
          "lastName": "raj"
       }
 
