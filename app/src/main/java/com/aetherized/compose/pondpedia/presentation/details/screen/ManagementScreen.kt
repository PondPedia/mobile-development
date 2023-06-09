package com.aetherized.compose.pondpedia.presentation.details.screen
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Card
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.material3.TopAppBar
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import com.aetherized.compose.pondpedia.domain.model.pond.Pond
//import com.aetherized.compose.pondpedia.presentation.authentication.components.UserData
//import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondState
//import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondViewModel
//import com.aetherized.compose.pondpedia.presentation.management.components.ManagementTabScreen
//import com.aetherized.compose.pondpedia.presentation.ui.theme.Navi
//import com.aetherized.compose.pondpedia.presentation.ui.theme.PondPediaCustomTheme
//import com.aetherized.compose.pondpedia.presentation.ui.theme.White
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ManagementScreen(
//    userData: UserData?,
//    pond: Pond,
//    pondState: PondState,
//    pondViewModel: PondViewModel,
//    navController: NavHostController,
//    onReturnHome: () -> Unit
//) {
//    PondPediaCustomTheme() {
//        Scaffold(
//            topBar = {
//                TopAppBar(
//                    title = {
//                        Text(text = pond.pondName)
//                    },
//                )
//            },
//        ) { innerPadding ->
//            Box(
//                Modifier
//                    .padding(innerPadding)
//                    .background(MaterialTheme.colorScheme.background)
//            ) {
//
//                ManagementTabScreen(
//                    userData = userData,
//                    pond = Pond,
//                    pondViewModel = pondViewModel,
//                    navController = navController,
//                    onReturnHome = onReturnHome,
//                )
//            }
//        }
//    }
//}
//
//
//@Composable
//fun ManagementScreenA(
//    pondViewModel: PondViewModel,
//    navController: NavHostController,
//    onReturnHome: () -> Unit,
//) {
//    var pondName by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondName) }
//    var pondLength by rememberSaveable { mutableStateOf(5f) }
//    var pondWidth by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondWidth) }
//    var pontDepth by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondDepth) }
//    var waterTemperature by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondWater.temperature) }
//    var waterTurbidity by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondWater.turbidity) }
//    var waterDissolvedOxygen by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondWater.dissolvedOxygen) }
//    var waterPH by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondWater.pH) }
//    var waterAmmonia by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondWater.ammonia) }
//    var waterNitrate by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondWater.nitrate) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState()),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Top,
//    ) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = pondName,
//                onValueChange = { pondName = it; pondViewModel.pondData.pondName = it },
//                label = { Text("Nama Kolam") },
//                modifier = Modifier.fillMaxWidth(),
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = pondLength.toString(),
//                onValueChange = { pondLength = it.toFloat(); pondViewModel.pondData.pondLength = it.toFloat() },
//                label = { Text("Panjang Kolam") },
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = pondWidth.toString(),
//                onValueChange = { pondWidth = it.toFloat(); pondViewModel.pondData.pondWidth = it.toFloat() },
//                label = { Text("Luas Kolam") },
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = pontDepth.toString(),
//                onValueChange = { pontDepth = it.toFloat(); pondViewModel.pondData.pondDepth = it.toFloat() },
//                label = { Text("Kedalaman Kolam") },
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = waterTemperature.toString(),
//                onValueChange = { waterTemperature = it.toFloat(); pondViewModel.pondData.pondWater.temperature = it.toFloat() },
//                label = { Text("Derajat suhu Air") },
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = waterTurbidity.toString(),
//                onValueChange = { waterTurbidity = it.toFloat(); pondViewModel.pondData.pondWater.turbidity = it.toFloat() },
//                label = { Text("Tingkat kekeruhan air") },
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = waterDissolvedOxygen.toString(),
//                onValueChange = { waterDissolvedOxygen = it.toFloat() ; pondViewModel.pondData.pondWater.dissolvedOxygen = it.toFloat()},
//                label = { Text("Kadar oksigen terlarut di air") },
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = waterPH.toString(),
//                onValueChange = { waterPH = it.toFloat(); pondViewModel.pondData.pondWater.pH = it.toFloat() },
//                label = { Text("Kadar pH di air") },
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = waterAmmonia.toString(),
//                onValueChange = { waterAmmonia = it.toFloat(); pondViewModel.pondData.pondWater.ammonia = it.toFloat() },
//                label = { Text("Kadar ammonia di air") },
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = waterNitrate.toString(),
//                onValueChange = { waterNitrate = it.toFloat(); pondViewModel.pondData.pondWater.nitrate = it.toFloat() },
//                label = { Text("Kadar Nitrat di air") },
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//        Spacer(modifier = Modifier.height(12.dp))
//    }
//
//}
//@Composable
//fun ManagementScreenB(
//    pondViewModel: PondViewModel,
//    navController: NavHostController,
//) {
//
//    var fishId by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondFish.fishId) }
//    var fishCommonName by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondFish.fishCommonName) }
//    var fishScientificName by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondFish.fishScientificName) }
//    var fishAmount by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondFish.fishAmount) }
//    var fishTargetWeight by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondFish.fishTargetWeight) }
//    var fishCurrentWeight by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondFish.fishCurrentWeight) }
//    var fishCurrentLength by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondFish.fishCurrentLength) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState()),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Top,
//
//        ) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth(),
//        ) {
//            TextField(
//                value = fishId,
//                onValueChange = { fishId = it; pondViewModel.pondData.pondFish.fishId = it },
//                label = { Text("Fish ID") },
//                readOnly = true,
//                modifier = Modifier.fillMaxWidth(),
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = fishCommonName,
//                onValueChange = {
//                    fishCommonName = it; pondViewModel.pondData.pondFish.fishCommonName = it
//                },
//                label = { Text("Fish common name") },
//                readOnly = true,
//                modifier = Modifier.fillMaxWidth(),
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = fishScientificName,
//                onValueChange = {
//                    fishScientificName = it; pondViewModel.pondData.pondFish.fishScientificName = it
//                },
//                label = { Text("Fish scientific name") },
//                readOnly = true,
//                modifier = Modifier.fillMaxWidth(),
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = fishAmount.toString(),
//                onValueChange = { fishAmount = it.toInt() },
//                label = { Text("Fish amount") },
//                modifier = Modifier.fillMaxWidth(),
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = fishTargetWeight.toString(),
//                onValueChange = {
//                    fishTargetWeight =
//                        it.toFloat(); pondViewModel.pondData.pondFish.fishTargetWeight =
//                    it.toFloat()
//                },
//                label = { Text("Fish target weight") },
//                modifier = Modifier.fillMaxWidth(),
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = fishCurrentLength.toString(),
//                onValueChange = {
//                    fishCurrentWeight =
//                        it.toFloat(); pondViewModel.pondData.pondFish.fishCurrentWeight =
//                    it.toFloat()
//                },
//                label = { Text("Fish current weight") },
//                modifier = Modifier.fillMaxWidth(),
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = fishCurrentLength.toString(),
//                onValueChange = {
//                    fishCurrentLength =
//                        it.toFloat(); pondViewModel.pondData.pondFish.fishCurrentLength =
//                    it.toFloat()
//                },
//                label = { Text("Fish current length") },
//                modifier = Modifier.fillMaxWidth(),
//            )
//        }
//        Spacer(modifier = Modifier.height(12.dp))
//    }
//}
//
//
//@Composable
//fun ManagementScreenC(
//    pondViewModel: PondViewModel,
//    navController: NavHostController,
//) {
//    var feedName by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondFeed.feedName) }
//    var feedPercentage by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondFeed.feedPercentage) }
//    var feedProteinPercentage by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondFeed.feedProteinPercentage) }
//    var feedLipidPercentage by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondFeed.feedLipidPercentage) }
//    var feedCarbohydratePercentage by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondFeed.feedCarbohydratePercentage) }
//    var feedOthersPercentage by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondFeed.feedOthersPercentage) }
//    var feedFrequencyDaily by rememberSaveable { mutableStateOf(pondViewModel.pondData.pondFeed.feedFrequencyDaily) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState()),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Top,
//    ) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = feedName,
//                onValueChange = { feedName = it; pondViewModel.pondData.pondFeed.feedName = it },
//                label = { Text("Nama Pakan") },
//                readOnly = true,
//                modifier = Modifier.fillMaxWidth(),
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = feedPercentage.toString(),
//                onValueChange = {
//                    feedPercentage = it.toFloat(); pondViewModel.pondData.pondFeed.feedPercentage =
//                    it.toFloat()
//                },
//                label = { Text("Persentase Pakan / Berat Badan") },
//                readOnly = true,
//                modifier = Modifier.fillMaxWidth(),
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = feedProteinPercentage.toString(),
//                onValueChange = {
//                    feedProteinPercentage =
//                        it.toFloat(); pondViewModel.pondData.pondFeed.feedProteinPercentage =
//                    it.toFloat()
//                },
//                label = { Text("Persentase Protein pada Pakan") },
//                readOnly = true,
//                modifier = Modifier.fillMaxWidth(),
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = feedLipidPercentage.toString(),
//                onValueChange = {
//                    feedLipidPercentage =
//                        it.toFloat(); pondViewModel.pondData.pondFeed.feedLipidPercentage =
//                    it.toFloat()
//                },
//                label = { Text("Persentase Lipid pada Pakan") },
//                readOnly = true,
//                modifier = Modifier.fillMaxWidth(),
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = feedCarbohydratePercentage.toString(),
//                onValueChange = {
//                    feedCarbohydratePercentage =
//                        it.toFloat(); pondViewModel.pondData.pondFeed.feedCarbohydratePercentage =
//                    it.toFloat()
//                },
//                label = { Text("Persentase Carbohydrate pada pakan") },
//                readOnly = true,
//                modifier = Modifier.fillMaxWidth(),
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = feedOthersPercentage.toString(),
//                onValueChange = {
//                    feedOthersPercentage =
//                        it.toFloat(); pondViewModel.pondData.pondFeed.feedOthersPercentage =
//                    it.toFloat()
//                },
//                label = { Text("Persentase faktor lain pada pakan") },
//                readOnly = true,
//                modifier = Modifier.fillMaxWidth(),
//            )
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            TextField(
//                value = feedFrequencyDaily.toString(),
//                onValueChange = {
//                    feedFrequencyDaily =
//                        it.toInt(); pondViewModel.pondData.pondFeed.feedFrequencyDaily = it.toInt()
//                },
//                label = { Text("Pemberian pakan dalam sehari") },
//                readOnly = true,
//                modifier = Modifier.fillMaxWidth(),
//            )
//        }
//        Spacer(modifier = Modifier.height(12.dp))
//    }
//}
//
//@Composable
//fun ManagementScreenD(
//    pondViewModel: PondViewModel,
//    navController: NavHostController,
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState()),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Top,
//    ) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Nama Kolam", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = pondViewModel.pondData.pondName,
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Panjang Kolam", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondLength}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Lebar Kolam", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondWidth}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Kedalaman Kolam", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondDepth}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Derajat Suhu Air", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondWater.temperature}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Tingkat Kekeruhan Air", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondWater.turbidity}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(
//                    text = "Kadar Oksigen Terlarut di Air",
//                    fontWeight = FontWeight.SemiBold,
//                    maxLines = 1
//                )
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondWater.dissolvedOxygen}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Kadar pH Air", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondWater.pH}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Kadar Ammonia di Air", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondWater.ammonia}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Kadar Nitrat di Air", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondWater.nitrate}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Nama Umum Ikan", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = pondViewModel.pondData.pondFish.fishCommonName,
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Nama Ilmiah Ikan", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondFish.fishScientificName}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Jumlah Ikan", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondFish.fishAmount}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Berat Ikan (Target)", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondFish.fishTargetWeight}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Berat Ikan (Sekarang)", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondFish.fishCurrentWeight}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(
//                    text = "Panjang Ikan (Sekarang)",
//                    fontWeight = FontWeight.SemiBold,
//                    maxLines = 1
//                )
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondFish.fishCurrentLength}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Jenis Pakan", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = pondViewModel.pondData.pondFeed.feedName,
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(
//                    text = "Persentase Pakan / Berat Ikan",
//                    fontWeight = FontWeight.SemiBold,
//                    maxLines = 1
//                )
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondFeed.feedPercentage}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Persentase Protein", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondFeed.feedProteinPercentage}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Persentase Lipid", fontWeight = FontWeight.SemiBold, maxLines = 1)
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondFeed.feedLipidPercentage}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(
//                    text = "Persentase Karbohidrat",
//                    fontWeight = FontWeight.SemiBold,
//                    maxLines = 1
//                )
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondFeed.feedCarbohydratePercentage}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(
//                    text = "Persentase Kandungan Lainnya",
//                    fontWeight = FontWeight.SemiBold,
//                    maxLines = 1
//                )
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondFeed.feedOthersPercentage}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Card(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(
//                    text = "Frekuensi pemberian pakan / hari",
//                    fontWeight = FontWeight.SemiBold,
//                    maxLines = 1
//                )
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(
//                    text = "${pondViewModel.pondData.pondFeed.feedFrequencyDaily}",
//                    fontWeight = FontWeight.Normal,
//                    maxLines = 1
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(12.dp))
//        Button(
//            modifier = Modifier.fillMaxWidth(),
//            colors = ButtonDefaults.buttonColors(containerColor = Navi, contentColor = White),
//            shape = RoundedCornerShape(8.dp),
//            onClick = {
//                pondViewModel.onAddPondToDatabase(userId = pondViewModel.getLocalUserId(), pond = pondViewModel.pondData)
//                onCreatePond
//            }) {
//            Text(text = "Buat Kolam", modifier = Modifier, fontWeight = FontWeight.Bold, color = White)
//        }
//    }
//}
