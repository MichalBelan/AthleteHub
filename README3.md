# 🏋️ AthleteHub – Frontend

**AthleteHub** je moderná webová aplikácia pre správu atletických profilov, výkonov a registrácie, postavená na Angulari. Frontend komunikuje s backendom v Spring Boot a využíva Keycloak na OAuth2 autentifikáciu.

---

## 🚀 Funkcie

- 🔐 Prihlásenie cez Keycloak (OAuth2 Authorization Code Flow)
- 👤 Zobrazenie profilu prihláseného používateľa
- ✍️ Registrácia nového používateľa
- ⚙️ REST API integrácia (Spring Boot backend)
  

---

## 🧰 Použité technológie

- [Angular](https://angular.io/) 17+
- [RxJS](https://rxjs.dev/)
- [TypeScript](https://www.typescriptlang.org/)
- [SCSS](https://sass-lang.com/)
- [Keycloak](https://www.keycloak.org/) – OAuth2/SSO
- [Angular CLI](https://angular.io/cli)

---
## Štruktúra priečinkov
src/
├── app/
│   ├── core/            # Služby, interceptory, konfigurácia
│   ├── features/        # Funkčné celky (napr. auth, dashboard, profile)
│   ├── shared/          # Reusable komponenty, pipes, directívy
│   ├── app.routes.ts    # Routing
│   └── app.config.ts    # Konfigurácia appky
├── assets/              # Obrázky, lokalizácie, statika
├── environments/        # environment.ts a .development.ts




## Klonovanie projektu (ak ešte nemáš):
git clone https://github.com/MichalBelan/AthleteHub.git
cd frontendAngular/athlete-hub-frontend

# Inštalácia balíčkov
npm install

# Spustenie vývojového servera
ng serve

## ⚙️ Konfigurácia

### environment.ts
Nastavuje backend API a OAuth2 údaje:
```ts
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api',
  oauth2: {
    issuer: 'http://localhost:8081/realms/FSA',
    clientId: 'athletehub-frontend'
  }
};



