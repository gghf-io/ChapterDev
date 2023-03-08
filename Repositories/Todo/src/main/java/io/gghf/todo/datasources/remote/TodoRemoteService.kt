package io.gghf.todo.datasources.remote

import io.gghf.core.client.Client
import io.gghf.todo.datasources.remote.entities.Todo
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TodoRemoteService {
    @GET("${Client.ApiVersion}/get/todo/list")
    suspend fun getTodos(): List<Todo>

    @GET("${Client.ApiVersion}/get/todo/{${Client.PathKey.Id}}")
    suspend fun getTodo(@Path(Client.PathKey.Id) id: Long): Todo

    @POST("${Client.ApiVersion}/add/todo")
    suspend fun addTodo(@Body todo: Todo): Boolean

    @DELETE("${Client.ApiVersion}/remove/todo")
    suspend fun removeTodo(@Body todo: Todo): Boolean

    @PUT("${Client.ApiVersion}/update/todo")
    suspend fun updateTodo(@Body todo: Todo): Boolean
}