package com.furkancolak.sayitahminuygulamasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.furkancolak.sayitahminuygulamasi.ui.theme.SayiTahminUygulamasiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SayiTahminUygulamasiTheme {
                SayfaGecisleri()
            }
        }
    }
}
@Composable
fun SayfaGecisleri(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable("MainScreen") {
            MainScreen(navController = navController)
        }
        composable("TahminEkrani") {
            TahminEkrani(navController = navController)
        }
        composable("SonucEkrani/{sonuc}", arguments = listOf(
            navArgument("sonuc"){type = NavType.BoolType}
        )) {
            val sonuc = it.arguments?.getBoolean("sonuc")!!
            SonucEkrani(sonuc = sonuc)
        }
    }
}

@Composable
fun MainScreen(navController: NavController){

    Column(modifier = Modifier.fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly){
        Text(text = "Tahmin oyunu", fontSize = 36.sp)
        Image(painter = painterResource(id = R.drawable.zar_resim), contentDescription = "")
        Button(onClick = {
            navController.navigate("TahminEkrani")
        }, modifier = Modifier.size(130.dp)) {
            Text(text = "Oyuna Başla")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SayiTahminUygulamasiTheme {

    }
}