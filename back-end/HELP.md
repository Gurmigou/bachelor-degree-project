# Getting Started

### MongoDB using Docker
`docker run --name mongodb -d -p 27017:27017 \
-e MONGO_INITDB_ROOT_USERNAME=mongo \
-e MONGO_INITDB_ROOT_PASSWORD=change_password \
mongo:latest
`