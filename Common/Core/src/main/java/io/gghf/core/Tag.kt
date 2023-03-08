package io.gghf.core

object Tag {
    @JvmField
    val Log = LogObject
    object LogObject {
        const val Api = "Api"
    }

    @JvmField
    val Screen = ScreenObject
    object ScreenObject {
        const val Add = "add"
        const val List = "list"
    }
}