package com.inmersoft.trinidadpatrimonialkmm.data.local

import com.inmersoft.trinidadpatrimonialkmm.TrinidadDb
import com.inmersoft.trinidadpatrimonialkmm.domain.models.ImageBlur
import com.inmersoft.trinidadpatrimonialkmm.domain.models.Place
import com.inmersoft.trinidadpatrimonialkmm.domain.models.PlaceType
import com.inmersoft.trinidadpatrimonialkmm.domain.models.Route
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.Content
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.TextContent
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class TrinidadLocalDataSource(private val trinidadDb: TrinidadDb) {

    //PLACES CRUD

    fun insertPlaces(list: List<Place>) {
        list.forEach { currentPlace ->
            trinidadDb.placeEntityQueries.insertPlace(
                id = currentPlace.id,
                name = currentPlace.name,
                description = currentPlace.description,
                headerImages = Json.encodeToString<List<ImageBlur>>(currentPlace.headerImages),
                location = currentPlace.location,
                model3d = currentPlace.model3d,
                stars = currentPlace.stars,
                comments = Json.encodeToString<List<String>>(currentPlace.comments),
                placeType = Json.encodeToString<List<Int>>(currentPlace.placeType),
                video = currentPlace.video,
                routes = Json.encodeToString<List<Int>>(currentPlace.routes),
                pano = currentPlace.pano,
                web = currentPlace.web,
                content = Json.encodeToString<List<Content>>(currentPlace.content),
            )
        }
    }

    fun getPlaceById(id: Long): Place {
        val currentPlace = trinidadDb.placeEntityQueries.getPlaceById(id = id).executeAsOne()

        return Place(
            id = currentPlace.id,
            name = currentPlace.name,
            description = currentPlace.description,
            headerImages = Json.decodeFromString(currentPlace.headerImages),
            location = currentPlace.location,
            model3d = currentPlace.model3d,
            stars = currentPlace.stars,
            comments = Json.decodeFromString(currentPlace.comments),
            placeType = Json.decodeFromString(currentPlace.placeType),
            video = currentPlace.video,
            routes = Json.decodeFromString(currentPlace.routes),
            pano = currentPlace.pano,
            web = currentPlace.web,
            content = Json.decodeFromString(currentPlace.content),
        )
    }

    fun getAllPlaces(): List<Place> {
        return trinidadDb.placeEntityQueries.getAllPlaces().executeAsList().map {
            Place(
                id = it.id,
                name = it.name,
                description = it.description,
                headerImages = Json.decodeFromString<List<ImageBlur>>(it.headerImages),
                location = it.location,
                model3d = it.model3d,
                stars = it.stars,
                comments = Json.decodeFromString<List<String>>(it.comments),
                placeType = Json.decodeFromString<List<Int>>(it.placeType),
                video = it.video,
                routes = Json.decodeFromString<List<Int>>(it.routes),
                pano = it.pano,
                web = it.web,
                content = Json.decodeFromString<List<Content>>(it.content),
            )
        }
    }

    //END PLACES CRUD


    //ROUTES CRUD


    fun insertRoutes(list: List<Route>) {
        list.forEach { currentRoute ->
            trinidadDb.routeEntityQueries.insertRoute(
                id = currentRoute.id,
                name = currentRoute.name,
                description = currentRoute.description,
                headerImages = Json.encodeToString<List<ImageBlur>>(currentRoute.headerImages),
                video = currentRoute.video,
                web = currentRoute.web,
                placesId = Json.encodeToString<List<Int>>(currentRoute.placesId)

            )
        }
    }

    fun getRouteById(id: Long): Route {
        val currentRoute = trinidadDb.routeEntityQueries.getRouteById(id = id).executeAsOne()
        return Route(
            id = currentRoute.id,
            name = currentRoute.name,
            description = currentRoute.description,
            headerImages = Json.decodeFromString(currentRoute.headerImages),
            video = currentRoute.video,
            web = currentRoute.web,
            placesId = Json.decodeFromString(currentRoute.placesId),
        )
    }

    fun getAllRoutes(): List<Route> {
        return trinidadDb.routeEntityQueries.getAllRoutes().executeAsList().map {
            Route(
                id = it.id,
                name = it.name,
                description = it.description,
                headerImages = Json.decodeFromString<List<ImageBlur>>(it.headerImages),
                video = it.video,
                web = it.web,
                placesId = Json.decodeFromString(it.placesId),
            )
        }
    }

    //END ROUTES CRUD


    //PLACE TYPE CRUD

    fun insertPlaceType(list: List<PlaceType>) {
        list.forEach { currentPlaceType ->
            trinidadDb.placeTypeEntityQueries.insertPlaceType(
                id = currentPlaceType.id,
                name = currentPlaceType.name,
                classification = currentPlaceType.classification,
                icon = currentPlaceType.icon
            )
        }
    }

    fun getPlaceTypeById(id: Long): PlaceType {
        val currentPlaceType =
            trinidadDb.placeTypeEntityQueries.getPlaceTypeById(id = id).executeAsOne()
        return PlaceType(
            id = currentPlaceType.id,
            name = currentPlaceType.name,
            classification = currentPlaceType.classification,
            icon = currentPlaceType.icon
        )
    }

    fun getAllPlaceType(): List<PlaceType> {
        return trinidadDb.placeTypeEntityQueries.getAllPlaceType().executeAsList()
            .map { currentPlaceType ->
                PlaceType(
                    id = currentPlaceType.id,
                    name = currentPlaceType.name,
                    classification = currentPlaceType.classification,
                    icon = currentPlaceType.icon
                )
            }
    }

    //END PLACE TYPE CRUD

    //TEXT CONTENT CRUD

    fun insertTextContent(list: List<TextContent>) {
        list.forEach { currentTextContent ->
            trinidadDb.textContentEntityQueries.insertTextContent(
                id = currentTextContent.id,
                content = Json.encodeToString(currentTextContent.content)
            )
        }
    }

    fun getAllTextContent(): List<TextContent> {
        return trinidadDb.textContentEntityQueries.getAllTextContent().executeAsList()
            .map { currentTextContent ->
                TextContent(
                    id = currentTextContent.id,
                    content = Json.decodeFromString(currentTextContent.content)
                )
            }
    }

    //END TEXT CONTENT CRUD

}

