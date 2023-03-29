package com.example.demo.model

import org.springframework.stereotype.Repository
import java.sql.DriverManager
import java.sql.SQLException

@Repository
class BlaBLaDb {
    fun createDB() {
        val url = "jdbc:sqlite:C:/Users/gayal/Projects/demo/src/main/resources/BlaBlaDB.db"

        try {
            val conn = DriverManager.getConnection(url)
            if (conn != null) {
                val meta = conn.metaData
                println("The driver name is " + meta.driverName)
                println("A new database has been created.")
            }
        } catch (e: SQLException) {
            println(e.message)
        }
    }
}