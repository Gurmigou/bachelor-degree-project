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

    @Query(
        """
        SELECT O FROM Outfit O
        INNER JOIN O.tags O_TAGS
        INNER JOIN O.clothesItems CI
        INNER JOIN CI.tags CI_TAGS
        WHERE CI.brand IN ?1 AND CI_TAGS.tag IN ?2
    """
    )
    fun findAllWithFilers(brands: Set<String>, tags: Set<String>): List<Outfit>
}