# ProyectoTransversal_SGULP

Sistema de Gestión para la Universidad de La Punta (SGULP).

## Tecnologías

- Java
- Java Swing
- JDBC
- MariaDB
- NetBeans

## Estructura del proyecto

El proyecto está organizado en tres paquetes principales:

- `modelo/` → clases que representan las entidades del sistema: `Alumno`, `Materia`, `Cursada` y `Asistencia`.
- `persistencia/` → conexión con la base de datos y clases encargadas del acceso a los datos.
- `vistas/` → interfaces gráficas del sistema.

## Base de datos

El proyecto utiliza una base de datos MariaDB llamada `sgulp`.

El archivo `sgulp.sql` contiene el script necesario para crear la estructura de la base de datos.


## Documentación

El repositorio incluye los siguientes archivos de documentación:

- `DiseñoConceptual_MER.jpg` → modelo entidad-relación.
- `Cardinalidades.jpg` → plantilla de cardinalidades.
- `Restricciones_MR.jpg` → restricciones del modelo relacional.
- `VistaDiseñador.png` → representación visual de las tablas de la base de datos y sus relaciones.


## Estado del proyecto

### Base de datos

- [x] Diseño conceptual y modelo entidad-relación
- [x] Modelo relacional
- [x] Script SQL
- [x] Creación de tablas y relaciones
- [x] Restricciones y claves

### Modelo y persistencia

- [x] Clase `Alumno`
- [ ] Clase `Materia`
- [ ] Clase `Cursada`
- [ ] Clase `Asistencia`
- [x] Conexión JDBC
- [x] `AlumnoData`
- [ ] `MateriaData`
- [ ] `CursadaData`
- [ ] `AsistenciaData`

### Vistas

- [x] `VistaPrincipal`
- [x] Menú principal
- [ ] `VistaAlumnos`
- [ ] `VistaMaterias`
- [ ] `VistaInscripcion`
- [ ] `VistaAsistencia`
- [ ] `VistaConsultas`
- [ ] `VistaCalificacion`

### Funcionalidades

- [x] ABMC de alumnos
- [ ] ABMC de materias
- [ ] Consulta de materias de un alumno
- [ ] Consulta de alumnos de una materia
- [ ] Inscripción a materias
- [ ] Desinscripción de materias
- [ ] Registro de asistencia
- [ ] Registro de calificaciones
