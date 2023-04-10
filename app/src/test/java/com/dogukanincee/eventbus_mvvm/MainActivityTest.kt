package com.dogukanincee.eventbus_mvvm

import android.os.Build
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.greenrobot.eventbus.EventBus
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode
import org.robolectric.shadows.ShadowLooper

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
@LooperMode(LooperMode.Mode.PAUSED)
class MainActivityTest {

    private lateinit var activityScenario: ActivityScenario<MainActivity>
    private lateinit var activity: MainActivity

    @Before
    fun setup() {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        activityScenario.onActivity { activity ->
            this.activity = activity
        }
    }

    @After
    fun cleanup() {
        EventBus.getDefault().unregister(activity)
        activityScenario.close()
    }

    @Test
    fun testOnCreate() {
        activityScenario.onActivity { activity ->
            assertNotNull(activity.findViewById(R.id.postButton))
            assertNotNull(activity.findViewById(R.id.messageTextView))
        }
    }

    @Test
    fun testOnStart() {
        EventBus.getDefault().register(activity)
        activityScenario.onActivity { activity ->
            activity.onStart()
        }
    }

    @Test
    fun testOnStop() {
        EventBus.getDefault().register(activity)
        activityScenario.onActivity { activity ->
            activity.onStop()
        }
    }

    @Test
    fun testOnMessageEvent() {
        val message = "Hello, world!"
        activityScenario.onActivity { activity ->
            activity.onMessageEvent(MessageEvent(message))
            ShadowLooper.runUiThreadTasksIncludingDelayedTasks()
            assertEquals(message, activity.findViewById<TextView>(R.id.messageTextView).text)
        }
    }
}