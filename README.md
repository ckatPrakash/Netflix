# Netflix-Style Login Web Application

## Overview

This project is a Maven-based Java web application that simulates a Netflix-style login interface. The application includes a login servlet, JSP page, and unit tests. The final build produces a WAR file that can be deployed on Apache Tomcat 9+.

## Project Structure

- `pom.xml`: Maven configuration file with dependencies and build settings.
- `src/main/java`: Java source code, including `LoginServlet.java`.
- `src/main/webapp`: Web application resources, including `WEB-INF/web.xml` and `login.jsp`.
- `src/test/java`: Unit tests for the servlet.

## Requirements

- Java 11
- Apache Maven 3.6+
- Apache Tomcat 9+

## Build and Deployment

### Build the Project

1. Navigate to the project directory.
2. Run the following command to build the project and generate the WAR file:

   ```sh
   mvn clean package
   ```

3. The generated WAR file will be located in the `target` directory.

### Deploy to Apache Tomcat

1. Copy the generated WAR file (`netflix-login-1.0-SNAPSHOT.war`) to the `webapps` directory of your Apache Tomcat installation.
2. Start or restart the Tomcat server.
3. Access the application at `http://localhost:8080/netflix-login-1.0-SNAPSHOT/login`.

## Testing

### Run Unit Tests

1. To run the unit tests, execute the following command:

   ```sh
   mvn test
   ```

## Features

- Netflix-style login page with email, password, "Remember me" checkbox, and "Need help?" link.
- Error handling for invalid credentials.
- "Remember me" functionality using cookies.
- Responsive design elements.

## Bonus Features

- Error handling for invalid credentials.
- "Remember me" functionality using cookies.
- Responsive design elements.

## License

This project is licensed under the MIT License.