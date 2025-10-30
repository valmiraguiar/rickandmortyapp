package com.valmiraguiar.rickandmorty.utils

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.view.View
import androidx.core.content.FileProvider
import androidx.core.view.drawToBitmap
import java.io.File
import java.io.FileOutputStream

private const val PDF_FILE_NAME = "character_page.pdf"

fun bitmapToPdf(context: Context, bitmap: Bitmap): File {
//    val softwareBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, false)

    val pdfDocument = PdfDocument()
    val pageInfo = PdfDocument.PageInfo.Builder(bitmap.width, bitmap.height, 1).create()
    val page = pdfDocument.startPage(pageInfo)
    val canvas = page.canvas

    canvas.drawBitmap(bitmap, 0f, 0f, null)
    pdfDocument.finishPage(page)

    val pdfFile = File(context.cacheDir, PDF_FILE_NAME)
    FileOutputStream(pdfFile).use { out ->
        pdfDocument.writeTo(out)
    }

    pdfDocument.close()
    return pdfFile
}

fun sharePdf(context: Context, pdfFile: File) {
    val uri: Uri = FileProvider.getUriForFile(
        context,
        "${context.packageName}.provider",
        pdfFile
    )

    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "application/pdf"
        putExtra(Intent.EXTRA_STREAM, uri)
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }

    context.startActivity(
        Intent.createChooser(shareIntent, "Share PDF")
    )
}

fun View.safeDrawToBitmap(): Bitmap {
//    val oldLayerType = layerType
//    setLayerType(View.LAYER_TYPE_SOFTWARE, null)
//
//    val bitmap = drawToBitmap(
//        Bitmap.Config.ARGB_8888
//    )
//
//    setLayerType(oldLayerType, null)



    return bitmap
}