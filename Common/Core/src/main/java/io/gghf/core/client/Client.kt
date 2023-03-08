package io.gghf.core.client

import io.gghf.core.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

object Client {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    const val ApiVersion = "1"
    fun <T : Any> createService(service: KClass<T>): T = retrofit.create(service.java)

    object PathKey {
        const val Id = "id"
    }
}
