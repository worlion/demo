# Spring Boot Code Challenge - Items API

---
👤 Autor: Imanol Conde  
📅 Fecha: Junio 2025  
📁 Entrega para: Prueba técnica backend – Ibercaja
---
Este proyecto es una aplicación backend construida con Spring Boot que expone una API REST para gestionar entidades `Item`.

## 📘 Descripción

Permite:
- Crear ítems (`POST /items`)
- Listar todos los ítems (`GET /items`)

Cada ítem tiene los siguientes campos:
- `id`: autogenerado
- `title`: texto no vacío
- `active`: booleano

## 🧰 Requisitos

- Java 21 o superior
- Maven 3.8+
- IDE recomendado: IntelliJ IDEA o VSCode

## 🚀 Cómo ejecutar

```bash
mvn spring-boot:run

```

La aplicación estará disponible en:
http://localhost:8080

## 🛠️ Endpoints disponibles
### `GET /items`
Obtiene todos los ítems existentes.

**Ejemplo de respuesta:**

```json
[
    {
        "id": 1,
        "title": "Primer Item",
        "active": true
    },
    {
        "id": 2,
        "title": "Segundo Item",
        "active": false
    }
]
```
### `GET /items/{id}`
Obtiene un ítem.

**Ejemplo de respuesta:**

```json

{
    "id": 1,
    "title": "Primer Item",
    "active": true
}
```
**Respuestas posibles:**

- `200 OK`: ítem encontrado
- `404 Not Found`: no existe un ítem con ese ID

### `POST /items`
Crea un nuevo ítem.

**Request JSON:**
```json
{
    "title": "Nuevo ítem",
    "active": true
}
```

**Respuestas posibles:**

- `201 Created`: ítem creado con éxito
- `400 Bad Request`: error de validación (ej: título vacío)

### `PUT /items/{id}`
Actualiza un ítem existente.

**Request JSON:**
```json
{
  "title": "Ítem actualizado",
  "active": false
}
```

**Respuestas posibles:**

- `200 OK`: ítem actualizado
- `400 Bad Request`: error de validación (ej: título vacío)
- `404 Not Found`: no existe un ítem con ese ID

### `DELETE /items/{id}`
Elimina un ítem existente.

**Respuestas posibles:**
- `204 No Content`: ítem eliminado con éxito
- `404 Not Found`: no existe un ítem con ese ID

## 📄 Documentación de la API (Swagger UI)

La API está documentada automáticamente usando OpenAPI/Swagger.

Una vez ejecutada la aplicación, puedes acceder a la documentación interactiva en:

👉 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Desde allí puedes probar los endpoints (`GET`, `POST`, `PUT`, `DELETE`) directamente desde el navegador.


## 🧪 Pruebas
Puedes probar la API usando herramientas como Postman o cURL.

Junto al código del proyecto se incluye una colección Postman (items-api.postman_collection.json) con ejemplos de uso para todos los endpoints.

---

*© Código creado únicamente para fines del proceso de selección.*


