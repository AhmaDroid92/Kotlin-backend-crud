package com.ahmedroid.simpleCRUD.entity

import java.util.Date

data class SimpleErrorEntity(
    val errorMsg : String = "oops, houston we have a problem",
    val timestamp : String = Date().toInstant().toString(),
)