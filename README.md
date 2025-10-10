# Lulo Test Automation Reto Técnico
Este repositorio centraliza los dos proyectos de automatización desarrollados para la prueba técnica de **Lulo**.  Cada módulo es independiente y puede ejecutarse por separado, manteniendo sus propias dependencias y configuración de Gradle.

## 🧩 Estructura del repositorio
```bash
lulo/
│
├── api-tests/       
│   ├── src/
│   ├── .gitignore
│   ├── build.gradle
│   ├── gradlew
│   ├── gradlew.bat
│   ├── post_response.txt
│   ├── response.txt
│   └── settings.gradle
│
├── ui-tests/        
│   ├── src/
│   ├── target/
│   ├── build.gradle
│   ├── gradlew
│   ├── gradlew.bat
│   ├── settings.gradle
│   └── .gitignore
│
└── README.md
```
## Tecnologías

- **Java 17+**
- **Gradle**
- **Serenity BDD**
- **Selenium WebDriver**
- **JUnit / Cucumber (según el módulo)**
- **REST Assured** (en el módulo de API si aplica)

## 🚀 Ejecución

Cada módulo puede ejecutarse de forma independiente:

### Ejecutar pruebas de API
```bash
cd api-tests
./gradlew clean test
```

### Ejecutar pruebas UI
```bash
cd ui-tests
./gradlew clean test
```

Los reportes generados por Serenity estarán disponibles en:
target/site/serenity/index.html

