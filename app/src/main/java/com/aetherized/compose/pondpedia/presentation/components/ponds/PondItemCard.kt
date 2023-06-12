package com.aetherized.compose.pondpedia.presentation.components.ponds

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aetherized.compose.pondpedia.R
import com.aetherized.compose.pondpedia.domain.model.pond.Pond
import com.aetherized.compose.pondpedia.domain.model.pond.dummyPondA
import java.time.Instant

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
//                painter = rememberAsyncImagePainter(model = pond.pondImageUrl),
                painter = painterResource(id = R.drawable.floating_island_11563055345),
                contentDescription = "Pond Image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(240.dp)
                    .height(240.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
            text = "PID: ${pond.pId}",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onBackground,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = pond.pondName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = MaterialTheme.colors.onBackground,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = pond.pondFish.scientificName!!,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colors.onBackground,
                style = TextStyle(fontStyle = Italic),
            )

            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = Instant.now().toString(),
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colors.onBackground
            )
        }

    }

}

@Preview
@Composable
fun DefaultPreview() {
    PondItemCard(dummyPondA, Modifier)
}