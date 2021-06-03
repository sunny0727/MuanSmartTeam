package kr.co.itid.muansmartteam

import android.content.Context
import android.net.http.SslError
import android.os.Bundle
import android.os.Handler
import android.view.KeyEvent
import android.view.WindowManager
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import kr.co.itid.muansmartteam.pdfviewer.PdfViewerActivity


/**
 * created by
 * 210512~
 */

class WebActivity : AppCompatActivity() {

    companion object {
        private const val url = "https://www.muan.go.kr/smartapp"
        var handler : Handler? = Handler()
        var mContext : Context? = null

    }

    private lateinit var webView: WebView
    private lateinit var webSetting: WebSettings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        supportActionBar?.hide()

        mContext = applicationContext
        webView = findViewById(R.id.webView) as WebView

        
        // 인증서 오류 수정
        webView.webViewClient = object : WebViewClient(){
            override fun onReceivedSslError(
                view: WebView?,
                handler: SslErrorHandler?,
                error: SslError?
            ) {
//                super.onReceivedSslError(view, handler, error)
                handler?.proceed()
            }
        }

        webSetting = webView.getSettings()
        webSetting.setJavaScriptEnabled(true) // javaScript used
        webView.addJavascriptInterface(webBridge(), "android")
        webSetting.setSupportZoom(true)

        webView.settings.textZoom = 100


        webView.loadUrl(url) // 연결할 웹뷰 url
    }

    class webBridge {
        @JavascriptInterface
        fun CallDownloadFile(url : String) {
            handler?.post{

                PdfViewerActivity.launchPdfFromUrl(mContext,
                    url,                               // PDF URL in String format
                    "Pdf title/name ",                        // PDF Name/Title in String format
                    "pdf directory to save",                  // If nothing specific, Put "" it will save to Downloads
                    enableDownload = true
                )
            }
        }
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


}