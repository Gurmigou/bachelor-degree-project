import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("outfits")
data class Outfit(
        @Id
        var id: Long? = null,
        val name: String,
        val userId: Long
)