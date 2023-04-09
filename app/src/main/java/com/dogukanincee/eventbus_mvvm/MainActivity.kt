package com.dogukanincee.eventbus_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * The main activity that displays the message data and allows the user to post a new message.
 */
class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this)[MessageViewModel::class.java] }

    private lateinit var postButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postButton = findViewById(R.id.postButton)
        postButton.setOnClickListener {
            val message = "Hello, world!"
            val event = MessageEvent(message)
            EventBus.getDefault().post(event)
        }

        viewModel.messageLiveData.observe(this) { message ->
            val messageTextView = findViewById<TextView>(R.id.messageTextView)
            messageTextView.text = message
        }
    }

    /**
     * Registers this activity as an EventBus subscriber when started.
     */
    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    /**
     * Unregisters this activity as an EventBus subscriber when stopped.
     */
    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    /**
     * Receives a new message event from the EventBus and updates the message data in the ViewModel.
     *
     * @param event the received MessageEvent.
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent) {
        viewModel.updateMessage(event.message)
    }
}