package com.mysystem.features.tasks.models

import kotlinx.serialization.Serializable

@Serializable
data class ReadTasksRequest(
    val search: String
)

@Serializable
data class ReadTasksResponse(
    val tasks: List<TaskResponse>
)