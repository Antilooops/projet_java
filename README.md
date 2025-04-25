# Java PVZ project

## Introduction

This a Java backend for a Plant Vs Zombie game frontend. It mainly manipulates three objects such as maps, plants and zombies using the available routes detailed below.

## Requirements

To use the backend, please check that you have the following requirements :

- Java21
- Maven
- Tomcat10
- MariaDB
  (<u>J'utilise Archlinux qui n'a pas MySQL dans son package manager. Je dois donc utiliser MariaDB qui est l'alternative que la distro propose. Voir: https://wiki.archlinux.org/title/MariaDB</u>)

## Technologies

Every dependencies can be found in the `pom.xml` file.

- Springframework
- MariaDB
- Jakarta
- Jackson

## API routes

### Plantes

- `GET /plantes`
- `GET /plantes/{id}`
- `POST /plantes`
- `PUT /plantes/{id}`
- `DELETE /plantes/{id}`

### Zombies

- `GET /zombies`
- `GET /zombies/{id}`
- `POST /zombies`
- `PUT /zombies/{id}`
- `DELETE /zombies/{id}`

### Maps

- `GET /maps`
- `GET /maps/{id}`
- `POST /maps`
- `PUT /maps/{id}`
- `DELETE /maps/{id}`
