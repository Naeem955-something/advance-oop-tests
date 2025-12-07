# How to Run the Application

## Prerequisites
- Java 17+ (installed ✓)
- Maven 3.9+ (installed ✓)
- Node.js and npm (installed ✓)

---

## 🚀 Running the Backend (Spring Boot)

### Option 1: Using Maven (Recommended)
```bash
cd /workspaces/advance-oop-tests/backend
mvn clean spring-boot:run
```

The backend will start on **http://localhost:8080**

### Key Endpoints:
- **GET** `/student/getAll` - Get all students
- **GET** `/student/{id}` - Get student by ID
- **POST** `/student/add` - Create new student
- **PUT** `/student/{id}` - Update entire student
- **PATCH** `/student/{id}` - Partially update student
- **DELETE** `/student/{id}` - Delete student

---

## 🎨 Running the Frontend (React)

### Step 1: Install Dependencies
```bash
cd /workspaces/advance-oop-tests/frontend
npm install
```

### Step 2: Start Development Server
```bash
npm start
```

The frontend will start on **http://localhost:3000**

---

## 📋 Running Both Simultaneously

### Terminal 1 - Backend
```bash
cd /workspaces/advance-oop-tests/backend
mvn clean spring-boot:run
```

### Terminal 2 - Frontend
```bash
cd /workspaces/advance-oop-tests/frontend
npm install  # Only needed first time
npm start
```

Your application will be fully functional with:
- Frontend running on http://localhost:3000
- Backend API running on http://localhost:8080

---

## ✅ Verification

1. **Backend is running:** Visit http://localhost:8080/student/getAll (should return `[]` or existing students)
2. **Frontend is running:** Visit http://localhost:3000 (should show Student CRUD interface)
3. **Connection is working:** Create a student in the UI, it should appear in the list

---

## 📝 API Testing

Use `curl` or Postman to test endpoints:

```bash
# Get all students
curl http://localhost:8080/student/getAll

# Create a student
curl -X POST http://localhost:8080/student/add \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","email":"john@example.com"}'

# Get student by ID
curl http://localhost:8080/student/1

# Update student
curl -X PUT http://localhost:8080/student/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Jane Doe","email":"jane@example.com"}'

# Delete student
curl -X DELETE http://localhost:8080/student/1
```

