package com.ayaanjaved.chrono

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import java.util.concurrent.TimeUnit

@Composable
fun PomodoroScreen(navController: NavController) {
    val TAG = "PomodoroScreen"

    var timerValue by remember { mutableLongStateOf(0) }
    Log.d(TAG, "PomodoroScreen: Recomposed. Timer Value = $timerValue")

    val countDownTimer = object : CountDownTimer(minutesToMillis(25), 1000) {
        override fun onTick(millisUntilFinished: Long) {
            timerValue = millisUntilFinished
        }

        override fun onFinish() {
            Log.d("PomodoroScreen", "onFinish called")
        }
    }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
        val minutesRemaining = millisToMinutes(timerValue)
        val secondsRemaining = millisToSeconds(timerValue)

        Text(text = "$minutesRemaining")
        Text(text = "$secondsRemaining")

        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Button(onClick = {
                countDownTimer.start()
                Log.d("PomodoroScreen", "Start button clicked")
            }, content = {
                Text(text = "Start")
            })

            Button(onClick = {}, content = {
                Text(text = "Abort")
            })
        }
    }
}

fun minutesToMillis(minutes: Long): Long {
    return minutes * 60 * 1000
}

fun millisToMinutes(millis: Long): Long {
    return TimeUnit.MILLISECONDS.toMinutes(millis)
}
fun millisToSeconds(millis: Long): Long {
    return TimeUnit.MILLISECONDS.toSeconds(millis) -
            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
}