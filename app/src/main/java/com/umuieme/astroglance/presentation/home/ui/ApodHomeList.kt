package com.umuieme.astroglance.presentation.home.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import com.umuieme.astroglance.domain.model.ApodModel
import com.umuieme.astroglance.presentation.component.ApodItem


@Composable
fun ApodHomeListView(
    apodList: List<ApodModel>,
    onPageSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(pageCount = { apodList.size })

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            onPageSelected(page)
        }
    }

    VerticalPager(
        state = pagerState,
        modifier = modifier.fillMaxSize(),
        key = { index ->
            if (index < apodList.size) apodList[index].date else index
        }
    ) { page ->
        ApodItem(apodModel = apodList[page])
    }
}