# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Spring Boot REST API for a blackjack game. The project uses Maven for build management and follows a standard Spring Boot layered architecture.

**Technology Stack:**

- Java 17
- Spring Boot 3.5.9
- Spring Web (REST API)
- Spring DevTools (hot reload during development)
- Maven (build tool)

## Persona and Code Standards

This project serves as a reintroduction to Spring Boot and Java development. When working in this codebase:

**Educational Approach:**

- Explain Spring Boot concepts and annotations when implementing features (e.g., `@RestController`, `@Service`, dependency injection)
- Provide context for design decisions and why certain patterns are used
- Explain Java best practices as they're applied in the code
- Include educational comments in responses about Spring Boot conventions and idioms

**Code Standards:**

- Follow Spring Boot best practices and conventions
- Use proper dependency injection with constructor injection (preferred over field injection)
- Apply appropriate Spring annotations (`@RestController`, `@Service`, `@Component`, etc.)
- Follow RESTful API design principles for endpoints
- Use Java naming conventions (camelCase for methods/variables, PascalCase for classes)
- Leverage Spring Boot's auto-configuration and features rather than manual configuration
- Write clean, readable code with meaningful variable and method names
- Include appropriate exception handling with Spring's `@ExceptionHandler` or `@ControllerAdvice`

When implementing new features, take time to explain the "why" behind the approach, not just the "what."

## Architecture

The project follows a standard Spring Boot three-layer architecture:

1. **Controller Layer** (`com.richardchan.blackjack.controller`) - REST endpoints that handle HTTP requests
2. **Service Layer** (`com.richardchan.blackjack.service`) - Business logic and game management
3. **Model Layer** (`com.richardchan.blackjack.model`) - Domain entities representing game state

**Key Design:**

- `GameService` maintains an in-memory map of games (no database persistence)
- Controllers expose REST endpoints under `/games`
- Application entry point: `BlackjackApplication.java`

## Development Commands

**Build the project:**

```bash
./mvnw clean install
```

**Run the application:**

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080` by default.

**Run tests:**

```bash
./mvnw test
```

**Run a single test class:**

```bash
./mvnw test -Dtest=BlackjackApplicationTests
```

**Package the application:**

```bash
./mvnw package
```

This creates an executable JAR in `target/blackjack-0.0.1-SNAPSHOT.jar`

## Configuration

Application configuration is in `src/main/resources/application.properties`. Currently only defines the application name.
