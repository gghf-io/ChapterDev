package io.gghf.chapterdev.di

import io.gghf.core.client.Client
import io.gghf.chapterdev.screen.add.AddViewModel
import io.gghf.chapterdev.screen.list.ListViewModel
import io.gghf.todo.TodoRepository
import io.gghf.todo.TodoRepositoryImpl
import io.gghf.todo.datasources.remote.TodoRemoteDataSource
import io.gghf.todo.datasources.remote.TodoRemoteDataSourceImpl
import io.gghf.todo.datasources.remote.TodoRemoteService
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<TodoRemoteDataSource> { TodoRemoteDataSourceImpl(Dispatchers.IO, Client.createService(TodoRemoteService::class)) }
    single<TodoRepository> {  TodoRepositoryImpl(get()) }
    viewModel { AddViewModel(get()) }
    viewModel { ListViewModel(get()) }
}