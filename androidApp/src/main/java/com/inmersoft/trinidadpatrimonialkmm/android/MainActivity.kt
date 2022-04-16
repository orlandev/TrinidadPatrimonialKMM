package com.inmersoft.trinidadpatrimonialkmm.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import com.inmersoft.trinidadpatrimonialkmm.DispatcherProviderImpl
import com.inmersoft.trinidadpatrimonialkmm.android.ui.theme.TrinidadPatrimonialKMMTheme
import com.inmersoft.trinidadpatrimonialkmm.data.TrinidadRepositoryImpl
import com.inmersoft.trinidadpatrimonialkmm.data.local.DatabaseDriverFactory
import com.inmersoft.trinidadpatrimonialkmm.data.local.TrinidadLocalDataSource
import com.inmersoft.trinidadpatrimonialkmm.data.local.createDatabase
import com.inmersoft.trinidadpatrimonialkmm.data.remote.TrinidadApi
import com.inmersoft.trinidadpatrimonialkmm.data.remote.TrinidadRemoteDataSource
import com.inmersoft.trinidadpatrimonialkmm.domain.interceptors.GetPlaceInteractorImpl
import com.inmersoft.trinidadpatrimonialkmm.domain.interceptors.GetPlaceTypeDataInteractorImpl
import com.inmersoft.trinidadpatrimonialkmm.domain.interceptors.GetRoutesInteractorImpl
import com.inmersoft.trinidadpatrimonialkmm.domain.interceptors.GetTextContentDataInteractorImpl
import com.inmersoft.trinidadpatrimonialkmm.domain.models.Place
import com.inmersoft.trinidadpatrimonialkmm.domain.models.PlaceType
import com.inmersoft.trinidadpatrimonialkmm.domain.models.Route
import com.inmersoft.trinidadpatrimonialkmm.domain.models.content.TextContent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    val t = TrinidadRepositoryImpl(
        localDataSource = TrinidadLocalDataSource(createDatabase(DatabaseDriverFactory(this))),
        remoteDataSource = TrinidadRemoteDataSource(TrinidadApi()),
        dispatcherProvider = DispatcherProviderImpl()
    )

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            val scope = rememberCoroutineScope()

            val listPlaces = rememberSaveable {
                mutableStateOf<List<Place>>(emptyList())
            }

            val listRoutes = rememberSaveable {
                mutableStateOf<List<Route>>(emptyList())
            }

            val listPlacesType = rememberSaveable {
                mutableStateOf<List<PlaceType>>(emptyList())
            }

            val listTextContent = rememberSaveable {
                mutableStateOf<List<TextContent>>(emptyList())
            }

            LaunchedEffect(Unit) {

                scope.launch {
                    t.fetchAndCacheData(userLocale = "es")
                    val routes =
                        withContext(Dispatchers.IO) { GetRoutesInteractorImpl(t).execute() }
                    listRoutes.value = routes

                    val places = withContext(Dispatchers.IO) { GetPlaceInteractorImpl(t).execute() }
                    listPlaces.value = places


                    val placesType =
                        withContext(Dispatchers.IO) { GetPlaceTypeDataInteractorImpl(t).execute() }
                    listPlacesType.value = placesType


                    val text =
                        withContext(Dispatchers.IO) { GetTextContentDataInteractorImpl(t).execute() }
                    listTextContent.value = text
                }

            }

            TrinidadPatrimonialKMMTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {// Remember a SystemUiController

                    Box(modifier = Modifier.fillMaxSize().blur(
                        30.dp,
                        edgeTreatment = BlurredEdgeTreatment.Unbounded
                    ), contentAlignment = Alignment.Center) {
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            item {
                                Text(text = "PLACES")
                            }
                            items(listPlaces.value) { currentPlace ->
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                        .padding(8.dp)
                                ) {

                                    Column(modifier = Modifier.padding(8.dp)) {
                                        Text(text = currentPlace.name)
                                        Text(text = currentPlace.description)
                                        Text(text = currentPlace.web)
                                    }
                                }
                            }
                            item {
                                Text(text = "ROUTES")
                            }
                            items(listRoutes.value) { currentRoute ->
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                        .padding(8.dp)
                                ) {

                                    Column(modifier = Modifier.padding(8.dp)) {
                                        Text(text = currentRoute.name)
                                        Text(text = currentRoute.description)
                                        Text(text = currentRoute.web)
                                    }
                                }
                            }
                            item {
                                Text(text = "PLACES TYPE")
                            }
                            items(listPlacesType.value) { currentPlacesType ->
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                        .padding(8.dp)
                                ) {

                                    Column(modifier = Modifier.padding(8.dp)) {
                                        Text(text = currentPlacesType.name)
                                        Text(text = currentPlacesType.classification)
                                        Text(text = currentPlacesType.icon)
                                    }
                                }
                            }
                            item {
                                Text(text = "TEXT CONTENT")
                            }
                            items(listTextContent.value) { currentTextContent ->
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                        .padding(8.dp)
                                ) {

                                    Column(modifier = Modifier.padding(8.dp)) {
                                        Text(text = currentTextContent.id)
                                        Text(text = currentTextContent.content.size.toString() + " Contenidos")
                                        LazyRow(
                                            modifier = Modifier.fillMaxWidth(),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                                        ) {
                                            items(currentTextContent.content) { currentData ->
                                                Card(
                                                    modifier = Modifier
                                                        .height(100.dp)
                                                        .width(200.dp)
                                                        .padding(10.dp)
                                                ) {
                                                    Text(text = currentData.type)
                                                    Text(text = currentData.field)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
