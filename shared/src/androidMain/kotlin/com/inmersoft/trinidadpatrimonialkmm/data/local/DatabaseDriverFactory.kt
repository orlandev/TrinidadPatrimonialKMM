package com.inmersoft.trinidadpatrimonialkmm.data.local

import android.content.Context
import com.inmersoft.trinidadpatrimonialkmm.TrinidadDb
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(TrinidadDb.Schema, context, "trinidad_database.db")
    }
}