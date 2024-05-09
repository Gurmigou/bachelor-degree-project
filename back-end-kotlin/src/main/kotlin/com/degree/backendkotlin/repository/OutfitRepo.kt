package com.degree.backendkotlin.repository

import com.degree.backendkotlin.model.Outfit
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OutfitRepo : CrudRepository<Outfit, Long> {
    @Query(
        """
        SELECT O FROM Outfit O
        INNER JOIN O.user U
        WHERE U.id = ?1
    """
    )
    fun findAllByUserId(userId: Long): List<Outfit>
}