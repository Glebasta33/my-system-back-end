package com.mysystem

import com.mysystem.database.tasks.TasksTable
import com.mysystem.plugins.configureRouting
import com.mysystem.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    initDB()

    embeddedServer(
        Netty,
        port = 80,
        module = Application::module
    ).start(wait = true)
}

private fun initDB() {
    Database.connect(
        url = "jdbc:postgresql://62.113.115.167/test_db",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "admin"
    )

    transaction { SchemaUtils.create(TasksTable) }
}

fun Application.module() {
    configureRouting()
    configureSerialization()
}
