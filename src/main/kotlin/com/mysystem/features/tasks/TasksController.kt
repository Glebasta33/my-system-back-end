package com.mysystem.features.tasks

import com.mysystem.database.tasks.TasksTable
import com.mysystem.database.tasks.mapToDTO
import com.mysystem.database.tasks.mapToModel
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

        val newTask = TaskResponse(
            title = request.title,
            id = UUID.randomUUID().toString()
        )

        TasksTable.create(newTask.mapToDTO())

        call.respond(newTask)
    }

    suspend fun readGames(call: ApplicationCall) {
        val request = call.receive<ReadTasksRequest>()

        val filteredTasks = TasksTable.read()
            .filter { it.title.contains(request.search, ignoreCase = true) }
            .map { it.mapToModel() }

        call.respond(
            ReadTasksResponse(filteredTasks)
        )
    }

}