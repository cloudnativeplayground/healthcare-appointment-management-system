### **Actuator Endpoints - Healthcare Appointment Management System**

Spring Boot Actuator provides built-in endpoints to monitor and manage the application. Below is the list of essential Actuator endpoints, their descriptions, and expected responses.

---

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
- **Example of Unhealthy Response:**
  ```json
  {
    "status": "DOWN",
    "components": {
      "db": {
        "status": "DOWN",
        "details": {
          "error": "Database connection failure"
        }
      }
    }
  }
  ```

### **Health Details**
- **Endpoint:** `GET /actuator/health/{component}`
- **Description:** Fetches health status for specific components like `db`, `diskSpace`, etc.
- **Example for Database Health:**
  ```
  GET /actuator/health/db
  ```
  ```json
  {
    "status": "UP",
    "details": {
      "database": "MySQL",
      "validationQuery": "SELECT 1"
    }
  }
  ```

---

## **2. Application Metrics**
### **View All Metrics**
- **Endpoint:** `GET /actuator/metrics`
- **Description:** Lists all available metrics.
- **Response:**
  ```json
  {
    "names": [
      "jvm.memory.used",
      "jvm.memory.max",
      "system.cpu.usage",
      "http.server.requests"
    ]
  }
  ```

### **View Specific Metric**
- **Endpoint:** `GET /actuator/metrics/{metricName}`
- **Example for JVM Memory Usage:**
  ```
  GET /actuator/metrics/jvm.memory.used
  ```
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
### **View Application Environment Properties**
- **Endpoint:** `GET /actuator/env`
- **Description:** Fetches all environment properties including system and application configuration.

### **View Specific Property**
- **Endpoint:** `GET /actuator/env/{propertyName}`
- **Example:**
  ```
  GET /actuator/env/server.port
  ```
  ```json
  {
    "property": {
      "server.port": "8080"
    }
  }
  ```

---

## **4. Thread Dump**
### **Fetch Thread Dump**
- **Endpoint:** `GET /actuator/threaddump`
- **Description:** Returns a thread dump of the running application.
- **Response Example:**
  ```json
  {
    "threads": [
      {
        "threadName": "main",
        "threadState": "RUNNABLE",
        "stackTrace": [
          "java.lang.Thread.run(Thread.java:748)"
        ]
      }
    ]
  }
  ```

---

## **5. HTTP Request Tracing**
### **Trace Recent Requests**
- **Endpoint:** `GET /actuator/httptrace`
- **Description:** Provides details of the last few HTTP requests and responses.
- **Response Example:**
  ```json
  {
    "traces": [
      {
        "timestamp": "2025-02-05T10:30:00",
        "request": {
          "method": "GET",
          "uri": "/api/v1/appointments",
          "headers": {
            "Authorization": "Bearer xyz"
          }
        },
        "response": {
          "status": 200
        }
      }
    ]
  }
  ```

---

## **6. Loggers**
### **View and Modify Log Levels**
- **View Loggers**
    - **Endpoint:** `GET /actuator/loggers`
    - **Description:** Fetches all application loggers.

- **View a Specific Logger**
    - **Endpoint:** `GET /actuator/loggers/com.cloudnativeplayground`
    - **Response Example:**
      ```json
      {
        "configuredLevel": "INFO",
        "effectiveLevel": "INFO"
      }
      ```

- **Modify Log Level**
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
### **Application Info**
- **Endpoint:** `GET /actuator/info`
- **Description:** Provides metadata such as application version, build time, etc.
- **Example Response:**
  ```json
  {
    "application": {
      "name": "Healthcare Appointment Management System",
      "version": "1.0.0",
      "buildTime": "2025-02-05T10:00:00"
    }
  }
  ```

---

## **8. Beans**
### **List All Beans**
- **Endpoint:** `GET /actuator/beans`
- **Description:** Returns a list of all Spring beans loaded in the application context.

---

## **9. Mappings**
### **View All Request Mappings**
- **Endpoint:** `GET /actuator/mappings`
- **Description:** Lists all available request mappings in the application.
- **Example Response:**
  ```json
  {
    "contexts": {
      "application": {
        "mappings": [
          {
            "path": "/api/v1/appointments",
            "httpMethod": "GET",
            "handler": "com.cloudnativeplayground.healthcare.controller.AppointmentController#getAppointments"
          }
        ]
      }
    }
  }
  ```

---

## **10. Shutdown (Optional)**
### **Shutdown the Application**
- **Endpoint:** `POST /actuator/shutdown`
- **Description:** Gracefully shuts down the application. **Must be explicitly enabled.**
- **Enable in `application.yml`:**
  ```yaml
  management:
    endpoint:
      shutdown:
        enabled: true
  ```

---

## **Configuration**
To enable or disable specific Actuator endpoints, modify `application.yml`:
```yaml
management:
  endpoints:
    web:
      exposure:
        include: health, metrics, info, env, loggers, httptrace, threaddump, mappings, beans
```

---

### **Conclusion**
These Actuator endpoints provide deep insights into the **Healthcare Appointment Management System**, allowing developers and DevOps teams to monitor, manage, and troubleshoot the application effectively. 🚀