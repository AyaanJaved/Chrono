package com.ayaanjaved.chrono.domain

interface ChronoCountDownTimer {
    fun startTimer(millisInFuture: Long, onTick: (millisUntilFinished: Long) -> Unit)
    fun stopTimer()
}