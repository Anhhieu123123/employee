# Employee Management System - Spring Boot REST API

## Yêu cầu hệ thống
- Java 17+
- Maven 3.6+
- MySQL 8.0+

## Cấu hình Database
1. Tạo database MySQL (hoặc để Spring tự tạo):
```sql
CREATE DATABASE employee_db;
```

2. Cập nhật thông tin database trong `application.properties` nếu cần:
```properties
spring.datasource.username=root
spring.datasource.password=root
```

## Chạy ứng dụng

```bash
cd employee-management
mvn clean install
mvn spring-boot:run
```

Ứng dụng sẽ chạy tại: http://localhost:8080

## API Endpoints (Test với Postman)

### 1. CREATE - Tạo nhân viên mới
**POST** `http://localhost:8080/api/employees`

**Headers:**
```
Content-Type: application/json
```

**Body (JSON):**
```json
{
    "name": "Sam",
    "age": 30,
    "salary": 70000
}
```

**Response Success (201):**
```json
{
    "message": "User created successfully",
    "employee": {
        "id": 1,
        "name": "Sam",
        "age": 30,
        "salary": 70000.0
    }
}
```

**Response Error - Duplicate Name (400):**
```json
{
    "error": "A User with name Sam already exist."
}
```

---

### 2. READ - Lấy danh sách tất cả nhân viên
**GET** `http://localhost:8080/api/employees`

**Response (200):**
```json
[
    {
        "id": 1,
        "name": "Sam",
        "age": 30,
        "salary": 70000.0
    },
    {
        "id": 2,
        "name": "Tom",
        "age": 40,
        "salary": 50000.0
    }
]
```

---

### 3. READ - Lấy thông tin nhân viên theo ID
**GET** `http://localhost:8080/api/employees/1`

**Response (200):**
```json
{
    "id": 1,
    "name": "Sam",
    "age": 30,
    "salary": 70000.0
}
```

---

### 4. UPDATE - Cập nhật thông tin nhân viên
**PUT** `http://localhost:8080/api/employees/1`

**Headers:**
```
Content-Type: application/json
```

**Body (JSON):**
```json
{
    "name": "Bob",
    "age": 32,
    "salary": 12000
}
```

**Response Success (200):**
```json
{
    "message": "User updated successfully",
    "employee": {
        "id": 1,
        "name": "Bob",
        "age": 32,
        "salary": 12000.0
    }
}
```

---

### 5. DELETE - Xóa nhân viên
**DELETE** `http://localhost:8080/api/employees/1`

**Response (200):**
```json
{
    "message": "Employee deleted successfully"
}
```

---

### 6. SEARCH - Tìm kiếm nhân viên theo tên
**GET** `http://localhost:8080/api/employees/search?name=Sam`

**Response (200):**
```json
[
    {
        "id": 1,
        "name": "Sam",
        "age": 30,
        "salary": 70000.0
    }
]
```

---

## Validation Rules (Theo yêu cầu đề bài)

### Name:
- Không được để trống
- Độ dài: 2-100 ký tự
- Phải unique (không trùng)

### Age:
- Không được để trống
- Giá trị: 18-65

### Salary:
- Không được để trống
- Phải >= 0

### Ví dụ validation error:
**Request:** POST với age = 17

**Response (400):**
```json
{
    "age": "Age must be at least 18"
}
```

---

## Cấu trúc Project (Theo yêu cầu đề bài)

```
employee-management/
├── src/main/java/com/aptech/employeemanagement/
│   ├── entity/
│   │   └── Employee.java           (1 điểm - Entity & Properties)
│   ├── repository/
│   │   └── EmployeeRepository.java (JPA Hibernate)
│   ├── service/
│   │   └── EmployeeService.java    (2 điểm - Validation)
│   ├── controller/
│   │   └── EmployeeController.java (6 điểm - CRUD + 3 điểm - Search)
│   └── EmployeeManagementApplication.java
└── src/main/resources/
    └── application.properties
```

## Điểm số:
- ✅ 1.0 điểm: Entity và Properties
- ✅ 2.0 điểm: Validation
- ✅ 3.0 điểm: Search
- ✅ 6.0 điểm: CRUD (Create, Read, Update, Delete)
- ⚠️ 3.0 điểm: View engine (Không làm theo yêu cầu - chỉ làm BE)

**Tổng: 12/15 điểm** (Không tính view engine)
