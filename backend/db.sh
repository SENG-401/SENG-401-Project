#!/bin/bash

# Variables
DB_NAME="mydatabase"
DB_USER="myuser"
DB_PASS="mypassword"

# Create a new PostgreSQL database
echo "Creating database: $TUTORING_DB"
psql -U postgres -c "CREATE DATABASE $DB_NAME;"

# Create a new user and grant privileges
echo "Creating user: $DB_USER"
psql -U postgres -c "CREATE USER $DB_USER WITH ENCRYPTED PASSWORD '$DB_PASS';"
psql -U postgres -c "GRANT ALL PRIVILEGES ON DATABASE $DB_NAME TO $DB_USER;"

# Connect to the database and create a table
echo "Creating table 'users' in database: $DB_NAME"
psql -U $DB_USER -d $DB_NAME -c "CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(100) UNIQUE NOT NULL,
    displayName VARCHAR(100) UNIQUE NOT NULL,
    userName VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    isTutor BOOL NOT NULL,
    isStudent BOOL NOT NULL
);"

echo "Creating table students' in database: $DB_NAME"
psql -U $DB_USER -d $DB_NAME -c "CREATE TABLE IF NOT EXISTS students (
    studentId SERIAL PRIMARY KEY,
    whatHelp TEXT[] NOT NULL,
    FOREIGN KEY (studentId) REFERENCES users(id) ON DELETE CASCADE
);"

echo "Creating table tutors' in database: $DB_NAME"
psql -U $DB_USER -d $DB_NAME -c "CREATE TABLE IF NOT EXISTS tutors (
    tutorId SERIAL PRIMARY KEY,
    ableToTeach TEXT[] NOT NULL,
    socialMedia TEXT[],
    userRating 	FLOAT8 NOT NULL,
    bio VARCHAR(5000) NOT NULL,
    trainingMetric 	FLOAT8 NOT NULL,
    FOREIGN KEY (tutorId) REFERENCES users(id) ON DELETE CASCADE
);"


echo "Creating table reviews' in database: $DB_NAME"
psql -U $DB_USER -d $DB_NAME -c "CREATE TABLE IF NOT EXISTS reviews (
    reviewId SERIAL PRIMARY KEY,
    tutorId SERIAL NOT NULL,
    score FLOAT8 NOT NULL,
    subject VARCHAR(20) NOT NULL,
    comment VARCHAR(5000) NOT NULL,
    FOREIGN KEY (tutorId) REFERENCES tutors(tutorId) ON DELETE CASCADE
);"

echo "Database and table setup complete."
