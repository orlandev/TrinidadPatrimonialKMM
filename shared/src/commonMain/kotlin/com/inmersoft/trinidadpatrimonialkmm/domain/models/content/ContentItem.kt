package com.inmersoft.trinidadpatrimonialkmm.domain.models.content

import com.inmersoft.trinidadpatrimonialkmm.domain.models.ImageBlur
import com.inmersoft.trinidadpatrimonialkmm.domain.models.events.EventModel
import com.inmersoft.trinidadpatrimonialkmm.domain.models.news.NewsModel
import kotlinx.serialization.Serializable

@Serializable
data class ContentItem(
    val title: String,
    val subtitle: String,
    val headerImage: ImageBlur,
    val content: List<Content>,
    val date: Long,
    val id: Int,
    val startDate: Long = 0,
    val endDate: Long = 0,
    val location: String = ""  //LocalName/234234-23424 -> GPS
)

fun ContentItem.toNewsModel(): NewsModel {
    return NewsModel(
        newsId = id,
        content = content,
        headerImage = headerImage,
        date = date,
        subtitle = subtitle,
        title = title
    )
}

fun ContentItem.toEventModel(): EventModel {
    return EventModel(
        eventId = id,
        content = content,
        headerImage = headerImage,
        date = date,
        subtitle = subtitle,
        title = title,
        start = startDate,
        end = endDate,
        location = location
    )
}