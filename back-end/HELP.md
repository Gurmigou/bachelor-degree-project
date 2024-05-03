# Getting Started

### MongoDB using Docker
`docker run --name mongodb-degree-project -d -p 27017:27017 \
-e MONGO_INITDB_ROOT_USERNAME=mongo \
-e MONGO_INITDB_ROOT_PASSWORD=root \
-e MONGO_INITDB_DATABASE=diploma
mongo:latest
`