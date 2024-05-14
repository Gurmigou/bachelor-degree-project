package com.degree.backendkotlin.controller

import com.degree.backendkotlin.dto.LabelCountDto
import com.degree.backendkotlin.serivce.StaticService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RestController
@RequestMapping("/static")
class StaticController(@Autowired private val staticService: StaticService) {

    @GetMapping("/brands")
    fun getBrandNames(): List<LabelCountDto> {
        return staticService.getBrandNames()
    }

    @GetMapping("/tags")
    fun getTagNames(): List<LabelCountDto> {
        return staticService.getTagNames()
    }
}