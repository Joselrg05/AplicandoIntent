package com.xpressnic.aplicandointent

import android.app.Activity
import android.content.Intent
import android.net.Uri

class IntenManager {

    fun navigateToUrl(activity: Activity, url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        activity.startActivity(intent)
    }

    fun share(activity: Activity, linkShare: String, titleShare: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, titleShare)
        intent.putExtra(Intent.EXTRA_TEXT, linkShare)
        activity.startActivity(Intent.createChooser(intent, "Compartir"))
    }

    fun sendEmail(activity: Activity, address: String, subject: String = "", body: String = "") {
        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = Uri.parse("mailto:$address")
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        emailIntent.putExtra(Intent.EXTRA_TEXT, body)
        activity.startActivity(Intent.createChooser(emailIntent, "Enviar correo"))
    }

    fun callPhoneNumber(activity: Activity, phone: String) {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$phone")
        activity.startActivity(callIntent)
    }

    fun openMap(activity: Activity, latitude: Double, longitude: Double, label: String = "") {
        val gmmIntentUri = Uri.parse("geo:$latitude,$longitude?q=$label")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        activity.startActivity(mapIntent)
    }

    fun sendSms(activity: Activity, phoneNumber: String, message: String = "") {
        val smsIntent = Intent(Intent.ACTION_SENDTO)
        smsIntent.data = Uri.parse("smsto:$phoneNumber")
        smsIntent.putExtra("sms_body", message)
        activity.startActivity(smsIntent)
    }
}