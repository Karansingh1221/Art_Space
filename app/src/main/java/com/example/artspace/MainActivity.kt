package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivityResultRegistryOwner.current
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceAppPreview();
            }
        }
    }
}
@Composable
fun ArtSpaceCard(){
    var current by remember {mutableStateOf(1) }
    when(current) {
        1->{AppCard(
            R.drawable.img,
            R.string.images_name,
            R.string.images_artist,

        )}
        2->{AppCard(
            R.drawable.img_1,
            R.string.img_1,
            R.string.img_1_artist,

        )}
    }
    Row(modifier = Modifier
        .fillMaxSize()
        .padding(32.dp),
        verticalAlignment = Alignment.Bottom,
    ){
        Button(onClick = { current= maxOf(1,current-1) }, modifier = Modifier
            .padding(end = 8.dp)
            .weight(1f)) {
            Text(
                text="Previous"
            )
        }
        Button(onClick = { current= minOf(2,current+1) },modifier= Modifier
            .padding(start = 8.dp)
            .weight(1f)) {
            Text(
                text="Next",
                textAlign =  TextAlign.Center
            )

        }

    }
}
@Composable
public fun AppCard(
    image : Int,
    imagename : Int,
    name : Int,
){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,){
        Image(
            painter= painterResource(id = image),
            contentDescription = "null",
            modifier = Modifier.size(300.dp)
        )

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .background(color = Color.LightGray),
            ) {
            Text(
                text = stringResource(id = imagename),
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                fontSize = 32.sp,
                fontWeight = FontWeight.Light

            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(id = name),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                fontWeight = FontWeight.Bold,
            )
        }
        }

}
@Preview
@Composable
fun ArtSpaceAppPreview(){
    ArtSpaceTheme {
        ArtSpaceCard();
    }
}

