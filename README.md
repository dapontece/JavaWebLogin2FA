# JavaWebLogin2FA

## Descripción
**JavaWebLogin2FA** es una aplicación web desarrollada en **Java 17** que implementa un sistema de autenticación de usuarios con **login, registro y doble factor de autenticación (2FA)** mediante un código enviado al correo del usuario registrado.  
El proyecto utiliza **SQL Server** como base de datos para almacenar la información de los usuarios.  

Es una aplicación ideal para aprender a integrar seguridad en aplicaciones web Java y trabajar con bases de datos modernas.

---

## Tecnologías
- **Lenguaje:** Java 17
- **Framework:** Java Web Application (Servlets, JSP)
- **Base de datos:** SQL Server
- **IDE recomendado:** NetBeans
- **Control de versiones:** Git / GitHub

---

## Funcionalidades
1. Registro de usuarios con correo y contraseña.
2. Inicio de sesión (Login) seguro.
3. Envío de código de doble autenticación (2FA) al correo registrado.
4. Validación del código para completar el acceso al sistema.

---

## Base de datos

### Script de creación de tabla

```sql
USE [master]
GO

/****** Object:  Table [dbo].[usuario]    Script Date: 25/09/2025 11:10:46 a. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[usuario](
      NOT NULL,
      NOT NULL,
PRIMARY KEY CLUSTERED 
(
    [email_profesor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
