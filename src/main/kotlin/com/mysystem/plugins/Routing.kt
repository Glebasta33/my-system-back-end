package com.mysystem.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/serialization") {
            call.respond(SerializationTest("Hello, serialization"))
        }
        get("/tasks") {
            call.respond(
                listOf(
                    Task(
                        id = "id_1",
                        name = "Купить молока"
                    ),
                    Task(
                        id = "id_2",
                        name = "Изучить основы компьютерных сетей"
                    )
                )
            )
        }
    }
}

@Serializable
data class SerializationTest(
    val text: String
)

@Serializable
data class Task(
    val id: String,
    val name: String
)