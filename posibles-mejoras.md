# 💡Posibles mejoras 

---
👤 Autor: Imanol Conde  
📅 Fecha: Junio 2025  
📁 Entrega para: Prueba técnica backend – Ibercaja
---
Estas son algunas cosas que podría añadir o mejorar si tuviera más tiempo:

- ### **Separar DTOs de las entidades** 🧱
  Ahora mismo la API expone directamente la entidad `Item`. Lo ideal sería usar DTOs para evitar acoplar la capa de persistencia con la de exposición.

- ### *Base de datos real**🗄️
  En vez de usar H2 (solo útil para pruebas), se podría conectar a una base de datos como (Oracle, MySql, PostgreSQL...).

- ### **CI/CD** ⚙️
  Montar una pipeline sencilla con GitHub Actions o similar para compilar y ejecutar tests automáticamente.

- ### **Documentación más completa** 📚
  Se podría añadir una guía rápida de uso con ejemplos paso a paso para quienes no usen Postman.

