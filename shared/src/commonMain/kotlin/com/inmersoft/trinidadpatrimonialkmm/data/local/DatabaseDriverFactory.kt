package com.inmersoft.trinidadpatrimonialkmm.data.local

import com.inmersoft.trinidadpatrimonialkmm.TrinidadDb
import com.squareup.sqldelight.db.SqlDriver

fun createDatabase(databaseDriverFactory: DatabaseDriverFactory): TrinidadDb {
    val driver = databaseDriverFactory.createDriver()
    return TrinidadDb(driver)
}

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}