package com.example.jetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

private val messages: List<MyMessage> = listOf(
    MyMessage("Hola Guapa", "Hola."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut enim ad minim veniam."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis aute irure dolor in reprehenderit."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus ante dapibus diam."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean commodo ligula eget dolor."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cum sociis natoque penatibus et magnis dis parturient montes."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ultricies nisi vel augue."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ullamcorper ultricies nisi."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eget dui."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas tempus, tellus eget condimentum rhoncus."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque rutrum."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean imperdiet."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus."),
    MyMessage("Hola Guapa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus viverra nulla ut metus varius laoreet."),)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeTheme() {
                MyMessages(messages)
            }

        }
    }
}

data class MyMessage(val title: String, val body: String)

@Composable
fun MyMessages(messages: List<MyMessage>){
    LazyColumn {
        items(messages) { message ->
            MyComponent(message)
        }
    }
}

@Composable
fun MyComponent(mesage: MyMessage){
    //metes las cosas de izquierda a derecha
    Row(modifier = Modifier.padding(8.dp).background(MaterialTheme.colorScheme.background)){
        MyImage()
        MyTexts(mesage)
    }
}

@Composable
fun MyImage(){
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        "Mi iimagen de prueba",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun MyTexts(message: MyMessage){
    //forma de declarar una variable que puede cambiar en un metodo composable
    var expanded by remember { mutableStateOf(false) }

    //metes las cosas de arriba a bajo
    Column(modifier = Modifier.padding(start = 8.dp).clickable{
        expanded = !expanded
        println("Clickaste")
    }) {
        MyText(
            message.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.titleMedium

        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            message.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleSmall,
            if(expanded) Int.MAX_VALUE else 1


        )
    }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE){
        Text(text, color = color, style = style, maxLines = lines)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent(){
    JetpackComposeTheme() {
        MyMessages(messages)

    }

}