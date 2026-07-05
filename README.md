# 🎬 CRUD de Películas con JavaFX y PostgreSQL

## Integrante

- Fern (Ivory Paulina)

---

# Descripción

Este proyecto consiste en el desarrollo de un sistema CRUD (Crear, Consultar, Actualizar y Eliminar) para la gestión de películas utilizando JavaFX como interfaz gráfica y PostgreSQL como sistema gestor de base de datos.

La aplicación permite registrar películas, consultar la información almacenada, actualizar registros existentes y eliminar registros de la base de datos mediante una interfaz amigable.

---

# Tecnologías utilizadas

- Java 21
- JavaFX
- PostgreSQL
- JDBC
- Maven
- IntelliJ IDEA
- Git y GitHub

---

# Base de datos

Nombre de la base de datos:

```
crud_peliculas
```

Tabla:

```
peliculas
```

Campos:

- id
- titulo
- genero
- director
- duracion
- estreno
- disponible

---

# Funcionalidades

- Login con usuario y contraseña.
- Registrar películas.
- Consultar películas.
- Actualizar películas.
- Eliminar películas.
- Validación de campos.
- Actualización automática del TableView.
- Conexión con PostgreSQL mediante JDBC.

---

# Pasos realizados

## 1. Creación del proyecto

Se creó un proyecto Maven en IntelliJ IDEA utilizando JavaFX y Java 21.

## 2. Configuración de dependencias

Se agregaron las dependencias de:

- JavaFX Controls
- JavaFX FXML
- PostgreSQL JDBC

en el archivo **pom.xml**.

## 3. Creación de la base de datos

Se creó la base de datos:

```
crud_peliculas
```

Posteriormente se creó la tabla **peliculas** mediante un script SQL.

## 4. Configuración de la conexión

Se desarrolló la clase **Conexion.java**, la cual establece la conexión con PostgreSQL utilizando JDBC.

## 5. Desarrollo del CRUD

Se implementaron las siguientes operaciones:

- CREATE
- READ
- UPDATE
- DELETE

utilizando PreparedStatement y ResultSet.

## 6. Diseño de la interfaz

Se desarrolló la interfaz gráfica con JavaFX utilizando:

- TextField
- Label
- Button
- ComboBox
- CheckBox
- DatePicker
- TableView

además de estilos personalizados mediante CSS.

## 7. Validaciones

Se implementaron validaciones para:

- Campos obligatorios.
- Longitud mínima del título.
- Duración numérica.
- Selección obligatoria de género.
- Fecha obligatoria.
- Mensajes mediante Alert.

## 8. Generación del ejecutable

Se generó el ejecutable de la aplicación para su distribución.

## 9. Publicación

El proyecto fue publicado en GitHub junto con el código fuente y la documentación.

---

# Credenciales del Login

Usuario:

```
admin
```

Contraseña:

```
1234
```

---

# Estructura del proyecto

```
src
│
├── controller
├── dao
├── db
├── model
│
resources
│
├── login.fxml
├── peliculas.fxml
└── style.css
```

---

# Ejecución

1. Clonar el repositorio.

2. Abrir el proyecto en IntelliJ IDEA.

3. Crear la base de datos en PostgreSQL.

4. Ejecutar el script SQL.

5. Configurar el usuario y contraseña en:

```
Conexion.java
```

6. Ejecutar el proyecto.

---

# Autor

Ivory Paulina Cando

Escuela Politécnica Nacional

Desarrollo de Software
