# Crm

* [Endpoints](#endpoints)
* [Quick start](#quick-start)

Simple crm system

## Technologies
Spring(Boot, JPA), Swagger, Docker, PostgreSQL, Liquibase

## Features

### Clients
  * Get all clients via GET `/api/clients`  
  * Get client by ID via GET `/api/clients/{clientId}`  
  * Get all client contacts by ID via GET `/api/clients/{clientId}/contacts`  
  * Get client contacts by ID and type via GET `/api/clients/{clientId}/contacts/{type}`  
  * Add a new client via POST `/api/clients`  

### Contacts
  * Add a contact to a client via POST `/api/clients/{clientId}/contacts`  

## Endpoints
  * Swagger doc: http://localhost:8080/swagger-ui/index.html

## Environments

To run this CRM application, you need to create or fill a `.env` file in the root directory with the following environment variables:

- `POSTGRES_USERNAME` - the username for accessing the PostgreSQL database (default: `root`).
- `POSTGRES_PASSWORD` - the password for accessing the PostgreSQL database (default: `root`).
- `POSTGRES_DATABASE` - the name of the PostgreSQL database used by the application (default: `userdb`).
- `POSTGRES_PORT` - the port number for the PostgreSQL service (default: `5432`).
- `POSTGRES_HOST` - the hostname or IP address of the PostgreSQL service (default: `userdb`).
- `APP_PORT` - the port number on which the application will run (default: `8080`).

## Quick start
1. Clone this repo into folder.

```Bash
git clone https://github.com/qReolq/crm.git
cd crm
```
2. Start docker compose

```Bash
docker compose up
```
3. Go to http://localhost:8080/swagger-ui/index.html
