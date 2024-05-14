package com.theathletic.interview.leagues.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theathletic.interview.core.collectWithLifecycle
import com.theathletic.interview.ui.theme.Black
import com.theathletic.interview.ui.theme.White
import org.koin.androidx.compose.getViewModel

class LeagueUiModel(
    val name: String,
    val shortName: String,
    val sportType: String,
    val id: String
)

@Composable
fun LeaguesScreen(
    viewModel: LeaguesViewModel = getViewModel()
) {

    val state by viewModel.viewState.collectAsState(initial = LeaguesViewState(true, emptyList()))

    viewModel.viewEvent.collectWithLifecycle { //event->
//        when (event){
//          here you can handle one-off events
//        }
    }

    LeaguesList(
        models = state.leagueModels
    )
}

@Composable
fun LeaguesList(
    models: List<LeagueUiModel>
) {
    Box {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            items(models) { LeagueItem(it) }
        }
    }
}

@Composable
fun LeagueItem(
    model: LeagueUiModel
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .background(color = Black)
            .height(100.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = model.name,
                    style = MaterialTheme.typography.body1,
                    color = White
                )
                Text(
                    text = model.shortName,
                    style = MaterialTheme.typography.caption,
                    color = White
                )
            }
            Text(
                modifier = Modifier.padding(4.dp),
                text = model.sportType,
                style = MaterialTheme.typography.caption,
                color = White
            )
        }

    }
}
