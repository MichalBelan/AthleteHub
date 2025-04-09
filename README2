# 🏋️ AthleteHub – REST API v Spring Boot

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring--Boot-3.4.4-brightgreen)
![License](https://img.shields.io/badge/license-MIT-lightgrey)
![Status](https://img.shields.io/badge/stav-Vo%20vývoji-yellow)

> Backendová aplikácia pre správu používateľov, zabezpečená cez JWT tokeny, postavená na Java + Spring ekosystéme.

---

## 🔧 Použité technológie

- **Java 21**
- **Spring Boot 3.4.4**
- **Spring Security (JWT + OAuth2 Resource Server)**
- **Spring Data JPA + Hibernate**
- **MapStruct** – pre mapovanie medzi `Entity` a `DTO`
- **PostgreSQL**
- **XML ORM mapping** (`orm.xml`)
- **SpringDoc OpenAPI + Swagger UI**

---

## 🚀 Spustenie projektu

1. Spusti PostgreSQL databázu:
   ```
   URL: jdbc:postgresql://localhost:5432/athletehub
   Používateľ: admin
   Heslo: admin
   ```

2. Spusti aplikáciu:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. Swagger dokumentácia:
   [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 📬 REST API – dostupné endpointy

| Metóda | Endpoint            | Popis                               | Prístup   |
|--------|---------------------|-------------------------------------|------------|
| POST   | `/api/users`        | Vytvorenie používateľa              | Verejný   |
| POST   | `/api/auth/login`   | Login, vráti JWT token              | Verejný   |
| GET    | `/api/users/me`     | Info o prihlásenom používateľovi   | Chránený  |

---

## 🔐 Zabezpečenie

- JWT token (HS256, tajný kľúč sa nachádza v `application.yml`)

- Chránené endpointy vyžadujú platný token v hlavičke:

  ```http
  Authorization: Bearer <token>
  ```

- Verejné endpointy:
  - `/api/users`
  - `/api/auth/**`
  - `/swagger-ui/**`

---

## 🛠️ Architektúra projektu

Projekt je modulárne rozdelený podľa čistého DDD (čisté doménové navrhovanie):

```
src/
├── controller/         → REST API
├── dto/                → Prenosové objekty (DTO)
├── mapper/             → MapStruct konverzia (DTO ↔ Entity)
├── ports/              → Interface pre doménové repozitáre
├── security/           → JWT, autentifikácia, userdetails
├── domain/             → Entity + business logika
├── repository-jpa/     → JPA implementácia repozitárov
```

---

## ✅ Hotové funkcionality

- [x] Registrácia používateľa
- [x] Login + JWT generovanie
- [x] Zabezpečené endpointy
- [x] Swagger UI dokumentácia
- [x] Perzistencia cez JPA
- [x] XML ORM mapping (`orm.xml`)
- [x] Oddelená architektúra (domain vs infra)

---





