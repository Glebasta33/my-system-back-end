package com.mysystem.features.tasks

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureTasksRouting() {
    routing {
        post("/tasks/create") {
            TasksController.createGame(call)
        }

        post("/tasks/read") {
            TasksController.readGames(call)
        }
    }
}