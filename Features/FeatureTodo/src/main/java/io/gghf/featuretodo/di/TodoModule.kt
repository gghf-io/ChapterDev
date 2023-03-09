package io.gghf.featuretodo.di

import io.gghf.featuretodo.TodoAddViewModel
import io.gghf.featuretodo.TodoListViewModel
import io.gghf.todo.TodoRepository
import io.gghf.todo.TodoRepositoryImpl
import io.gghf.todo.datasources.remote.TodoRemoteDataSource
import io.gghf.todo.datasources.remote.TodoRemoteDataSourceImpl
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val todoModule = module {
    single<TodoRemoteDataSource> { TodoRemoteDataSourceImpl(Dispatchers.IO) }
    single<TodoRepository> {  TodoRepositoryImpl(get()) }
    viewModel { TodoAddViewModel(get()) }
    viewModel { TodoListViewModel(get()) }
}