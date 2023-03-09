package io.gghf.featuretodo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.gghf.todo.TodoRepository
import io.gghf.todo.datasources.remote.entities.Todo
import kotlinx.coroutines.runBlocking

class TodoListViewModel(private val todoRepository: TodoRepository) : ViewModel() {

    private var _todos = MutableLiveData<List<Todo>>()
    val todos: LiveData<List<Todo>>
        get() = _todos

    init {
        runBlocking {
            getTodos()
        }
    }

    private suspend fun getTodos() {
        _todos.value = todoRepository.getTodos()
    }
}