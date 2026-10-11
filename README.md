# Global Disaster Map - Backend Service

Spring Boot REST API service for the Global Disaster and Human Impact Map platform.

## 🛠 Tech Stack
- **Language**: Java 17+
- **Framework**: Spring Boot 3.3.x (Spring Web, Spring Data JPA, Hibernate)
- **Database**: MySQL 8.x
- **Build Tool**: Apache Maven

## 📋 Prerequisites
- JDK 17 or higher
- Apache Maven 3.8+
- MySQL 8.x server running locally or remotely

## 🚀 Database Setup
1. Create the database and import schema and sample records:
   ```bash
   mysql -u root -p < database/schema.sql
   mysql -u root -p < database/sample-data.sql
   ```

## ⚙️ Configuration & Environment Variables
The application reads configuration from environment variables or `application.properties`:

- `DB_URL`: JDBC URL (default: `jdbc:mysql://localhost:3306/global_disaster_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC`)
- `DB_USERNAME`: Database username (default: `root`)
- `DB_PASSWORD`: Database password

Set the database password before starting:
```powershell
$env:DB_PASSWORD="your_password_here"
```

## 🏃 Running the Application
### Using Maven
```powershell
mvn clean spring-boot:run
```

The API will start at: `http://localhost:8080`

## 🔌 API Endpoints
- `GET /api/disasters` - Fetch disaster records (supports pagination and filtering)
- `GET /api/disasters/markers` - Fetch geospatial markers for map rendering
- `GET /api/disasters/{id}` - Fetch single disaster details
- `POST /api/disasters` - Create a new disaster record
- `PUT /api/disasters/{id}` - Update a disaster record
- `DELETE /api/disasters/{id}` - Delete a disaster record
- `GET /api/analytics/summary` - Aggregate metrics for dashboard KPIs
- `GET /api/analytics/trends` - Trend analysis data for charts
