package com.example.androidminiproject.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.androidminiproject.compasables.BranchDetails
import com.example.androidminiproject.compasables.BranchList
import com.example.androidminiproject.data.DummyBranches

@Composable
fun BranchNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "branchList",
) {
    var favoriteBranchId by rememberSaveable { mutableStateOf<Int?>(null) }


    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("branchList") {
            BranchList(
                DummyBranches.dummyBranches,
                favoriteBranchId = favoriteBranchId,
                navController = navController
            )
        }
        composable(
            route = "branchDetails/{branchId}",
            arguments = listOf(navArgument("branchId") { type = NavType.IntType })
        ) { backStackEntry ->
            val branchId = backStackEntry.arguments?.getInt("branchId") ?: 0
            val branch = DummyBranches.dummyBranches.firstOrNull { it.id == branchId }
            if (branch != null) {
                BranchDetails(
                    branch = branch,
                    navController = navController,
                    isFavorite = branch.id == favoriteBranchId,
                    onFavoriteSelected = { favoriteBranchId = branch.id },
                )
            } else {
                Text("Branch not found")
            }
        }
    }
}