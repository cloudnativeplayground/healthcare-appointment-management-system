### REST API Documentation 

# REST API Documentation - Healthcare Appointment Management System

## Base URL
```
http://localhost:8080/api/v1
```

---

## **1. Authentication & Authorization**

### **User Registration**
- **Endpoint:** `POST /auth/register`
- **Description:** Registers a new user.
- **Request Body:**
  ```json
  {
    "name": "John Doe",
    "email": "johndoe@example.com",
    "password": "securepassword",
    "role": "PATIENT"
  }
  ```
- **Response:**
  ```json
  {
    "message": "User registered successfully",
    "userId": 1
  }
  ```

### **User Login**
- **Endpoint:** `POST /auth/login`
- **Description:** Authenticates the user.
- **Request Body:**
  ```json
  {
    "email": "johndoe@example.com",
    "password": "securepassword"
  }
  ```
- **Response:**
  ```json
  {
    "token": "jwt-token-string"
  }
  ```

---

## **2. Appointments**

### **Schedule an Appointment**
- **Endpoint:** `POST /appointments`
- **Description:** Schedules an appointment with a doctor.
- **Request Header:** `Authorization: Bearer <JWT Token>`
- **Request Body:**
  ```json
  {
    "doctorId": 1,
    "patientId": 2,
    "appointmentDate": "2025-02-10T10:00:00"
  }
  ```
- **Response:**
  ```json
  {
    "message": "Appointment scheduled successfully",
    "appointmentId": 123
  }
  ```

### **Get Appointments for a User**
- **Endpoint:** `GET /appointments/user/{userId}`
- **Description:** Retrieves all appointments for a given user.
- **Response:**
  ```json
  [
    {
      "appointmentId": 123,
      "doctorId": 1,
      "patientId": 2,
      "appointmentDate": "2025-02-10T10:00:00",
      "status": "CONFIRMED"
    }
  ]
  ```

---

## **3. Notifications & Reminders**

### **Get User Notifications**
- **Endpoint:** `GET /notifications/{userId}`
- **Description:** Fetches all notifications for a user.
- **Response:**
  ```json
  [
    {
      "notificationId": 1,
      "message": "Your appointment is scheduled for 2025-02-10 at 10:00 AM",
      "status": "UNREAD"
    }
  ]
  ```

---

## **4. Doctors & Patients**

### **List Available Doctors**
- **Endpoint:** `GET /doctors`
- **Description:** Retrieves a list of available doctors.
- **Response:**
  ```json
  [
    {
      "doctorId": 1,
      "name": "Dr. Smith",
      "specialization": "Cardiologist",
      "availability": "Monday to Friday, 9 AM - 5 PM"
    }
  ]
  ```

### **Get Patient Details**
- **Endpoint:** `GET /patients/{patientId}`
- **Description:** Fetches patient details by ID.
- **Response:**
  ```json
  {
    "patientId": 2,
    "name": "John Doe",
    "email": "johndoe@example.com",
    "age": 30
  }
  ```

---

## **5. Admin Panel (Role-Based Access)**

### **Approve or Reject an Appointment**
- **Endpoint:** `PUT /admin/appointments/{appointmentId}`
- **Description:** Approves or rejects an appointment (Admin access only).
- **Request Body:**
  ```json
  {
    "status": "APPROVED"
  }
  ```
- **Response:**
  ```json
  {
    "message": "Appointment status updated successfully"
  }
  ```

---

## **6. Health Monitoring**
### **Check API Health**
- **Endpoint:** `GET /health`
- **Description:** Provides API health status.
- **Response:**
  ```json
  {
    "status": "UP"
  }
  ```

---

## **7. Error Handling**
Common error responses:
```json
{
  "timestamp": "2025-02-05T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Invalid input data"
}
```
```
```

---

### **Actuator Endpoints Documentation (`Actuator_Endpoints.md`)**
```markdown
# Actuator Endpoints Documentation - Healthcare Appointment Management System

Spring Boot Actuator provides various built-in endpoints to monitor and manage the application.

## **Base URL**
```
http://localhost:8080/actuator
```

---

## **1. Health Monitoring**
### **Application Health Check**
- **Endpoint:** `GET /actuator/health`
- **Description:** Checks the overall health of the application.
- **Response:**
  ```json
  {
    "status": "UP"
  }
  ```

---

## **2. Metrics**
### **Application Metrics**
- **Endpoint:** `GET /actuator/metrics`
- **Description:** Provides details about application metrics.

### **Specific Metric Example**
- **Endpoint:** `GET /actuator/metrics/jvm.memory.used`
- **Description:** Returns JVM memory usage details.
- **Response:**
  ```json
  {
    "name": "jvm.memory.used",
    "measurements": [
      {
        "statistic": "VALUE",
        "value": 524288000
      }
    ]
  }
  ```

---

## **3. Environment Information**
### **Application Properties**
- **Endpoint:** `GET /actuator/env`
- **Description:** Provides details of environment variables and properties.

---

## **4. Thread Dump**
### **Application Thread Dump**
- **Endpoint:** `GET /actuator/threaddump`
- **Description:** Returns the current thread dump of the application.

---

## **5. HTTP Request Tracing**
### **Trace Recent Requests**
- **Endpoint:** `GET /actuator/httptrace`
- **Description:** Provides details of recent HTTP requests and responses.

---

## **6. Loggers**
### **View and Modify Log Levels**
- **Endpoint:** `GET /actuator/loggers`
- **Description:** Retrieves details about all loggers.
- **Modify Log Level:**
    - **Endpoint:** `POST /actuator/loggers/com.cloudnativeplayground`
    - **Request Body:**
      ```json
      {
        "configuredLevel": "DEBUG"
      }
      ```
    - **Response:**
      ```json
      {
        "message": "Log level updated"
      }
      ```

---

## **7. System Information**
### **View System Information**
- **Endpoint:** `GET /actuator/info`
- **Description:** Displays system information, such as version and build time.

---

## **8. Shutdown (Optional)**
### **Gracefully Shutdown the Application**
- **Endpoint:** `POST /actuator/shutdown`
- **Description:** Shuts down the application (must be explicitly enabled).

---

## **Configuration**
To enable or disable specific actuator endpoints, modify `application.yml`:
```yaml
management:
  endpoints:
    web:
      exposure:
        include: health, metrics, info, env, loggers, httptrace, threaddump
```
---
These **REST API** and **Actuator** documentation files ensure that developers and DevOps teams can effectively use, monitor, and troubleshoot the **Healthcare Appointment Management System**. 🚀