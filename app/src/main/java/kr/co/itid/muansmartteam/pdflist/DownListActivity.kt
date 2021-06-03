package kr.co.itid.muansmartteam.pdflist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kr.co.itid.muansmartteam.R
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


/**
 * download 받은 파일 목록 및 안받은 파일 체크
 * 다운로드 받을 수 있는 기능
 */
class DownListActivity : AppCompatActivity() {

    lateinit var downAdapter: DownAdapter
    val datas = mutableListOf<PdfFileData>()
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss")
    val DateTime: String  = LocalDateTime.now().format(formatter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        initView()
    }

    private fun initView() {
        downAdapter = DownAdapter(this)
        findViewById<RecyclerView>(R.id.rv_pdf).adapter = downAdapter

        datas.apply {
            add (PdfFileData("filename1", "url1", true, DateTime))
            add (PdfFileData("filename2", "url2", true, DateTime))
            add (PdfFileData("filename3", "url3", true, DateTime))
            add (PdfFileData("filename4", "url4", true, DateTime))

            downAdapter.datas = datas
            downAdapter.notifyDataSetChanged()
        }

    }
}