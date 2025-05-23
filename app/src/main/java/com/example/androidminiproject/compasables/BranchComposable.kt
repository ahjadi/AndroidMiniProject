package com.example.androidminiproject.compasables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidminiproject.R
import com.example.androidminiproject.models.Branch

@Composable
fun BranchCard(branch: Branch, modifier: Modifier = Modifier) {
    val branchInfoItems = listOf(
        "Branch Number: ${branch.id}",
        "Branch Name: ${branch.name}",
        "Type: ${branch.type}",
        "Address: ${branch.address}",
        "Phone: ${branch.phone}",
        "Working Hours: ${branch.hours}",
        "Google Maps: ${branch.locationURL}"
    )

    val alternatingColors = listOf(
        Color(0xFFF5F5F5),
        Color(0xFFE0E0E0)
    )

    Card(
        modifier = modifier
            .padding(12.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0EFF5))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFE0E0E0)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(branch.imageUri ?: R.drawable.resource_default),
                    contentDescription = "Branch Photo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            branchInfoItems.forEachIndexed { index, item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(alternatingColors[index % 2])
                        .padding(8.dp)
                ) {
                    Text(
                        text = item,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.DarkGray
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}