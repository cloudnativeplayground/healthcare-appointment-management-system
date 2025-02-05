# Healthcare Appointment Management System

A healthcare scheduling platform built with **Spring Boot** to manage doctor appointments, notifications, and role-based authentication. The application is containerized with **Docker** and supports **Kubernetes** deployment. The front-end is implemented using **Thymeleaf**.

## Features
- **Appointment Scheduling**: Patients can book, reschedule, and cancel doctor appointments.
- **Notifications & Reminders**: Automated email and SMS notifications for upcoming appointments.
- **Role-Based Authentication**: Secure access control for patients, doctors, and admins.
- **Docker & Kubernetes Support**: Easily deployable with containerization and orchestration.
- **Spring Boot Actuator**: Health checks and monitoring endpoints.
- **Gradle Build**: Uses Gradle for dependency management and build automation.
- **REST API Documentation**: API endpoints documented using OpenAPI/Swagger.

---

## Prerequisites
Ensure you have the following installed:
- **Java 17+** (JDK 17 or later)
- **Gradle 7+**
- **Docker & Docker Compose**
- **Kubernetes (Minikube, k3s, or any Kubernetes cluster)**
- **PostgreSQL/MySQL** for database management
- **Git** for version control

---

## Installation & Setup

### Clone the Repository
```sh
 git clone https://github.com/cloudnativeplayground/healthcare-appointment-management-system.git
 cd healthcare-appointment-management-system
```

### Build the Application
```sh
./gradlew build
```

### Run the Application
```sh
./gradlew bootRun
```

By default, the application runs on `http://localhost:8080`.

---

## Docker Deployment

### Build Docker Image
```sh
docker build -t healthcare-appointment-system .
```

### Run Docker Container
```sh
docker run -p 8080:8080 healthcare-appointment-system
```

---

## Kubernetes Deployment

### Apply Kubernetes Manifests
```sh
kubectl apply -f deployment/k8s/deployment.yaml
kubectl apply -f deployment/k8s/service.yaml
kubectl apply -f deployment/k8s/ingress.yaml
```

### Verify Deployment
```sh
kubectl get pods
kubectl get services
```

---

## Project Structure
```
healthcare-appointment-management-system/
│── src/
│   ├── main/java/com/cloudnativeplayground/healthcare/
│   │   ├── controller/       # REST Controllers
│   │   ├── service/          # Business logic services
│   │   ├── repository/       # Database repositories
│   │   ├── model/            # Entity models
│   │   ├── config/           # Security and application config
│   │   ├── dto/              # Data transfer objects
│   │   ├── exception/        # Custom exceptions
│   │   ├── security/         # Authentication and authorization
│   ├── resources/
│   │   ├── static/           # Static assets (CSS, JS, images)
│   │   ├── templates/        # Thymeleaf templates
│   │   ├── application.yml   # Application configurations
│   │   ├── messages.properties # Internationalization messages
│── test/                     # Unit and integration tests
│── build.gradle               # Gradle build file
│── Dockerfile                 # Docker configuration
│── deployment/k8s/            # Kubernetes manifests
│── docs/                      # API and system documentation
│── scripts/                   # Deployment and automation scripts
│── LICENSE                    # GNU 3 Public License
```

---

## API Documentation
The REST API documentation is available at:
- `http://localhost:8080/swagger-ui.html` (Swagger UI)
- `http://localhost:8080/v3/api-docs` (OpenAPI JSON)

---

## Actuator Endpoints
Spring Boot Actuator provides system health and metrics at:
- `http://localhost:8080/actuator/health` (Application health status)
- `http://localhost:8080/actuator/metrics` (Performance metrics)

---

## Workflow
1. **User Authentication**: Patients, doctors, and admins authenticate via role-based access.
2. **Appointment Scheduling**: Patients can schedule appointments, which doctors can manage.
3. **Notifications**: The system sends reminders and updates about appointments.
4. **Admin Management**: Admin users manage doctors, patients, and appointment logs.
5. **Monitoring**: Actuator endpoints and logs provide insights into system performance.

---

## Maintainer
**Aditya Pratap Bhuyan**  
Senior Architect | Developer | Instructor | Author  
[LinkedIn Profile](https://linkedin.com/in/adityabhuyan)

---

## License
This project is licensed under the **GNU General Public License v3.0**. See the [LICENSE](LICENSE) file for details.

---

## Contributions
We welcome contributions! Feel free to open issues or create pull requests.

