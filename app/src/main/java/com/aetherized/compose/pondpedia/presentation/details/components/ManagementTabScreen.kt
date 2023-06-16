package com.aetherized.compose.pondpedia.presentation.details.components
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import com.aetherized.compose.pondpedia.domain.model.pond.Pond
//import com.aetherized.compose.pondpedia.presentation.home.ponds.components.PondViewModel
//import com.aetherized.compose.pondpedia.presentation.management.screen.ManagementScreenA
//import com.aetherized.compose.pondpedia.presentation.management.screen.ManagementScreenB
//import com.aetherized.compose.pondpedia.presentation.management.screen.ManagementScreenC
//import com.aetherized.compose.pondpedia.presentation.management.screen.ManagementScreenD
//
//
//enum class Tab (val title: String) {
//
//    PondTabA("Ikan"),
//    PondTabB("Pakan"),
//    PondTabC("Air"),
//    PondTabD("Analisis"),
//}
//
//@Composable
//fun ManagementTabScreen(
//    userData: UserData?,
//    pond: Pond
//    pondViewModel: PondViewModel,
//    navController: NavHostController,
//    onReturnHome: () -> Unit,
//) {
//    var selectedTab by remember { mutableStateOf(Tab.PondTabA) }
//    var tabIndex by remember { mutableStateOf(0) }
//    val tabs = listOf(
//                Tab.PondTabA,
//                Tab.PondTabB,
//                Tab.PondTabC,
//                Tab.PondTabD,
//            )
//
//
//    Column(modifier = Modifier.fillMaxWidth()) {
//        TabRow(selectedTabIndex = tabIndex) {
//            tabs.forEachIndexed { index, tab ->
//                Tab(
//                    text = { Text(text = tab.title, fontSize = 12.sp, maxLines = 1) },
//                    selected = selectedTab == tab,
//                    onClick = {
//                        selectedTab = tab
//                        tabIndex = index
//                    },
//                    selectedContentColor = MaterialTheme.colorScheme.onPrimary,
//                    unselectedContentColor = MaterialTheme.colorScheme.onPrimary,
//                )
//            }
//        }
//        when (selectedTab) {
//            Tab.PondTabA -> ManagementScreenA(pondViewModel = pondViewModel)
//            Tab.PondTabB -> ManagementScreenB(pondViewModel = pondViewModel)
//            Tab.PondTabC -> ManagementScreenC(pondViewModel = pondViewModel)
//            Tab.PondTabD -> ManagementScreenD(pondViewModel = pondViewModel)
//            else -> ManagementScreenA()
//        }
//    }
//}
//
//
