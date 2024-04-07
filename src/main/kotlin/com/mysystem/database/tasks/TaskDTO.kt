package com.mysystem.database.tasks

import com.mysystem.features.tasks.models.TaskResponse
import kotlinx.serialization.Serializable

@Serializable
data class TaskDTO(
    val id: String,
    val title: String
)

fun TaskResponse.mapToDTO() = TaskDTO(
    id = id,
    title = title
)

fun TaskDTO.mapToModel() = TaskResponse(
    id = id,
    title = title
)