package com.ayaanjaved.chrono.domain

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PomodoroManager(private val chronoCountDownTimer: ChronoCountDownTimer) {
    private val sessionDuration = Constants.DEFAULT_SESSION_DURATION_MILLIS

    private val _onTickValue = MutableStateFlow(sessionDuration)
    val onTickValue = _onTickValue.asStateFlow()

    fun startTimer() {
        chronoCountDownTimer.startTimer(sessionDuration,
            onTick = {
                _onTickValue.value = it
            }
        )
    }

    fun stopTimer() {
        chronoCountDownTimer.stopTimer()
        _onTickValue.value = sessionDuration
    }

    fun setSession() {

    }
}