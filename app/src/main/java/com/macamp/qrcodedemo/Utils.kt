package com.macamp.qrcodedemo

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.appcompat.app.AlertDialog

object Utils {

    fun permissionCompulsoryAlert(activity: Activity, string: String) {

        val builderAlert: AlertDialog.Builder = AlertDialog.Builder(activity)
        builderAlert.setTitle("Permission Access")
            .setMessage("You need to allow $string permissions for this app.")
            .setPositiveButton(
                "Open settings"
            ) { dialog: DialogInterface, _: Int ->
                // continue with delete
                val intent = Intent()
                intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                val uri =
                    Uri.fromParts("package", BuildConfig.APPLICATION_ID, null)
                intent.data = uri
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                activity.startActivity(intent)
                dialog.dismiss()
            }.setNegativeButton(
                "Cancel"
            ) { dialog: DialogInterface, _: Int -> dialog.dismiss() }.setCancelable(false).show()
    }

}