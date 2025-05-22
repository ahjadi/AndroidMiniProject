package com.example.androidminiproject.compasables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidminiproject.R
import com.example.androidminiproject.models.Branch


@Composable
fun BranchCard(branch: Branch, modifier: Modifier = Modifier) {

    Card() {

        Column {
            Image(
                painter = painterResource(branch.imageUri ?: R.drawable.virtual01),
                contentDescription = "Branch Icon",
                        modifier = Modifier
                        .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text("Branch Number: ${branch.id}")
            Spacer(modifier = modifier.height(4.dp))
            Text("Branch Name: ${branch.name}")
            Spacer(modifier = modifier.height(4.dp))
            Text("Type: ${branch.type}")
            Spacer(modifier = modifier.height(4.dp))
            Text("address: ${branch.address}")
            Spacer(modifier = modifier.height(4.dp))
            Text("Phone: ${branch.phone}")
            Spacer(modifier = modifier.height(4.dp))
            Text("Working Hours: ${branch.hours}")
            Spacer(modifier = modifier.height(4.dp))
            Text("Google maps: ${branch.locationURL}")
            Spacer(modifier = modifier.height(4.dp))
        }
    }
}