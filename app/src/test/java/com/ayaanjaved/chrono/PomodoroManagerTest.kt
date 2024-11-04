package com.ayaanjaved.chrono

import com.ayaanjaved.chrono.domain.ChronoCountDownTimer
import com.ayaanjaved.chrono.domain.Constants
import org.junit.Test

import com.ayaanjaved.chrono.domain.PomodoroManager
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.Before

class PomodoroManagerTest {
    private lateinit var mockChronoCountDownTimer: MockChronoCountDownTimer
    private lateinit var pomodoroManager: PomodoroManager

    @Before
    fun init() {
        mockChronoCountDownTimer = MockChronoCountDownTimer()
        pomodoroManager = PomodoroManager(mockChronoCountDownTimer)
    }

    @Test
    fun value_updates_when_timer_starts() {
        assertEquals(Constants.DEFAULT_SESSION_DURATION_MILLIS, pomodoroManager.onTickValue.value)

        pomodoroManager.startTimer()
        Thread.sleep(2000)

        assertTrue(pomodoroManager.onTickValue.value < Constants.DEFAULT_SESSION_DURATION_MILLIS)
    }

    @Test
    fun stopTimer_onRunningTimer_resetsState() {
        pomodoroManager.startTimer()
        Thread.sleep(2000)

        pomodoroManager.stopTimer()
        assertEquals(Constants.DEFAULT_SESSION_DURATION_MILLIS, pomodoroManager.onTickValue.value)
    }
}

class MockChronoCountDownTimer : ChronoCountDownTimer {
    private var isRunning: Boolean = false

    override fun startTimer(millisInFuture: Long, onTick: (millisUntilFinished: Long) -> Unit) {
        isRunning = true
        var millisUntilFinished = millisInFuture

        CoroutineScope(Dispatchers.Default).launch {
            while (isRunning && millisUntilFinished > 0) {
                delay(1000)
                millisUntilFinished -= 1000
                onTick(millisUntilFinished)
            }
            stopTimer()
        }
    }

    override fun stopTimer() {
        isRunning = false
    }
}