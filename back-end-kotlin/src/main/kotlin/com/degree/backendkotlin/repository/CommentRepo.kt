package com.degree.backendkotlin.repository

import com.degree.backendkotlin.model.Comment
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepo : CrudRepository<Comment, Long> {

    @Query(
        """
        SELECT COUNT(C.id) FROM Comment C
        INNER JOIN C.outfit O
        WHERE O.id = ?1
    """
    )
    fun countWhereOutfitIdEquals(outfitId: Long?): Long

    @Query(
        """
        SELECT C FROM Comment C
        INNER JOIN C.outfit O
        WHERE O.id = ?1
    """
    )
    fun getCommentsByOutfitId(outfitId: Long?): List<Comment>
}