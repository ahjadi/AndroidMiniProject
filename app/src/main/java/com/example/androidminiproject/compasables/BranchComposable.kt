package com.example.androidminiproject.compasables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.androidminiproject.R
import com.example.androidminiproject.models.Branch


@Composable
fun BranchDetails(
    branch: Branch,
    modifier: Modifier = Modifier,
    navController: NavHostController? = null,
    isFavorite: Boolean,
    onFavoriteSelected: () -> Unit,

    ) {

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
                    painter = painterResource(branch.imageUri ?: R.drawable.default_branch),
                    contentDescription = "Branch Photo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            branchInfoItems.dropLast(1).forEachIndexed { index, item ->
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

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val uriHandler = LocalUriHandler.current
                    ClickableText(
                        text = AnnotatedString("Open in Google Maps"),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.Blue,
                            textDecoration = TextDecoration.Underline
                        ),
                        onClick = {
                            uriHandler.openUri(branch.locationURL)
                        }
                    )

                    Button(
                        onClick = { onFavoriteSelected() },
                        enabled = !isFavorite,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp),
                        elevation = ButtonDefaults.buttonElevation(6.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor =
                            if (isFavorite) Color.Yellow else MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        if (isFavorite) {
                            Text("🌟 Favorite")
                        } else {
                            Text("Set as Favorite")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BranchCard(
    branch: Branch,
    modifier: Modifier = Modifier,
    navController: NavHostController? = null,
    isFavorite: Boolean,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController?.navigate("branchDetails/${branch.id}") },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (isFavorite) {
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("🌟", fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = branch.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = branch.address,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Working Hours",
                    tint = Color.Red,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = branch.hours,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Phone Number",
                    tint = Color.Blue,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = branch.phone,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun BranchList(
    branches: List<Branch>, modifier: Modifier = Modifier,
    navController: NavHostController? = null,
    favoriteBranchId: Int?,

    ) {

    LazyColumn(modifier) {
        items(branches) { branch ->
            BranchCard(
                branch = branch,
                isFavorite = branch.id == favoriteBranchId,
                navController = navController
            )
        }
    }
}