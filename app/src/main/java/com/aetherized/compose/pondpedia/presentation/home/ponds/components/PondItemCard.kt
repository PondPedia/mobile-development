package com.aetherized.compose.pondpedia.presentation.home.ponds.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.aetherized.compose.pondpedia.R
import com.aetherized.compose.pondpedia.domain.model.pond.Pond
import com.aetherized.compose.pondpedia.domain.model.pond.dummyPondA

@Composable
fun PondItemCard(
    pond: Pond,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp),
    ){
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = if(!pond.pondImageUrl.isNullOrEmpty()) rememberAsyncImagePainter(model = pond.pondImageUrl) else painterResource(R.drawable.pond_image_1),
                contentDescription = "Pond Image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(240.dp)
                    .height(240.dp)
                    .align(Alignment.CenterHorizontally)
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
            )
            Text(
                text = pond.pondFish.fishScientificName,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.onBackground,
                style = TextStyle(fontStyle = Italic),
            )
            Spacer(modifier = Modifier.height(2.dp))
            Row (
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column (
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "Date Created",
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = pond.createdAt,
                        fontWeight = FontWeight.ExtraLight,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column (
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "Date Updated",
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = pond.updatedAt,
                        fontWeight = FontWeight.ExtraLight,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    PondItemCard(dummyPondA, Modifier)
}