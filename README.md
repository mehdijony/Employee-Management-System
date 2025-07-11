# 🧑‍💼 Employee Management System

A web-based **Employee Management System** built with **Angular**, **Spring Boot**, and **Oracle Database**. The system enables management of employee records including listing, searching, updating, deleting, and importing from XML.

---

## ✅ Features

* 📄 List all employees (ID, Name, Division, Title, etc.)
* 🔍 Search by **Employee ID**
* ✏️ Update employee records
* ❌ Delete employee records
* 📥 Import employees via **XML file**
* 🌐 RESTful APIs with Swagger UI

---

## 🛠️ Technologies Used

| Technology  | Version        | Purpose                              |
| ----------- | -------------- | ------------------------------------ |
| Angular CLI | 20.1.0         | Frontend UI                          |
| Node.js     | 20.19.3        | JavaScript runtime for Angular       |
| npm         | 11.4.2         | Package manager                      |
| Java        | 21             | Backend development with Spring Boot |
| Spring Boot | Latest         | Backend REST API framework           |
| Oracle DB   | Latest         | Relational database                  |
| OS          | Windows 64-bit | Development environment              |

---

## ⚙️ Prerequisites

Ensure the following are installed:

* [Node.js](https://nodejs.org)
* Angular CLI:

  ```bash
  npm install -g @angular/cli
  ```
* [Java JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
* [Oracle Database](https://www.oracle.com/database/)
* [Maven](https://maven.apache.org/) (optional if using `./mvnw`)

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository

```bash
    git clone https://github.com/mehdijony/Employee-Management-System.git
    cd Employee-Management-System
```

---

### 2️⃣ Set Up Oracle Database

* Create a schema named: `EMPLOYEE_MANAGEMENT_SYSTEM`
* Use the SQL scripts in the `database` folder to create necessary tables

> 💡 Note: Ensure your Spring Boot application connects properly to Oracle using the correct JDBC URL and Oracle driver.

---

### 3️⃣ Run the Spring Boot Backend

```bash
  cd backend
```

* Update Oracle DB connection in `src/main/resources/application.properties`:

```properties
    spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
    spring.datasource.username=SERVER
    spring.datasource.password=1
    spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
```

* Run the application:

```bash
  ./mvnw spring-boot:run
```

* Access Swagger UI:
  👉 `http://localhost:8080/swagger-ui/index.html#/employee-controller`

---

### 4️⃣ Run the Angular Frontend

```bash
    cd ../frontend
    npm install
    ng serve
```

* Access the app at:
  👉 `http://localhost:4200`

---

## 🎥 Demo Video

Watch the system in action:
[🎬 Download Demo Video](https://www.mediafire.com/file/cswo1r802pii8v0/Screen+Recording+2025-07-11+213955.mp4/file)

---

## 📂 Functional Specs

| Functionality      | Description                                                                 |
| ------------------ | --------------------------------------------------------------------------- |
| **List Employees** | Shows all employees with key details                                        |
| **Search by ID**   | Quickly find employees by unique ID                                         |
| **Update Records** | Search by name, then update division, title, building, room, etc.           |
| **Delete Records** | Remove employees using their Employee ID                                    |

---

## 🙌 Contributing

Pull requests are welcome! If you find any issues or have suggestions for improvement, feel free to open an issue or submit a PR.

---

## 📧 Contact

Created by **Mehdi Hassan Jony**

📩 Email: [shoyshab@gmail.com](mailto:shoyshab@gmail.com)

🔗 GitHub: [@mehdijony](https://github.com/mehdijony)

---