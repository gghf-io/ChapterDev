package io.gghf.todo.datasources.remote.entities

import com.google.gson.annotations.SerializedName

data class Todo(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("text") val text: String
)
