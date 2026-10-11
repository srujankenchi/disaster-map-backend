-- Global Disaster and Human Impact Map
-- Database Schema Definition for MySQL 8.x
-- Database: global_disaster_db

CREATE DATABASE IF NOT EXISTS global_disaster_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE global_disaster_db;

-- Drop table if it already exists for fresh schema initialization
DROP TABLE IF EXISTS disasters;

CREATE TABLE disasters (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    disaster_name VARCHAR(200) NOT NULL,
    disaster_type VARCHAR(50) NOT NULL,
    country VARCHAR(100) NOT NULL,
    location VARCHAR(200),
    latitude DECIMAL(10, 7),
    longitude DECIMAL(10, 7),
    occurrence_date DATE NOT NULL,
    severity VARCHAR(30),
    description TEXT,
    fatalities BIGINT DEFAULT 0,
    injuries BIGINT DEFAULT 0,
    affected_population BIGINT DEFAULT 0,
    displaced_population BIGINT DEFAULT 0,
    economic_damage DECIMAL(18, 2) DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    -- Constraints
    CONSTRAINT chk_fatalities CHECK (fatalities >= 0),
    CONSTRAINT chk_injuries CHECK (injuries >= 0),
    CONSTRAINT chk_affected_population CHECK (affected_population >= 0),
    CONSTRAINT chk_displaced_population CHECK (displaced_population >= 0),
    CONSTRAINT chk_economic_damage CHECK (economic_damage >= 0),
    CONSTRAINT chk_latitude CHECK (latitude IS NULL OR (latitude >= -90.0 AND latitude <= 90.0)),
    CONSTRAINT chk_longitude CHECK (longitude IS NULL OR (longitude >= -180.0 AND longitude <= 180.0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Performance Indexes
CREATE INDEX idx_disaster_country ON disasters(country);
CREATE INDEX idx_disaster_type ON disasters(disaster_type);
CREATE INDEX idx_disaster_date ON disasters(occurrence_date);
CREATE INDEX idx_disaster_severity ON disasters(severity);
CREATE INDEX idx_disaster_name ON disasters(disaster_name);
