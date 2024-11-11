Product Finder
# Product Finder
Es una aplicación de Java Spring Boot diseñada para buscar y gestionar precios de productos. Utiliza Gradle como herramienta de construcción y sigue una arquitectura hexagonal, que separa las capas de dominio, aplicación e infraestructura.

# Requisitos:
Java 11 o superior
Gradle 6.8 o superior (incluido en este proyecto mediante el Gradle Wrapper)

# Instalación:
Clona este repositorio y navega hasta el directorio del proyecto:
```
git clone https://github.com/SalvadorPalmaRodriguez/product-finder.git
cd product-finder
```
# Construir:
Luego, construye el proyecto con Gradle:

```
./gradlew build
```

# Ejecutar:
Para ejecutar la aplicación, utiliza el comando:

```
./gradlew bootRun
```

### La aplicación estará disponible en http://localhost:8080.


Una vez iniciada, puedes acceder a los endpoints de la API para buscar y gestionar precios de productos. Aquí hay un ejemplo de cómo hacer una petición de búsqueda de precios:

```
curl -X GET "http://localhost:8080/api/prices/price?brandId=1&productId=35455&applicationDate=2020-06-14T10:00:00"
```
```
curl -X GET "http://localhost:8080/api/prices/price?brandId=1&productId=1&applicationDate=2023-11-05T14:00:00"
```

# Estructura
La estructura básica del proyecto es la siguiente:
```
product-finder/
├── src/                      # Código fuente
│   ├── main/                 
│   │   └── java/com/hexagonal/product_finder/   # Código Java organizado en capas hexagonales
│   │       ├── application/                     # Casos de uso y lógica de aplicación
│   │       ├── domain/                          # Modelos de dominio
│   │       ├── exception/                       # Excepciones
│   │       └── infrastructure/                  # Controladores y adaptadores de 
│   │
│   └── test/                                    # Pruebas
├── build.gradle              # Configuración de Gradle
├── settings.gradle           # Configuración de Gradle
├── gradlew                   # Wrapper de Gradle para UNIX
├── gradlew.bat               # Wrapper de Gradle para Windows
└── README.md                 # Documentación del proyecto
```


Modifica el archivo src/main/resources/application.properties para cambiar la configuración de la base de datos u otros parámetros de la aplicación.

# Test
Ejecuta las pruebas unitarias con el siguiente comando:
```
./gradlew test
```
# Generar .jar
Para generar un archivo .jar
```
./gradlew build
java -jar build/libs/product-finder.jar
```
