package com.mbashrafulislam.banglaoxford3000vocabulary;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.journeyapps.barcodescanner.CaptureActivity;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

public class PortraitCaptureActivity extends CaptureActivity {

    private boolean isTorchOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the DecoratedBarcodeView from CaptureActivity's layout
        DecoratedBarcodeView barcodeView = findViewById(R.id.zxing_barcode_scanner);

        // Create a simple flashlight toggle button
        ImageButton flashToggle = new ImageButton(this);
        flashToggle.setImageResource(R.drawable.ic_flashlight_off);
        flashToggle.setBackgroundColor(0x00000000); // transparent background

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT,
                Gravity.BOTTOM | Gravity.END

        );
        params.setMargins(0, 0, 80, 80);
        flashToggle.setLayoutParams(params);

        // Set layout params to position it (adjust margins as needed)
        // DecoratedBarcodeView.LayoutParams params = new DecoratedBarcodeView.LayoutParams(
        // DecoratedBarcodeView.LayoutParams.WRAP_CONTENT,
        // DecoratedBarcodeView.LayoutParams.WRAP_CONTENT);


        // Add toggle button to barcodeView
        barcodeView.addView(flashToggle);

        // Handle flashlight toggle
        flashToggle.setOnClickListener(v -> {
            if (isTorchOn) {
                barcodeView.setTorchOff();
                flashToggle.setImageResource(R.drawable.ic_flashlight_off);
                isTorchOn = false;
            } else {
                barcodeView.setTorchOn();
                flashToggle.setImageResource(R.drawable.ic_flashlight_on);
                isTorchOn = true;
            }
        });
    }
}