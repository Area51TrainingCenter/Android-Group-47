package com.area51.clasemvp.ui

interface Presenter<T> {
    fun agregarView(view: T)
    fun eliminarView()
}