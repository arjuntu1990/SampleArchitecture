package com.arjuntu90.logic.util

import android.content.Context
import android.net.ConnectivityManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

open class NetworkUtils @Inject constructor(@ApplicationContext val context: Context) {
    open fun hasInternetConnection(): Boolean {
        val activeNetworkInfo =
            (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
                .activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }
}