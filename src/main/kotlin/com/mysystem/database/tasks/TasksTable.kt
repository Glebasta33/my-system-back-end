package com.mysystem.database.tasks

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object TasksTable : Table("tasks") {
    private val taskId = TasksTable.varchar("taskId", length = 100)
    private val title = TasksTable.varchar("title", length = 700)

    fun create(taskDTO: TaskDTO) {
        transaction {
            TasksTable.insert { insertStatement ->
                insertStatement[taskId] = taskDTO.id
                insertStatement[title] = taskDTO.title
            }
        }
    }

    fun read(): List<TaskDTO> {
        return try {
            transaction {
                TasksTable.selectAll().toList()
                    .map { resultRow ->
                        TaskDTO(
                            id = resultRow[taskId],
                            title = resultRow[title]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}