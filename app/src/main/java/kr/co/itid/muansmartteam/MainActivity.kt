package kr.co.itid.muansmartteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kr.co.itid.muansmartteam.pdflist.DownListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        

        
        findViewById<TextView>(R.id.txt_build).setText(SingleTone.getAndroidID(applicationContext))
        initLayout()
    }

    private fun initLayout(){

        findViewById<Button>(R.id.btn_web).setOnClickListener {

            val webIntent = Intent(this, WebActivity::class.java)
            startActivity(webIntent)

        }
        findViewById<Button>(R.id.btn_pdf).setOnClickListener {

            val PdfIntent = Intent(this, PdfViewActivity::class.java)
            startActivity(PdfIntent)

        }

        findViewById<Button>(R.id.btn_recycler).setOnClickListener {

            val ListIntent = Intent(this, DownListActivity::class.java)
            startActivity(ListIntent)

        }

        /*djdjdjdjdj*/
    }
}