package com.inmersoft.trinidadpatrimonialkmm.domain.models.account

import kotlinx.serialization.Serializable


@Serializable
data class AccountDTO(
    val id: String,
    val fullName: String = "",
    val userName: String = "",
    val phoneNumber: String = "",
    val email: String,
    val avatarUrl: String = ""
) {
    fun isValid() = id.isNotEmpty() && email.isNotEmpty()
}
