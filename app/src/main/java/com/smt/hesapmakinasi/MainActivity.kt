package com.smt.hesapmakinasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun btnSayiTik(view:View){
        if (yeniOperator){
            plaintext.setText("")
        }
        yeniOperator = false


        val btnsec = view as Button // hangi butona tıklandı
        var btnTikDeger:String = plaintext.text.toString() //

        when(btnsec.id){
            btn0.id -> btnTikDeger += "0"
            btn1.id -> btnTikDeger += "1"
            btn2.id -> btnTikDeger += "2"
            btn3.id -> btnTikDeger += "3"
            btn4.id -> btnTikDeger += "4"
            btn5.id -> btnTikDeger += "5"
            btn6.id -> btnTikDeger += "6"
            btn7.id -> btnTikDeger += "7"
            btn8.id -> btnTikDeger += "8"
            btn9.id -> btnTikDeger += "9"
            btnNokta.id -> btnTikDeger+= "."
            btnArtiEksi.id-> btnTikDeger ="-"+btnTikDeger
        }
        plaintext.setText(btnTikDeger)
    }

    var operator = "*"
    var eskiSayi = ""
    var yeniOperator = true

    fun btnOpTik(view:View){

        val btnSec = view as Button

        when(btnSec.id){
            btnBolme.id->{
                operator = "/"
            }
            btnCarpma.id->{
                operator = "*"
            }
            btnFark.id->{
                operator = "-"
            }
            btnTopla.id->{
                operator = "+"
            }
            btnYuzde.id->{
                operator = "½"
            }
        }
        eskiSayi = plaintext.text.toString()
        yeniOperator = true
    }

    fun btnSonucTik(view: View){
        val yeniSayi = plaintext.text.toString()
        var sonuc: Double ?=null

        when(operator){
            "/" -> sonuc = eskiSayi.toDouble() / yeniSayi.toDouble()
            "+" -> sonuc = eskiSayi.toDouble() + yeniSayi.toDouble()
            "-" -> sonuc = eskiSayi.toDouble() - yeniSayi.toDouble()
            "*" -> sonuc = eskiSayi.toDouble() * yeniSayi.toDouble()
            "%" -> sonuc = eskiSayi.toDouble() / 100
        }
        plaintext.setText(sonuc.toString())
        yeniOperator = true
    }
    fun btnSilTik(view:View){
        plaintext.setText("")
    }

}