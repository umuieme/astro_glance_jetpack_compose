package com.umuieme.astroglance.presentation.home.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.umuieme.astroglance.domain.model.ApodModel
import com.umuieme.astroglance.presentation.component.ApodItem


@Composable
fun ApodHomeListView(apodList: List<ApodModel>, modifier: Modifier = Modifier){

    val pagerState = rememberPagerState(pageCount = { apodList.size })

    VerticalPager(
        state = pagerState,
        modifier = modifier.fillMaxSize(),
        key = { it }
    ) { page ->
        ApodItem(apodModel = apodList[page])
    }
}