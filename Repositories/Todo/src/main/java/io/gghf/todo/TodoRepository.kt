package io.gghf.todo

import io.gghf.todo.datasources.remote.entities.Todo

interface TodoRepository {
    suspend fun getTodos() : List<Todo>
    suspend fun getTodo(id: Long) : Todo?
    suspend fun addTodo(todo: Todo) : Boolean
    suspend fun removeTodo(todo: Todo) : Boolean
    suspend fun updateTodo(todo: Todo) : Boolean
}