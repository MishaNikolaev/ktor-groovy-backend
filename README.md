# ktor-groovy-backend

This project was created using the [Ktor Project Generator](https://start.ktor.io).

Here are some useful links to get you started:

- [Ktor Documentation](https://ktor.io/docs/home.html)
- [Ktor GitHub page](https://github.com/ktorio/ktor)
- The [Ktor Slack chat](https://app.slack.com/client/T09229ZC6/C0A974TJ9). You'll need
  to [request an invite](https://surveys.jetbrains.com/s3/kotlin-slack-sign-up) to join.

## Features

Here's a list of features included in this project:

| Name                                                                      | Description                                                                        |
| ---------------------------------------------------------------------------|------------------------------------------------------------------------------------ |
| [Routing](https://start.ktor.io/p/routing)                                | Provides a structured routing DSL                                                  |
| [Authentication](https://start.ktor.io/p/auth)                            | Provides extension point for handling the Authorization header                     |
| [Authentication JWT](https://start.ktor.io/p/auth-jwt)                    | Handles JSON Web Token (JWT) bearer authentication scheme                          |
| [Authentication OAuth](https://start.ktor.io/p/auth-oauth)                | Handles OAuth Bearer authentication scheme                                         |
| [Firebase authentication](https://start.ktor.io/p/firebase-auth-provider) | Handles Firebase bearer authentication                                             |
| [Content Negotiation](https://start.ktor.io/p/content-negotiation)        | Provides automatic content conversion according to Content-Type and Accept headers |
| [kotlinx.serialization](https://start.ktor.io/p/kotlinx-serialization)    | Handles JSON serialization using kotlinx.serialization library                     |
| [Sessions](https://start.ktor.io/p/ktor-sessions)                         | Adds support for persistent sessions through cookies or headers                    |
| [Resources](https://start.ktor.io/p/resources)                            | Provides type-safe routing                                                         |
| [Server-Sent Events (SSE)](https://start.ktor.io/p/sse)                   | Support for server push events                                                     |
| [Status Pages](https://start.ktor.io/p/status-pages)                      | Provides exception handling for routes                                             |
| [OpenAPI](https://start.ktor.io/p/openapi)                                | Serves OpenAPI documentation                                                       |
| [Simple Cache](https://start.ktor.io/p/simple-cache)                      | Provides API for cache management                                                  |
| [Simple Memory Cache](https://start.ktor.io/p/simple-memory-cache)        | Provides memory cache for Simple Cache plugin                                      |
| [Call Logging](https://start.ktor.io/p/call-logging)                      | Logs client requests                                                               |
| [GSON](https://start.ktor.io/p/ktor-gson)                                 | Handles JSON serialization using GSON library                                      |
| [Jackson](https://start.ktor.io/p/ktor-jackson)                           | Handles JSON serialization using Jackson library                                   |
| [Exposed](https://start.ktor.io/p/exposed)                                | Adds Exposed database to your application                                          |
| [MongoDB](https://start.ktor.io/p/mongodb)                                | Adds MongoDB database to your application                                          |
| [Postgres](https://start.ktor.io/p/postgres)                              | Adds Postgres database to your application                                         |
| [Koin](https://start.ktor.io/p/koin)                                      | Provides dependency injection                                                      |
| [WebSockets](https://start.ktor.io/p/ktor-websockets)                     | Adds WebSocket protocol support for bidirectional client connections               |

## Building & Running

To build or run the project, use one of the following tasks:

| Task                          | Description                                                          |
| -------------------------------|---------------------------------------------------------------------- |
| `./gradlew test`              | Run the tests                                                        |
| `./gradlew build`             | Build everything                                                     |
| `buildFatJar`                 | Build an executable JAR of the server with all dependencies included |
| `buildImage`                  | Build the docker image to use with the fat JAR                       |
| `publishImageToLocalRegistry` | Publish the docker image locally                                     |
| `run`                         | Run the server                                                       |
| `runDocker`                   | Run using the local docker image                                     |

If the server starts successfully, you'll see the following output:

```
2024-12-04 14:32:45.584 [main] INFO  Application - Application started in 0.303 seconds.
2024-12-04 14:32:45.682 [main] INFO  Application - Responding at http://0.0.0.0:8080
```

