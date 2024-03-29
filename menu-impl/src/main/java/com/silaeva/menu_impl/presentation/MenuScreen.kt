package com.silaeva.menu_impl.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center

    ) {
        Row(
            modifier = Modifier
                .align(Alignment.End)
                .padding(24.dp)
        ) {
            val scoreList = viewModel.scoreList.collectAsState(initial = emptyList())
            val fullScore = scoreList.value.sumOf { it.score }
            Box { ScoreField(text = "$fullScore") }
        }

        Spacer(modifier = Modifier.height(100.dp))

        CardContainer(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.CenterHorizontally)
                .width(230.dp)
                .height(230.dp)
        ) {
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ){
                Text(
                    text = stringResource(id = R.string.game),
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally),
                    style = Typography.title
                )
                Text(
                    text = stringResource(id = R.string.logo),
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally),
                    style = Typography.title
                )
            }
        }

        Button(
            onClick = { viewModel.onPlayButtonClick() },
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