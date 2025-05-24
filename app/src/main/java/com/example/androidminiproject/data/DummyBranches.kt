package com.example.androidminiproject.data

import com.example.androidminiproject.R
import com.example.androidminiproject.models.Branch
import com.example.androidminiproject.models.BranchType

object DummyBranches {
    val dummyBranches = listOf(
        Branch(
            id = 0,
            name = "NBK Head Office",
            type = BranchType.PHYSICAL,
            address = "NBK Tower, Sharq, Kuwait City",
            phone = "1801801",
            hours = "8AM - 3PM",
            locationURL = "https://goo.gl/maps/nbkhead",
            imageUri = R.drawable.nbk_tower
        ),
        Branch(
            id = 1,
            name = "Weyay Digital Branch",
            type = BranchType.VIRTUAL,
            address = "Online Only - Kuwait",
            phone = "1808010",
            hours = "24/7",
            locationURL = "https://weyaybank.com",
            imageUri = R.drawable.weyay
        ),
        Branch(
            id = 2,
            name = "NBK Marina Mall",
            type = BranchType.PHYSICAL,
            address = "Marina Mall, Salmiya, Kuwait",
            phone = "1801801",
            hours = "9AM - 5PM",
            locationURL = "https://goo.gl/maps/marinanbk",
            imageUri = R.drawable.indoor
        ),
        Branch(
            id = 3,
            name = "Weyay Gen-Z Hub",
            type = BranchType.VIRTUAL,
            address = "Online - Kuwait",
            phone = "1808010",
            hours = "24/7",
            locationURL = "https://weyaybank.com/genz",
            imageUri = R.drawable.weyay
        ),
        Branch(
            id = 4,
            name = "NBK Airport Branch",
            type = BranchType.PHYSICAL,
            address = "Kuwait International Airport, Farwaniya",
            phone = "1801804",
            hours = "Open 24 Hours",
            locationURL = "https://goo.gl/maps/nbkairport",
            imageUri = R.drawable.indoor
    ),
        Branch(
            id = 5,
            name = "NBK Jahra Branch",
            type = BranchType.PHYSICAL,
            address = "Block 4, Jahra, Kuwait",
            phone = "1888888",
            hours = "8AM - 2PM",
            locationURL = "https://goo.gl/maps/nbkjahra",
            imageUri = R.drawable.nbk_tower
        ),
        Branch(
            id = 6,
            name = "NBK Avenues Mall",
            type = BranchType.PHYSICAL,
            address = "The Avenues, Rai, Kuwait",
            phone = "1801802",
            hours = "10AM - 10PM",
            locationURL = "https://goo.gl/maps/nbkavenues",
            imageUri = R.drawable.indoor
        )
    )

}