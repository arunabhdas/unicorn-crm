package ai.cloudcnctr.cloudcnctr.presentation.ui.crypto_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import ai.cloudcnctr.cloudcnctr.data.remote.dto.MoreInfoItemMember

/**
 * Created by Das on 2022-07-12.
 */
@Composable
fun MoreInfoListItem(
    moreInfoItemMember: MoreInfoItemMember,
    modifier: Modifier = Modifier

) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = moreInfoItemMember.name,
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = moreInfoItemMember.position,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic

        )

    }
}