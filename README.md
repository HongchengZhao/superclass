# superclass

## 1. Tools

### 1.1 Backend

#### Spring Boot

1. follow the instructions in this [link](https://docs.spring.io/spring-boot/docs/2.1.0.RELEASE/reference/htmlsingle/#getting-started-installation-instructions-for-java) to install Spring Boot.

   *NOTE:* for build tools, we choose to use **Gradle**.

2. The code structure looks like this:

   ```shell
   com
       +- superclass
           +- server
               +- Application.java
               |
               +- model
               |    +- Product.java
               +- dao
               |    +- ProductRepository.java
               +- controller
               |    +- ProductController.java
               +- service
               |    +- ProductService.java
   ```


3. To run the server, use the command line below

   ```shell
   # inside the folder ~/server
   gradlew bootRun
   ```



###1.2 Frontend

#### React Native

1. follow the instructions in this [link](https://reactnative.cn/docs/getting-started.html) to install React Native

2. To run the app, use the command line below

   ```shell
   # inside the folder ~/superclass
   react-native link
   
   # for android platform
   react-native run-andorid
   
   # for ios platform
   react-native run-ios
   ```


