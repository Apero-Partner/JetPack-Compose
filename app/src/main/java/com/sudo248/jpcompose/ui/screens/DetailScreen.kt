package com.sudo248.jpcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sudo248.jpcompose.R
import com.sudo248.jpcompose.User
import com.sudo248.jpcompose.ui.theme.contentStyle
import com.sudo248.jpcompose.ui.theme.descriptionStyle
import com.sudo248.jpcompose.ui.theme.titleStyle


/**
 * **Created by**
 *
 * @author *Sudo248*
 * @since 01:03 - 24/11/2022
 */

@Composable
fun DetailScreen(navController: NavController, user: User) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                contentDescription = "",
                modifier = Modifier
                    .padding(5.dp)
                    .clickable {
                    navController.popBackStack()
                }
            )
            Text(
                text = stringResource(id = R.string.detail),
                style = titleStyle(size = 32.sp),
                modifier = Modifier.padding(start = 20.dp)
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        Image(
            painter = painterResource(id = R.drawable.apero),
            contentDescription = "image apero",
            modifier = Modifier
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "${user.id} ${user.name}", style = contentStyle(size = 24.sp))
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = user.description, style = descriptionStyle(size = 18.sp))

    }
}

@Preview(showBackground = true, device = Devices.PIXEL_3A_XL)
@Composable
fun PreviewDetailScreen() {
    DetailScreen(navController = rememberNavController(), user = User(1, "Le Hong Duong", "PTIT"))
}

