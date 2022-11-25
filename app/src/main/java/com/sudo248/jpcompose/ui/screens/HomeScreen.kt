package com.sudo248.jpcompose.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.sudo248.jpcompose.R
import com.sudo248.jpcompose.User
import com.sudo248.jpcompose.ui.theme.contentStyle
import com.sudo248.jpcompose.ui.theme.descriptionStyle
import com.sudo248.jpcompose.ui.theme.titleStyle
import kotlin.random.Random


/**
 * **Created by**
 *
 * @author *Sudo248*
 * @since 00:56 - 24/11/2022
 */

@Composable
fun HomeScreen(navController: NavController) {

    val listUser = remember {
        mutableStateOf(getSampleData())
    }

    val ran = Random(5)

    val currentContext = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        ) {
            Text(
                text = stringResource(id = R.string.home), style = titleStyle(size = 32.sp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = "search icon",
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        Toast
                            .makeText(currentContext, "This is a Toast", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
        }

        LazyColumn(
            modifier = Modifier.padding(top = 15.dp).weight(1f)
        ) {
            items(listUser.value.size) { index ->
                ItemHome(
                    user = listUser.value[index],
                    onClick = { navController.navigate(Screen.DetailScreen.route + "/${Gson().toJson(listUser.value[index])}") })
            }
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { listUser.value = getSampleData(ran.nextInt(1000)) }
        ) {
            Text(text = "Update list (${listUser.value.size})")
        }
    }
}

@Composable
fun ItemHome(user: User, onClick: (User) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .clickable { onClick(user) }
    ) {
        Image(
            painter = painterResource(id = R.drawable.apero),
            contentDescription = "image apero",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp)
        ) {
            Text(text = "${user.id} ${user.name}", style = contentStyle())
            Text(text = user.description, style = descriptionStyle())
        }
    }
}

fun getSampleData(size: Int = 20) = List(size) {
    User(
        id = it,
        name = "Le Hong Duong",
        description = "Student in PTIT"
    )
}

@Preview(showBackground = true, device = Devices.PIXEL_3A_XL)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}

