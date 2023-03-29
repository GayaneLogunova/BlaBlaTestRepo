package com.example.demo.controller

import com.example.demo.model.BlaBLaDb
import com.example.demo.repository.DemoRepo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class DemoController(private val service: DemoRepo, private val creator: BlaBLaDb) {

    @GetMapping("/api/employees")
    @ResponseBody
    fun getBlaBla(): List<String> {
        service.addBlaBlaRecord("my first rec", "hey hey")
        return service.getBlaBla()
    }
}