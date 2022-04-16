package com.inmersoft.trinidadpatrimonialkmm.data.local

import com.inmersoft.trinidadpatrimonialkmm.TrinidadDb
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(TrinidadDb.Schema, "trinidad_database.db")
    }
}