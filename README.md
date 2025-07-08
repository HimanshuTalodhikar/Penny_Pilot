# Penny Pilot 💡🤖

I was working on a Java project and thought of adding AI features into it — but most AI tools and libraries are based in Python, which I wasn't very comfortable with. That’s when I discovered [Spring AI](https://docs.spring.io/spring-ai/reference/) — a powerful way to integrate AI into Spring Boot applications using Java!

This project, **Penny Pilot**, is a demo designed to explore and test the capabilities of Spring AI.

---

## 🚀 What It Does

- Integrates AI capabilities into a Java Spring Boot project
- Uses **Spring AI** to interact with large language models
- Demonstrates how you can embed AI-driven logic using **Java only**, no Python needed

> This is a **demo project** built to experiment with AI integration in Spring Boot — not meant for production use yet.

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring AI**
- **Ollama (local LLMs)**
- **PostgreSQL + pgvector**
- **Docker** for containerization

---

## ⚙️ Setup Instructions

### 1. Clone the repo

```bash
git clone https://github.com/HimanshuTalodhikar/Penny_Pilot.git
cd Penny_Pilot



Folder Structure 

src/
├── main/
│   ├── java/com/example/pennypilot/
│   │   ├── controller/
│   │   ├── service/
│   │   └── config/
│   └── resources/
│       └── application.yml
docker-compose.yml
README.md
