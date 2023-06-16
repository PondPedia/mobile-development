package com.aetherized.compose.pondpedia.presentation.details.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.aetherized.compose.pondpedia.R
import com.aetherized.compose.pondpedia.domain.model.pond.Pond
import com.aetherized.compose.pondpedia.presentation.details.components.DetailsTabScreen
import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondState
import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondViewModel
import com.aetherized.compose.pondpedia.presentation.ui.theme.Black
import com.aetherized.compose.pondpedia.presentation.ui.theme.Navi
import com.aetherized.compose.pondpedia.presentation.ui.theme.PondPediaCustomTheme
import com.aetherized.compose.pondpedia.presentation.ui.theme.White


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    pondState: PondState,
    pondViewModel: PondViewModel
    ) {
    PondPediaCustomTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = pondState.pondData.pondName)
                    },
                )
            },
        ) { innerPadding ->
            val pond = pondViewModel.pondData
            Box(
                Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Column {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)){
                        PondDetailsCard(pond = pond)
                    }
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                    ){
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                                .fillMaxHeight(),
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .align(Alignment.CenterHorizontally)
                                    .padding(8.dp)
                                    .border(1.dp, Black, RoundedCornerShape(4))
                                    .padding(4.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                DetailsTabScreen(
                                    pondState = pondState,
                                    pondViewModel = pondViewModel,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PondDetailsCard(pond: Pond) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(250.dp)
            .fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
                .border(1.dp, Black, RoundedCornerShape(4))
                .padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {

                Image(
                    painter = if (!pond.pondImageUrl.isNullOrEmpty()) rememberAsyncImagePainter(
                        model = pond.pondImageUrl
                    ) else painterResource(R.drawable.pond_image_1),
                    contentDescription = "Pond Image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(200.dp)
                        .weight(1f)
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = pond.pondName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = pond.pondFish.fishCommonName,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
                Text(
                    text = pond.pondFish.fishScientificName,
                    fontWeight = FontWeight.Light,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = TextStyle(fontStyle = FontStyle.Italic),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.height(2.dp))

                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Last Updated:",
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = pond.updatedAt,
                        fontWeight = FontWeight.ExtraLight,
                        color = MaterialTheme.colorScheme.onBackground,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                    )
                }
            }
        }
    }
}


@Composable
fun DetailsScreenA (
    pondState: PondState,
    pondViewModel: PondViewModel,
) {
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
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Nama Kolam", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = pondViewModel.pondData.pondName,
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Panjang Kolam", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondLength}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Lebar Kolam", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondWidth}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Kedalaman Kolam", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondDepth}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Derajat Suhu Air", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondWater.temperature}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Tingkat Kekeruhan Air", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondWater.turbidity}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Kadar Oksigen Terlarut di Air",
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondWater.dissolvedOxygen}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Kadar pH Air", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondWater.pH}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Kadar Ammonia di Air", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondWater.ammonia}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Kadar Nitrat di Air", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondWater.nitrate}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
    }

}
@Composable
fun DetailsScreenB(
    pondState: PondState,
    pondViewModel: PondViewModel,
) {
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
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Nama Umum Ikan", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = pondViewModel.pondData.pondFish.fishCommonName,
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Nama Ilmiah Ikan", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondFish.fishScientificName}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Jumlah Ikan", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondFish.fishAmount}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Berat Ikan (Target)", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondFish.fishTargetWeight}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Berat Ikan (Sekarang)", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondFish.fishCurrentWeight}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Panjang Ikan (Sekarang)",
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondFish.fishCurrentLength}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
    }
}


@Composable
fun DetailsScreenC(
    pondState: PondState,
    pondViewModel: PondViewModel,
) {
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
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Jenis Pakan", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = pondViewModel.pondData.pondFeed.feedName,
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Persentase Pakan / Berat Ikan",
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondFeed.feedPercentage}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Persentase Protein", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondFeed.feedProteinPercentage}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Persentase Lipid", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondFeed.feedLipidPercentage}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Persentase Karbohidrat",
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondFeed.feedCarbohydratePercentage}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Persentase Kandungan Lainnya",
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondFeed.feedOthersPercentage}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Frekuensi pemberian pakan / hari",
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondFeed.feedFrequencyDaily}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun DetailsScreenD(
    pondState: PondState,
    pondViewModel: PondViewModel,
) {
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
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Prediksi Pertumbuhan dari Ikan", fontWeight = FontWeight.Bold, maxLines = 1)
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Navi, contentColor = White),
                    shape = RoundedCornerShape(8.dp),
                    onClick = {

                    }) {
                    Text(text = "Prediksi Pertumbuhan", modifier = Modifier, fontWeight = FontWeight.Bold, color = White)
                }
                Spacer(modifier = Modifier.height(12.dp))

                Text(text = "Jumlah hari yang dibutuhkan untuk mencapai target:", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondGrowthPrediction?.growthDays ?: "Unavailable"}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Jumlah pakan yang dibutuhkan untuk mencapai target::", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondGrowthPrediction?.growthFeed ?: "Unavailable"}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Panjang dari ikan saat siap dipanen:", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondGrowthPrediction?.growthLength ?: "Unavailable"}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Prediksi Perubahan dari Kualitas Air", fontWeight = FontWeight.Bold, maxLines = 1)
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Navi, contentColor = White),
                    shape = RoundedCornerShape(8.dp),
                    onClick = {

                    }) {
                    Text(text = "Prediksi Perubahan", modifier = Modifier, fontWeight = FontWeight.Bold, color = White)
                }
                Spacer(modifier = Modifier.height(12.dp))

                Text(text = " Temperatur Air:", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondWaterPrediction?.temperature ?: "Unavailable"}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = " Kekeruhan Air:", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondWaterPrediction?.turbidity ?: "Unavailable"}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = " Oksigen Terlarut dalam Air:", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondWaterPrediction?.dissolvedOxygen ?: "Unavailable"}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = " Kadar pH dari Air:", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondWaterPrediction?.pH ?: "Unavailable"}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Ammonia dalam Air:", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondWaterPrediction?.ammonia ?: "Unavailable"}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = " Nitrat dalam Air:", fontWeight = FontWeight.SemiBold, maxLines = 1)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${pondViewModel.pondData.pondWaterPrediction?.nitrate ?: "Unavailable"}",
                    fontWeight = FontWeight.Normal,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
