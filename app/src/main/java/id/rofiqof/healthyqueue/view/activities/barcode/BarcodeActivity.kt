package id.rofiqof.healthyqueue.view.activities.barcode

import android.graphics.Bitmap
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.view.View
import android.widget.Toast
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import id.rofiqof.healthyqueue.R
import kotlinx.android.synthetic.main.activity_barcode.*
import kotlinx.android.synthetic.main.barcode_.*

class BarcodeActivity : Barcode() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBottomSheet(R.layout.barcode_)
    }

    override fun onClick(v: View) {
        fabProgressCircle.show()
        cameraView.captureImage { cameraKitImage ->
            getQRCodeDetailsFromBitmap(cameraKitImage.bitmap)
            runOnUiThread {
                showPreview()
                imagePreview.setImageBitmap(cameraKitImage.bitmap)
            }
        }
    }

    private fun getQRCodeDetailsFromBitmap(bitmap: Bitmap) {
        val options = FirebaseVisionBarcodeDetectorOptions.Builder()
            .setBarcodeFormats(FirebaseVisionBarcode.FORMAT_ALL_FORMATS)
            .build()
        val detector = FirebaseVision.getInstance().getVisionBarcodeDetector(options)
        val image = FirebaseVisionImage.fromBitmap(bitmap)
        detector.detectInImage(image)
            .addOnSuccessListener {
                for (firebaseBarcode in it) {
                    codeData.text = firebaseBarcode.displayValue //Display contents inside the barcode
                    when (firebaseBarcode.valueType) {
                        FirebaseVisionBarcode.TYPE_URL -> firebaseBarcode.url
                        FirebaseVisionBarcode.TYPE_CONTACT_INFO -> firebaseBarcode.contactInfo
                        FirebaseVisionBarcode.TYPE_WIFI -> firebaseBarcode.wifi
                    }
                }
            }
            .addOnFailureListener {
                it.printStackTrace()
                Toast.makeText(baseContext, "Sorry, something went wrong!", Toast.LENGTH_SHORT)
                    .show()
            }
            .addOnCompleteListener {
                fabProgressCircle.hide()
                sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
    }
}
