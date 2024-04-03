package com.mysystem

import com.mysystem.plugins.configureRouting
import com.mysystem.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database

fun main() {
     Database.connect(
         url = "jdbc:postgresql://localhost:5432/mobile_developer_course",
         driver = "org.postgresql.Driver",
         password = "admin"
     )

    embeddedServer(
        Netty,
        port = 80,
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    configureRouting()
    configureSerialization()
}
