package com.dogukanincee.eventbus_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * The ViewModel class that manages the message data.
 */
class MessageViewModel : ViewModel() {

    private val _messageLiveData = MutableLiveData<String>()
    val messageLiveData: LiveData<String> = _messageLiveData

    /**
     * Registers this ViewModel as an EventBus subscriber when created.
     */
    init {
        EventBus.getDefault().register(this)
    }

    /**
     * Unregisters this ViewModel as an EventBus subscriber when destroyed.
     */
    override fun onCleared() {
        super.onCleared()
        EventBus.getDefault().unregister(this)
    }

    /**
     * Posts a message to the EventBus.
     *
     * @param message the message to be posted.
     */
    fun postMessage(message: String) {
        val event = MessageEvent(message)
        EventBus.getDefault().post(event)
    }

    /**
     * Receives and updates the message data from the EventBus.
     *
     * @param event the received MessageEvent.
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent) {
        _messageLiveData.value = event.message
    }

    /**
     * Updates the message data with a new message.
     *
     * @param message the new message.
     */
    fun updateMessage(message: String) {
        _messageLiveData.value = message
    }
}