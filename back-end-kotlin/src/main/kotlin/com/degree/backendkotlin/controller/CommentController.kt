package com.degree.backendkotlin.controller

import com.degree.backendkotlin.dto.CommentDto
import com.degree.backendkotlin.serivce.CommentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@CrossOrigin("*")
@RestController
@RequestMapping("/comments")
class CommentController(
    @Autowired
    private val commentService: CommentService
) {

//    @PostMapping
//    fun saveNewComment(@RequestBody commentDto: CommentDto): ResponseEntity<CommentDto> {
//        return ResponseEntity.ok(commentService.saveNewComment(commentDto));
//    }
}