package com.aetherized.compose.pondpedia.presentation.home.history.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aetherized.compose.pondpedia.presentation.home.components.BottomNavItem

private val selectedNavItem = BottomNavItem.History

@Composable
fun HistoryScreenA() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable{}
        ) {
            Row {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = "Kolam", fontWeight = FontWeight.Bold, maxLines = 1)
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Pond 1.3.7", fontWeight = FontWeight.SemiBold, maxLines = 1)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Kolam berhasil dibuat",
                        fontWeight = FontWeight.Normal,
                        maxLines = 1
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable{}
        ) {
            Row {
                Box {
                    Text(text = "Kolam", fontWeight = FontWeight.Bold, maxLines = 1)
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Pond 1.3.2", fontWeight = FontWeight.SemiBold, maxLines = 1)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Kolam berhasil dibuat",
                        fontWeight = FontWeight.Normal,
                        maxLines = 1
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable{}
        ) {
            Row {
                Box {
                    Text(text = "Explore", fontWeight = FontWeight.Bold, maxLines = 1)
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Informasi Baru", fontWeight = FontWeight.SemiBold, maxLines = 1)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Tips menentukan jenis pakan yang tepat",
                        fontWeight = FontWeight.Normal,
                        maxLines = 1
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable{}
        ) {
            Row {
                Box {
                    Text(text = "Kolam", fontWeight = FontWeight.Bold, maxLines = 1)
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Pond 1.2.2", fontWeight = FontWeight.SemiBold, maxLines = 1)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Kolam berhasil dibuat",
                        fontWeight = FontWeight.Normal,
                        maxLines = 1
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable{}
        ) {
            Row {
                Box {
                    Text(text = "Lainnya", fontWeight = FontWeight.Bold, maxLines = 1)
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Versi Baru Tersedia", fontWeight = FontWeight.SemiBold, maxLines = 1)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Update aplikasi ke versi terbaru demi kemanan",
                        fontWeight = FontWeight.Normal,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

@Composable
fun HistoryScreenB() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable{}
        ) {
            Row {
                Box {
                    Text(text = "Kolam", fontWeight = FontWeight.Bold, maxLines = 1)
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Pond 1.3.7", fontWeight = FontWeight.SemiBold, maxLines = 1)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Kolam berhasil dibuat",
                        fontWeight = FontWeight.Normal,
                        maxLines = 1
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable{}
        ) {
            Row {
                Box {
                    Text(text = "Kolam", fontWeight = FontWeight.Bold, maxLines = 1)
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Pond 1.3.2", fontWeight = FontWeight.SemiBold, maxLines = 1)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Kolam berhasil dibuat",
                        fontWeight = FontWeight.Normal,
                        maxLines = 1
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable{}
        ) {
            Row {
                Box {
                    Text(text = "Kolam", fontWeight = FontWeight.Bold, maxLines = 1)
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Pond 1.2.2", fontWeight = FontWeight.SemiBold, maxLines = 1)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Kolam berhasil dibuat",
                        fontWeight = FontWeight.Normal,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

@Composable
fun HistoryScreenC() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {}
        ) {
            Row {
                Box {
                    Text(text = "Pedia", fontWeight = FontWeight.Bold, maxLines = 1)
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Informasi Baru", fontWeight = FontWeight.SemiBold, maxLines = 1)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Tips menentukan jenis pakan yang tepat",
                        fontWeight = FontWeight.Normal,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

@Composable
fun HistoryScreenD() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {}
        ) {
            Row {
                Box {
                    Text(text = "Lainnya", fontWeight = FontWeight.Bold, maxLines = 1)
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Versi Baru Tersedia", fontWeight = FontWeight.SemiBold, maxLines = 1)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Versi 1.2 | Segera update aplikasi untuk mendapatkan keamanan dan kenyamanan maksimal",
                        fontWeight = FontWeight.Normal,
                        maxLines = 1
                    )
                }
            }
        }
    }
}