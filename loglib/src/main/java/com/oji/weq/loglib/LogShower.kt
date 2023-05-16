package com.oji.weq.loglib

import android.app.Activity
import android.content.Context
import android.os.Build
import android.provider.Settings
import com.oji.weq.loglib.Lolly.Companion.showLolly

object LogShower {
    fun init(context:Activity,array: Array<String>){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.canDrawOverlays(context)) {
                showLolly(context, array)
            }
        } else {
            showLolly(context, array)
        }
    }
}