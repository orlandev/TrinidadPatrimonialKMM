package com.inmersoft.trinidadpatrimonialkmm.data.local

import com.inmersoft.trinidadpatrimonialkmm.TrinidadDb
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import org.koin.core.scope.Scope

internal actual fun Scope.createDriver(databaseName: String): SqlDriver =
    NativeSqliteDriver(TrinidadDb.Schema, databaseName)