package io.gghf.todo.datasources.remote

import be.rtbf.core.httpclient.ClientError
import be.rtbf.core.httpclient.call
import io.gghf.core.client.Client
import io.gghf.core.client.ServiceResult
import io.gghf.todo.datasources.remote.entities.Todo
import io.gghf.todo.datasources.remote.mock.listTodos
import kotlinx.coroutines.CoroutineDispatcher

class TodoRemoteDataSourceImpl(
    private val dispatcher: CoroutineDispatcher,
) : TodoRemoteDataSource {

    private val service = Client.createService(TodoRemoteService::class)

    override suspend fun getTodos(): ServiceResult<List<Todo>, ClientError> = call(dispatcher) { listTodos }

    override suspend fun getTodo(id: Long): ServiceResult<Todo, ClientError> =
        call(dispatcher) { service.getTodo(id) }

    override suspend fun addTodo(todo: Todo): ServiceResult<Boolean, ClientError> =
        call(dispatcher) { service.addTodo(todo) }

    override suspend fun removeTodo(todo: Todo): ServiceResult<Boolean, ClientError> =
        call(dispatcher) { service.removeTodo(todo) }

    override suspend fun updateTodo(todo: Todo): ServiceResult<Boolean, ClientError> =
        call(dispatcher) { service.updateTodo(todo) }

}