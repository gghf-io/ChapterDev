package io.gghf.todo.datasources.remote.mock

import io.gghf.todo.datasources.remote.entities.Todo

val listTodos = listOf(
    Todo(
        id = 10001L,
        title = "Course",
        text = """
           * Sopalin
           * Saucissons
           * Fondue
        """
    ),
    Todo(
        id = 10002L,
        title = "Prepa - ChapterDev",
        text = """
           * 1er partie
           * 2e partie
           * 3e p... Non Pas du tout
        """
    ),
    Todo(
        id = 10003L,
        title = "Prepa - Strat",
        text = """
           * Soak boss
           * Split groupe
           * Dodge rayon
        """
    )
)