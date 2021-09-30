# Authorization server with Keycloak

## Locally with docker

- https://www.keycloak.org/getting-started/getting-started-docker

Run keycloak locally with in memory database and expose it to port 8081
```
docker run -p 8081:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin quay.io/keycloak/keycloak:11.0.1
```

This will start Keycloak exposed on the local port 8081. It will also create an initial admin user with username `admin` and password `admin`.

## Todo

- create a realm
- create a user
- create a client (allow client registration) for the client
