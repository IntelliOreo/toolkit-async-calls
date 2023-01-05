### in terminal:
docker-compose -f <file directory>/docker-compose.yml up -d
docker exec -it x-db-1 psql -U admin \l
CREATE DATABASE notes;

### start the java app

### GET/POST/DELETE
get: localhost:8050/api/db
post: localhost:8050/api/db
delete: localhost:8050/api/db/{id}