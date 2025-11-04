package com.valmiraguiar.rickandmorty.utils

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.view.View
import androidx.core.content.FileProvider
import androidx.core.view.drawToBitmap
import java.io.File
import java.io.FileOutputStream


fun View.captureSoftBitmap(): Bitmap {
    return this.drawToBitmap(config = Bitmap.Config.ARGB_8888)
}

fun Context.writeBitmapAsSinglePagePdf(bitmap: Bitmap, pdfName: String): Uri {
    val pdf = PdfDocument()

    val pageInfo =
        PdfDocument.PageInfo.Builder(bitmap.width, bitmap.height, /*pageNumber=*/1).create()
    val page = pdf.startPage(pageInfo)

    page.canvas.apply {
        drawColor(Color.WHITE)               // Keeps background white
        drawBitmap(bitmap, 0f, 0f, null)     // Draw at (0,0); already sized for page
    }

    pdf.finishPage(page)

    val dir = File(cacheDir, "shared_pdfs").apply { mkdirs() }
    val outFile = File(dir, "${pdfName}.pdf")

    FileOutputStream(outFile).use { pdf.writeTo(it) }
    pdf.close()

    return FileProvider.getUriForFile(this, "$packageName.fileprovider", outFile)
}

@SuppressLint("QueryPermissionsNeeded")
fun Context.sharePdf(pdfUri: Uri) {
    val share = Intent(Intent.ACTION_SEND).apply {
        type = "application/pdf"
        putExtra(Intent.EXTRA_STREAM, pdfUri)
        clipData = ClipData.newUri(contentResolver, "shared-pdf", pdfUri)
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        putExtra(Intent.EXTRA_TITLE, "character.pdf")
    }

    val resInfoList = packageManager.queryIntentActivities(share, PackageManager.MATCH_DEFAULT_ONLY)
    for (ri in resInfoList) {
        grantUriPermission(
            ri.activityInfo.packageName,
            pdfUri,
            Intent.FLAG_GRANT_READ_URI_PERMISSION
        )
    }


    startActivity(Intent.createChooser(share, "Share PDF"))
}