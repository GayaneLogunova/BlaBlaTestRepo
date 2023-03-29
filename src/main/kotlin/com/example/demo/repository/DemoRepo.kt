package com.example.demo.repository

import org.springframework.stereotype.Repository
import java.sql.DriverManager
import java.sql.SQLException


@Repository
class DemoRepo {
    private companion object {
        const val url = "jdbc:sqlite:C:/Users/gayal/Projects/demo/src/main/resources/BlaBlaDB.db"
    }

    fun getBlaBla(): List<String> {
        val sql = "SELECT name, blabla FROM blablaTable"
        val list = mutableListOf<String>()
        try {
            DriverManager.getConnection(url).use { conn ->
                conn.createStatement().use { stmt ->
                    stmt.executeQuery(sql).use { rs ->

                        // loop through the result set
                        while (rs.next()) {
                            val a = rs.getString("name")
                            val b = rs.getString("blabla")
                            list.add(a + b)
                            println(a + "\t" + b)
                        }
                    }
                }
            }
        } catch (e: SQLException) {
            println(e.message)
        }
        return list
    }

    fun addBlaBlaRecord(name: String, blaBla: String) {
        val sql = "INSERT INTO blablaTable(name,blabla) VALUES(?,?)";

        try {
            DriverManager.getConnection(url).use { conn ->
                conn.prepareStatement(sql).use { pstmt ->
                    pstmt.setString(1, name)
                    pstmt.setString(2, blaBla)
                    pstmt.executeUpdate()
                }
            }
        } catch (e: SQLException) {
            println(e.message)
        }
    }
}