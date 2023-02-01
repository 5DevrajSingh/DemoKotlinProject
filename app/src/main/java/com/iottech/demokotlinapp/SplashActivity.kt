package com.iottech.demokotlinapp

import android.Manifest
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager



class SplashActivity : AppCompatActivity() {

    val PREFS_NAME = "Incident Management"
    var usernumber = ""
    var token = ""
    var sharedPreferences : SharedPreferences?=null
    override fun onCreate(savedInstanceState: Bundle?) {

            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.statusBarColor)
            window.navigationBarColor = this.resources.getColor(R.color.statusBarColor)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Constant.sharedPreferences = getSharedPreferences(Constant.sp_name, MODE_PRIVATE)
        Constant.editor = Constant.sharedPreferences.edit()
        token = Constant.sharedPreferences.getString(Constant.keys.TOKEN,"")!!
        println("userNumber   "+token)

        storagePermission()
    }


    private fun storagePermission(): Boolean {

        val readExternal = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        val writeExternal = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val internet = ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
        val send_Sms = ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
        val readContacts = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
        val writeContacts = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_CONTACTS)

        val permList = ArrayList<String>()

        if (readExternal != PackageManager.PERMISSION_GRANTED) {
            permList.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        if (writeExternal != PackageManager.PERMISSION_GRANTED) {
            permList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (internet != PackageManager.PERMISSION_GRANTED) {
            permList.add(Manifest.permission.INTERNET)
        }
        if (send_Sms != PackageManager.PERMISSION_GRANTED) {
            permList.add(Manifest.permission.SEND_SMS)
        }
        if (readContacts != PackageManager.PERMISSION_GRANTED) {
            permList.add(Manifest.permission.READ_CONTACTS)
        }
        if (writeContacts != PackageManager.PERMISSION_GRANTED) {
            permList.add(Manifest.permission.WRITE_CONTACTS)
        }
        if (permList.isNotEmpty()) {
            ActivityCompat.requestPermissions(this@SplashActivity, permList.toTypedArray(), 111)
            return false
        } else {
            goAhead()
        }
        return true
    }
    private fun goAhead() {
//        if (!Internet.isNetAvailable(applicationContext)){
//            val dialog = AlertDialog.Builder(this)
//            dialog.setTitle("Internet Not Found!")
//            dialog.setMessage("\nPlease check your internet connection?")
//            dialog.setIcon(R.drawable.no_internet)
//            dialog.setPositiveButton(" OK "){dialogInterface , which ->
//                finish()
//            }
//
//            val alertDialog: AlertDialog = dialog.create()
//            alertDialog.setCancelable(false)
//            alertDialog.show()
//        }else{
//            Handler(Looper.getMainLooper()).postDelayed({
//                if (token.isNotEmpty()){
//                    val intent = Intent(applicationContext,MainActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                }else{
//                    val intent = Intent(applicationContext,LoginActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                }
//            }, 3000)
//        }
        Handler(Looper.getMainLooper()).postDelayed({
            if (token.isNotEmpty()){
                val intent = Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)


    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 111) {
            run {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    goAhead()
                } else {
                    goAhead()
                }
            }
        }
    }
}