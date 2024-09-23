package com.furkancolak.sayitahminuygulamasi

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random


@Composable
fun TahminEkrani(navController: NavController){
    Column(modifier = Modifier.fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly){
        val tahmin = remember {
            mutableStateOf("")
        }
        val rastgeleSayi = remember {
            mutableStateOf(0)
        }
        val kalanHak = remember {
            mutableStateOf(5)
        }
        val yonlendirme = remember {
            mutableStateOf(" ")
        }
        LaunchedEffect(key1 = true) {
            // sayfa açıldığı anda bir defa çalışır
            rastgeleSayi.value = Random.nextInt(101)// 0-100 arasi
            Log.e("Rastgele Sayi ",rastgeleSayi.value.toString())
        }
        Text(text = "Kalan Hak :  ${kalanHak.value}", fontSize = 36.sp, color = Color.Blue)
        Text(text = "Yardım : ${yonlendirme.value}", fontSize = 24.sp, color = Color.Black)
        TextField(value = tahmin.value, onValueChange ={tahmin.value = it}, label = { Text(text = "Tahmin")} )
        //Image(painter = painterResource(id = R.drawable.zar_resim), contentDescription = "")
        Button(onClick = {
            kalanHak.value--
            if(rastgeleSayi.value == tahmin.value.toInt()){
                navController.navigate("SonucEkrani/true"){
                    popUpTo("TahminEkrani"){inclusive = true}
                }
                return@Button
            }else{
                if(kalanHak.value ==0){
                    navController.navigate("SonucEkrani/false"){
                        popUpTo("TahminEkrani"){inclusive = true}
                    }
                }
                if(tahmin.value.toInt() > rastgeleSayi.value){
                    yonlendirme.value = "Azalt"
                }
                if(tahmin.value.toInt() < rastgeleSayi.value){
                    yonlendirme.value = "Arttır"
                }
            }
            tahmin.value=""
        }, modifier = Modifier.size(130.dp)) {
            Text(text = "Tahmin et ")
        }


    }
}
