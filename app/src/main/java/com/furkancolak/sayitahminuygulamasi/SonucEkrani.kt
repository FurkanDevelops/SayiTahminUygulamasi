package com.furkancolak.sayitahminuygulamasi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SonucEkrani(sonuc : Boolean){
    Column(modifier = Modifier.fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly){

        if(sonuc){
            Text(text = "Kazandiniz")
            Image(painter = painterResource(id = R.drawable.mutlu_resim), contentDescription = "")

        }
        else{
            Text(text = "Kaybettiniz")
            Image(painter = painterResource(id = R.drawable.uzgun_resim), contentDescription = "")

        }

    }
}
