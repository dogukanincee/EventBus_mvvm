package com.dogukanincee.eventbus_mvvm

import org.junit.Test
import org.junit.Assert.*

class MessageEventTest {

    @Test
    fun testMessageEvent() {
        val message = "Hello, world!"
        val event = MessageEvent(message)
        assertEquals(message, event.message)
    }
}