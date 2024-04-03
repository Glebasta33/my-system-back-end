package com.mysystem.features.tasks.models

import kotlinx.serialization.Serializable

@Serializable
data class CreateTaskRequest(
    val title: String
)

@Serializable
data class TaskResponse(
    val title: String,
    val id: String
)