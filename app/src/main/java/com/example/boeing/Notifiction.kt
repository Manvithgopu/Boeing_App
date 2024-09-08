package com.example.boeing

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.boeing.databinding.ActivityDockerBinding
import com.example.boeing.databinding.ActivityNotifictionBinding

class Notifiction : AppCompatActivity() {

    lateinit var binding: ActivityNotifictionBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNotifictionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences=this.getSharedPreferences("App",0)
        editor=sharedPreferences.edit()
        binding.textView2.text="Hi "+sharedPreferences.getString("name","")+" !"

        var oft=sharedPreferences.getString("Oft","").toString()
        var dft=sharedPreferences.getString("Dft","").toString()
        var omt=sharedPreferences.getString("Omt","").toString()
        var dmt=sharedPreferences.getString("Dmt","").toString()

        var fa=Integer.parseInt(oft[0].toString())
        var fb=Integer.parseInt(oft[2].toString())
        var fc=Integer.parseInt(dft)

        var ma=Integer.parseInt(omt[0].toString())
        var mb=Integer.parseInt(omt[2].toString())
        var mc=Integer.parseInt(dmt)

        var oot=sharedPreferences.getString("Oot","").toString()
        var et=sharedPreferences.getString("Det","").toString()
        var ct=sharedPreferences.getString("Dct","").toString()
        var sst=sharedPreferences.getString("Oost","").toString()

        var d=Integer.parseInt(ct.subSequence(3,ct.length).toString())-Integer.parseInt(et.subSequence(3,et.length).toString())
        var ot=Integer.parseInt(oot)
        var st=Integer.parseInt(sst)

        var s=""
        Log.d("123456",fa.toString()+"/"+fb.toString()+"/"+fc.toString()+"/"+ma.toString()+"/"+mb.toString()+"/"+mc.toString()+"/"+ot.toString()+" "+st.toString()+"/"+d.toString())
        if(fc<fa||fc>fb)
        {
            s+=" -- Temperature of Freezer has been deviated.\n    Do check !\n\n\n"
        }
        if(mc<ma||mc>mb)
        {
            s+=" -- Temperature of Material has been deviated.\n    Do check !\n\n\n"
        }
        if(ot<d)
        {
            var a=(st*ot)/d
            s+=" -- Time limit has been crossed.\n    Do check !\n"
            s+="    Recalculated Shelf Time : "+a.toString()+" days"
        }
        binding.not.setText(s)
    }
}