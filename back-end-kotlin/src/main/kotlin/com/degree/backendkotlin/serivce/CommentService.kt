package com.degree.backendkotlin.serivce

import com.degree.backendkotlin.dto.CommentDto
import com.degree.backendkotlin.model.Comment
import com.degree.backendkotlin.model.Outfit
import com.degree.backendkotlin.model.Rate
import com.degree.backendkotlin.repository.CommentRepo
import com.degree.backendkotlin.repository.OutfitRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import kotlin.math.floor

@Service
class CommentService @Autowired constructor(
    private val outfitRepository: OutfitRepo,
    private val commentRepository: CommentRepo,
    private val userService: UserService
) {
    @Transactional
    fun saveNewComment(commentDto: CommentDto, outfitId: Long, userId: Long): CommentDto? {
        val outfit = outfitRepository.findById(outfitId).orElse(null)
        val comment = Comment(
            commentText = commentDto.commentText,
            user = userService.getUser(userId),
            outfit = outfit!!,
            rate = commentDto.rate,
            dateOfCreation = LocalDateTime.now()
        )
        val savedComment = commentRepository.save(comment)
        return CommentDto(
            savedComment.user.id,
            savedComment.user.nickname,
            savedComment.commentText,
            savedComment.rate,
            savedComment.dateOfCreation
        )
    }

    fun getNumberOfCommentsForOutfit(outfit: Outfit): Long {
        return commentRepository.countWhereOutfitIdEquals(outfit.id);
    }

    fun getAverageRateForOutfit(outfit: Outfit): Rate {
        return Rate.getByLongStart(floor(commentRepository.getCommentsByOutfitId(outfit.id)
            .map { comment -> comment.rate.ordinal + 1 }
            .average()).toLong())
    }

    fun getCommentsByOutfitId(outfitId: Long): List<CommentDto> {
        return commentRepository.getCommentsByOutfitId(outfitId)
            .map { comment ->
                CommentDto(
                    comment.user.id,
                    comment.user.nickname,
                    comment.commentText,
                    comment.rate,
                    comment.dateOfCreation
                )
            }
    }
}