package ai.cloudcnctr.cloudcnctr.domain.model

/**
 * Created by Das on 2022-07-11.
 */
data class Crypto(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
