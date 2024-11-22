package com.example.navigasiwithdata.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigasiwithdata.R
import com.example.navigasiwithdata.data.MataKuliah
import com.example.navigasiwithdata.data.RuangKelas
import com.example.navigasiwithdata.model.Mahasiswa
import com.example.navigasiwithdata.model.RencanaStudy
import com.example.navigasiwithdata.ui.widget.DynamicSelectedTextField

@Composable
fun DetailMahasiswa(
    mahasiswa: Mahasiswa,
    rencanaStudy: RencanaStudy,
    onBackButtonClicked: () -> Unit
) {
    val listData = listOf(
        Pair("NIM", mahasiswa.nim),
        Pair("Nama", mahasiswa.nama),
        Pair("Email", mahasiswa.email),
        Pair("Nama MK", rencanaStudy.namaMK),
        Pair("Kelas", rencanaStudy.kelas),

        )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(
                    id = R.color.primary
                )
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logoumy),
                contentDescription = null,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(50.dp)

            )
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Column(modifier = Modifier.weight(1f)) {

                Text(
                    text = "Universitas Muhammadiyah Yogyakarta",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color.White
                )
                Text(
                    text = "Unggul dan Islami",
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topEnd = 15.dp,
                        topStart = 15.dp
                    )
                )
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Detail KRS Mahasiswa",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Column {
                    listData.forEach { item ->
                        CardSection(
                            judulParam = item.first,
                            isiParam = item.second
                        )
                    }
                }
                Button(
                    onClick = {
                        onBackButtonClicked()
                    },
                ) {
                    Text(text = "Kembali ke Halaman Utama")
                }
            }
        }
    }
}

@Composable
fun CardSection(judulParam: String, isiParam: String) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(top = 10.dp)
    ) {


        Row(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start

        ) {
            Text(
                text = judulParam, modifier = Modifier
                    .weight(0.8f)
                    .padding(start = 10.dp)
            )
            Text(
                text = ":", modifier = Modifier
                    .weight(0.2f)
                    .padding(start = 10.dp)
            )
            Text(
                text = isiParam, modifier = Modifier
                    .weight(2f)
                    .padding(start = 10.dp)
            )
        }
    }
}

