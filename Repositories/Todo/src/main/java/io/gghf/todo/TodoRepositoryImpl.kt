package io.gghf.todo

import io.gghf.core.client.ServiceResult
import io.gghf.todo.datasources.remote.TodoRemoteDataSource
import io.gghf.todo.datasources.remote.entities.Todo

class TodoRepositoryImpl(private val todoRemoteDataSource: TodoRemoteDataSource) : TodoRepository {

    override suspend fun getTodos(): List<Todo> =
        when (val result = todoRemoteDataSource.getTodos()) {
            is ServiceResult.Success -> result.success
            is ServiceResult.Failure -> emptyList()
        }

    override suspend fun getTodo(id: Long): Todo? =
        when (val result = todoRemoteDataSource.getTodo(id)) {
            is ServiceResult.Success -> result.success
            is ServiceResult.Failure -> null
        }

    override suspend fun addTodo(todo: Todo): Boolean =
        when (val result = todoRemoteDataSource.addTodo(todo)) {
            is ServiceResult.Success -> result.success
            is ServiceResult.Failure -> false
        }

    override suspend fun removeTodo(todo: Todo): Boolean =
        when (val result = todoRemoteDataSource.removeTodo(todo)) {
            is ServiceResult.Success -> result.success
            is ServiceResult.Failure -> false
        }

    override suspend fun updateTodo(todo: Todo): Boolean =
        when (val result = todoRemoteDataSource.updateTodo(todo)) {
            is ServiceResult.Success -> result.success
            is ServiceResult.Failure -> false
        }
}