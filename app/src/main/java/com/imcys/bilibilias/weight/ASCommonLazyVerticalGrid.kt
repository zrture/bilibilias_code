package com.imcys.bilibilias.weight

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun <T> ASCommonSelectGrid(
    modifier: Modifier = Modifier,
    items: List<T>,
    key: ((T) -> Any),
    title: (T) -> String,
    selected: (T) -> Boolean,
    onClick: (T) -> Unit,
) {
    LazyVerticalGrid(
        GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier
            .sizeIn(maxHeight = (60 * 2 + 2 * 10).dp),
    ) {
        // key 拼接 index 保证唯一，避免同名项重复 key 崩溃
        itemsIndexed(items, key = { index, item -> "${key(item)}_$index" }) { _, item ->
            FilterChip(
                selected = selected(item),
                onClick = {
                    onClick(item)
                },
                label = {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            title(item),
                            maxLines = 2,
                            fontSize = 14.sp,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }
            )
        }

    }
}