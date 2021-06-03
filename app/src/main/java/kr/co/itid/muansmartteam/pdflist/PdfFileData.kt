package kr.co.itid.muansmartteam.pdflist

import java.util.*

data class PdfFileData(
    val filename : String,
    val url : String,
    val check : Boolean,
    val date : String
    // date format yyyyMMdd HH:mm:ss
)
