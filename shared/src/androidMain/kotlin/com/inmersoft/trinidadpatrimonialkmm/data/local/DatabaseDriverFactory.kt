package com.inmersoft.trinidadpatrimonialkmm.data.local

import com.inmersoft.trinidadpatrimonialkmm.TrinidadDb
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import org.koin.android.ext.koin.androidContext
import org.koin.core.scope.Scope

internal actual fun Scope.createDriver(databaseName: String): SqlDriver =
    AndroidSqliteDriver(
        TrinidadDb.Schema,
        androidContext(), databaseName
    )