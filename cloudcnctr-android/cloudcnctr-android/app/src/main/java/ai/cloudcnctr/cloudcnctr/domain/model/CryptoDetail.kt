package ai.cloudcnctr.cloudcnctr.domain.model

import ai.cloudcnctr.cloudcnctr.data.remote.dto.MoreInfoItemMember

/**
 * Created by Das on 2022-07-11.
 */
data class CryptoDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<MoreInfoItemMember>
)
