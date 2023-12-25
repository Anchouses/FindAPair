package com.silaeva.menu_impl.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.silaeva.common_ui.CardContainer
import com.silaeva.common_ui.ScoreField
import com.silaeva.common_ui.typography.Colors
import com.silaeva.common_ui.typography.Typography
import com.silaeva.menu_impl.R


@Composable
fun MenuScreen (
    viewModel: MenuViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center

    ) {
        Row(
            modifier = Modifier
                .align(Alignment.End)
                .padding(24.dp)
        ) {
            ScoreField(
                text = "${viewModel.score}"
            )
        }

        Spacer(modifier = Modifier.height(130.dp))

        CardContainer(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.CenterHorizontally)
                .width(230.dp)
                .height(230.dp)
        ) {
            Text(
                text = stringResource(id = R.string.game_logo),
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                style = Typography.title,
                maxLines = 2
            )
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.CenterHorizontally)
                .width(150.dp),
            shape = RoundedCornerShape(24.dp)
            ) {
            Text(
                text = stringResource(id = R.string.play_button),
                style = Typography.description,
                color = Colors.white
            )
        }

        CardContainer(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.End)
                .width(120.dp)
                .height(120.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.lock),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                alignment = Alignment.Center
            )
        }
    }
}