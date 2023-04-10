package com.dogukanincee.eventbus_mvvm

import org.greenrobot.eventbus.EventBus
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MessageViewModelTest {

    private lateinit var viewModel: MessageViewModel

    @Before
    fun setup() {
        viewModel = MessageViewModel()
        EventBus.getDefault().unregister(viewModel)
        EventBus.getDefault().register(viewModel)
    }

    @After
    fun cleanup() {
        EventBus.getDefault().unregister(viewModel)
    }

    @Test
    fun testPostMessage() {
        val message = "Hello, world!"
        viewModel.postMessage(message)
        assertEquals(message, viewModel.messageLiveData.value)
    }

    @Test
    fun testOnMessageEvent() {
        val message = "Hello, world!"
        val event = MessageEvent(message)
        viewModel.onMessageEvent(event)
        assertEquals(message, viewModel.messageLiveData.value)
    }
}