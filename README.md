# springbootmongodocker
Spring boot application with mongo and docker

Setting active profiles when launching Spring Boot application via gradle
Posted on February 21, 2016
I wanted to use a profile specific application.properties file for my Spring Boot application. But Gradle was not picking it up when I ran my launched with the following command:

**gradle bootRun -Dspring.profiles.active=dev**

The solution turned out be be simply adding the snippet below to my build.gradle file. This snippet is telling Gradle to pull in the system properties.

bootRun {
    systemProperties = System.properties
}



