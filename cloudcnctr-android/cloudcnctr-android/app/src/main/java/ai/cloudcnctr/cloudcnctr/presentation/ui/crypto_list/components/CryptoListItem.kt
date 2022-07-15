package ai.cloudcnctr.cloudcnctr.presentation.ui.crypto_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ai.cloudcnctr.cloudcnctr.common.Constants
import ai.cloudcnctr.cloudcnctr.domain.model.Crypto
import ai.cloudcnctr.cloudcnctr.presentation.ui.theme.LightRed

/**
 * Created by Das on 2022-07-11.
 */
@Composable
fun CryptoListItem(
    crypto: Crypto,
    onItemClick: (Crypto) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(crypto) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${crypto.rank}. ${crypto.name} (${crypto.symbol}",
            style = MaterialTheme.typography.h2,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = if (crypto.isActive) Constants.STATUS_ACTIVE else Constants.STATUS_INACTIVE,
            color = if (crypto.isActive) Color.Green else LightRed,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)
        )
    }
}