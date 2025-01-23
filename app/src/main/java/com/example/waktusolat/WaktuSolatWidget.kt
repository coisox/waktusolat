// src/com/example/waktusolat/WaktuSolatWidget.kt
package com.example.waktusolat

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.*

class WaktuSolatWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateWidget(context, appWidgetManager, appWidgetId)
        }
    }

    private fun updateWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {
        val views = RemoteViews(context.packageName, R.layout.widget_layout)

        // Set current location (example)
        views.setTextViewText(R.id.locationText, "Kuala Lumpur")

        // Set current date (Georgian and Islamic)
        val georgianDate = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Date())
        val islamicDate = "1 Muharram 1445" // Replace with actual Hijri date calculation
        views.setTextViewText(R.id.dateText, "$georgianDate | $islamicDate")

        // Set prayer times (example)
        val prayerTimes = "IMSAK 5:30 | SUBUH 5:45 | SHURUK 7:00 | ZOHOR 1:00 | ASAR 4:30 | MAGRIB 7:00 | ISYA 8:15"
        views.setTextViewText(R.id.prayerTimesText, prayerTimes)

        // Update widget
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
}