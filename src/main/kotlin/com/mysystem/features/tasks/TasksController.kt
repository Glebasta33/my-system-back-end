package com.mysystem.features.tasks

import com.mysystem.features.tasks.models.CreateTaskRequest
import com.mysystem.features.tasks.models.ReadTasksRequest
import com.mysystem.features.tasks.models.ReadTasksResponse
import com.mysystem.features.tasks.models.TaskResponse
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import java.util.UUID

object TasksController {

    suspend fun createGame(call: ApplicationCall) {
        val request = call.receive<CreateTaskRequest>()

        //TODO: Добавить обращение к БД

        val newTask = TaskResponse(
            title = request.title,
            id = UUID.randomUUID().toString()
        )

        call.respond(newTask)
    }

    suspend fun readGames(call: ApplicationCall) {
        val request = call.receive<ReadTasksRequest>()

        //TODO: Добавить обращение к БД

        call.respond(
            ReadTasksResponse(emptyList())
        )
    }

}