package com.oji.weq.loglib

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.provider.Settings
import android.util.Log
import com.oji.weq.loglib.Lolly.Companion.hideLolly
import com.oji.weq.loglib.Lolly.Companion.isShowing
import com.oji.weq.loglib.Lolly.Companion.showLolly
import java.lang.Math.abs

object LogShower: BroadcastReceiver() {
    private var lastTime: Long = 0
    private var tags = arrayOf("")
    fun init(
        context: Context,
        tags: Array<String>
            ) {
        this.tags = tags
        val filter = IntentFilter()
        filter.addAction("android.media.VOLUME_CHANGED_ACTION");
        context.registerReceiver(this, filter);
    }

    override fun onReceive(
        context: Context?,
        intent: Intent?
                          ) {
        if (context == null) {
            return
        }

        if (intent?.action == "android.media.VOLUME_CHANGED_ACTION") {
            if (kotlin.math.abs(System.currentTimeMillis() - lastTime) < 2000) {
                return
            }
            lastTime = System.currentTimeMillis()
            Log.d("dadadad", "isShowing:$isShowing")
            if (isShowing) {
                hideLolly(context)
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (Settings.canDrawOverlays(context)) {
                        showLolly(context, tags)
                    }
                } else {
                    showLolly(context, tags)
                }
            }
        }
    }
}