package com.geromino_apps.presentation.common.views

interface ObservableViewMVC<ListenerType> : ViewMvc {

    fun registerListener(listener: ListenerType)
    fun unRegisterListeners(listener: ListenerType)
}