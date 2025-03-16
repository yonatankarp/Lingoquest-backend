# LingoQuest

LingoQuest is a language-learning backend service that generates AI-based
quizzes to help users improve their language skills. The application follows a
Hexagonal Architecture and is built using Kotlin and Spring Boot.

---

## 🚀 Features

- AI-generated quizzes with multiple question types:
  - Single correct answer
  - Multiple correct answers
  - Complete the sentence
  - Match pairs and rearrange words
- Supports tracking user progress
- RESTful API to retrieve and complete quizzes 
- Docker-based setup for easy deployment 
- Domain-Driven Design (DDD) and Hexagonal Architecture for clean separation of concerns

---

## 🏗️ Project Structure

```text
lingoquest-backend/
├── src/                    # Source code
├── build.gradle.kts        # Gradle build file (Kotlin DSL)
├── settings.gradle.kts     # Gradle settings
├── docker-compose.yaml     # Docker Compose setup
├── gradle/                 # Gradle wrapper
├── .gitignore              # Git ignore rules
└── README.md               # Project documentation
```
---

## 🛠️ Setup and Installation

1. Clone the Repository

```shell
   git clone https://github.com/yonatankarp/lingoquest-backend.git
   cd lingoquest-backend
```

2. Start Dependencies Using Docker Compose
   Make sure Docker is installed and running, then start the required services:

```shell
  docker compose up -d
```

3. Build and Run the Project
   Build and start the application using Gradle:

```shell
  ./gradlew bootRun
```
---

## 🌐 API Endpoints

To see the endpoint collection, go to [collection.http](collection.http)

---

## 🧪 Testing

Run tests using:

```shell
  ./gradlew test
```
---

## 🔥 Tech Stack

- Kotlin – Main programming language
- Spring Boot – Backend framework
- Docker – Containerization
- Gradle – Build tool
- PostgreSQL – Database
