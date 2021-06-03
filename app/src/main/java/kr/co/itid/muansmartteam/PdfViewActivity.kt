package kr.co.itid.muansmartteam

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.listener.OnErrorListener
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle


/**
 * library used - https://github.com/afreakyelf/Pdf-Viewer
 */
class PdfViewActivity : AppCompatActivity(), OnLoadCompleteListener, OnPageChangeListener,
    OnErrorListener {

    private var pdfview: PDFView? = null
    private var text_show: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)


        pdfview = findViewById<View>(R.id.pdfView) as PDFView
        text_show = findViewById<View>(R.id.text_show) as TextView
        if (pdfview != null) pdfview!!.postDelayed({
            if (pdfview != null) pdfview!!.fromAsset("samplegoogle.pdf")
                .defaultPage(0)
                .enableSwipe(true)
                .enableAnnotationRendering(true)
                .onLoad(this@PdfViewActivity)
                .onPageChange(this@PdfViewActivity)
                .onError(this@PdfViewActivity)
                .scrollHandle(DefaultScrollHandle(this@PdfViewActivity))
                .load()

        }, 1000)
    }

    public override fun onDestroy() {
        pdfview!!.recycle()
        pdfview = null
        super.onDestroy()
        //  dialog.dismiss();
    }

    override fun loadComplete(nbPages: Int) {}
    override fun onPageChanged(page: Int, pageCount: Int) {
        text_show!!.text = "$page/$pageCount"
    }

    override fun onError(t: Throwable?)
    {}
}