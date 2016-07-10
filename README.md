# Subí que te llevo - backend

[![Build Status](https://travis-ci.org/DesarrolloDeAplicaciones-GrupoA/backend.svg?branch=master)](https://travis-ci.org/DesarrolloDeAplicaciones-GrupoA/backend)

[![Codacy Badge](https://api.codacy.com/project/badge/grade/2709341668804273a8cdc71cee06e1c5)](https://www.codacy.com/app/DesarrolloDeAplicaciones-GrupoA/backend)

[![Codacy Badge](https://api.codacy.com/project/badge/coverage/2709341668804273a8cdc71cee06e1c5)](https://www.codacy.com/app/DesarrolloDeAplicaciones-GrupoA/backend)

## Introduccion:

Proyecto de la materia "Desarrollo de aplicaciones" de la carrera "Tecnicatura en programacion informatica" de la Universidad de Quilmes, Argentina.


## Overview

Plataforma donde los usuarios pueden coordinarse para compartir viajes en auto o cualquier otro vehículo que permita llevar al menos 2 personas.

Ver [Vision](./docs/documento_vision.pdf).

Ver [Proyecto frontend](https://github.com/DesarrolloDeAplicaciones-GrupoA/frontend).

## Profesores:

* Cristian López
* Juan Delpino

## Equipo

+ Damián Lattenero
+ Pablo Loiacono
+ Leandro Gomez

## Roadmap:

### Sprint 1:

* Core
    * [x] Configuracion de travis
    * [x] Estado del Build en verde
    * [x] Coverage al 90%
    * [x] Diagrama UML (en <Proyecto>/docs)
    * [x] 3 mockups de las ventanas de la aplicacion - Home, buscar recorridos y alta de usuario.
    * [x] Pantalla prototipo del uso de la API de gmaps (mostrar recorrido, crear un recorrido)
* Modelo
    * [x] Modelo de objetos completo e implementado
    * [x] Clean code segun materia (todo en ingles)
* Testing
    * [x] Testing segun las pautas de la materia

### Sprint 2:
* Core
    * [x] Deploy/Run por consola
    * [x] Estado del Build en verde
    * [x] Utiliza HSQLDB
    * [ ] Datos "fake" para probar la aplicación
    * [x] Auditoria de servicios. Loguear <timestamp,user,operación/metodo, parámetros> de los servicios publicados con Spring en un archivo AUDIT.LOG
    * [x] Posibilidad de elegir lenguaje =I18n- US_ES
* Funcionalidad
    * [x] Home
    * [x] Solicitar subirse a un recorrido
    * [x] Gaming: ABM de Productos
    * [x] Registrar usuarios en la red
    * [x] Agregar vehiculo
    * [ ] Agregar recorrido

### Sprint 3:
* Core
    * [ ] Formatear las fechas, $ (moneda) y # (numero) segun locale
    * [ ] Tablas paginadas
    * [ ] Responsive web design
    * [x] Crear un test de arquitectura
    * [ ] Error handler desde servicios. Loguar en Error.log las excepciones no manejadas de los servicios
          Utilizar log4j para loguearlo a un archivo separado.
    * [x] Autenticar la aplicacion con Googl
* Funcionalidad
    * [ ] Buscar usuarios que realice recorridos similares.
    * [ ] Aceptar solicitud de viaje
    * [ ] Calificar a un compañero de viaje
    * [ ] Enviar un mensaje de manera publica y privada
