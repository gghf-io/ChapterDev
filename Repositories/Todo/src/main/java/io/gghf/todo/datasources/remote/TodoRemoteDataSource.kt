package io.gghf.todo.datasources.remote

import be.rtbf.core.httpclient.ClientError
import io.gghf.core.client.ServiceResult
import io.gghf.todo.datasources.remote.entities.Todo

interface TodoRemoteDataSource {
    suspend fun getTodos() : ServiceResult<List<Todo>, ClientError>
    suspend fun getTodo(id: Long) : ServiceResult<Todo, ClientError>
    suspend fun addTodo(todo: Todo) : ServiceResult<Boolean, ClientError>
    suspend fun removeTodo(todo: Todo) : ServiceResult<Boolean, ClientError>
    suspend fun updateTodo(todo: Todo) : ServiceResult<Boolean, ClientError>
}