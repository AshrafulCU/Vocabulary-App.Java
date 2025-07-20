package com.mbashrafulislam.banglaoxford3000vocabulary;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRCodeScanner extends AppCompatActivity {

    private TextView txtResult;
    private Button btnScan, btnVisit, copy_button;
    private String lastScannedUrl = null;

    final String commonText = "Click Scan Button";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_scanner);


        txtResult = findViewById(R.id.txtResult);
        btnScan = findViewById(R.id.btnScan);
        btnVisit = findViewById(R.id.btnVisit);
        copy_button = findViewById(R.id.copy_button);



        btnVisit.setVisibility(View.GONE);
        btnScan.setOnClickListener(v -> startQRScanner());

        btnVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastScannedUrl != null){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(lastScannedUrl));
                    startActivity(browserIntent);
                }
            }
        });

        copy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textToCopy = txtResult.getText().toString().trim();
                if (textToCopy.isEmpty() || textToCopy.equals(commonText)){
                    Toast.makeText(QRCodeScanner.this, "No Text to Copy", Toast.LENGTH_SHORT).show();
                }else {
                    ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("Copied Text", textToCopy);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(QRCodeScanner.this, "Copied to Clipboard", Toast.LENGTH_SHORT).show();

                }
            }
        });

        applyDisplayCutouts();


    }

    private void applyDisplayCutouts() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.qRCodeScannerLayout), (v, insets) -> {
            Insets bars = insets.getInsets(
                    WindowInsetsCompat.Type.systemBars()
                            | WindowInsetsCompat.Type.displayCutout()
            );
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });
    }



    private void startQRScanner(){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setPrompt("Scan A QR or Bar Code");
        integrator.setOrientationLocked(true);
        integrator.setCaptureActivity(PortraitCaptureActivity.class);
        integrator.setBeepEnabled(true);
        integrator.setBarcodeImageEnabled(true);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.initiateScan();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode, data);

        if (result != null && result.getContents() != null){
            String scannedData = result.getContents();
            if (scannedData.startsWith("WIFI:")){
                String password = extractWifiPassword(scannedData);
                txtResult.setText(password != null ? "Wifi Password:  " + password : "Could not extract password" );
                btnVisit.setVisibility(View.GONE);

            }else {
                txtResult.setText(scannedData);
                if (Patterns.WEB_URL.matcher(scannedData).matches()){
                    lastScannedUrl = scannedData;
                    btnVisit.setVisibility(View.VISIBLE);
                }else {
                    lastScannedUrl = null;
                    btnVisit.setVisibility(View.GONE);
                }
            }
        }

    }


    private String extractWifiPassword(String wifiData){
        try {
            // Example format: WIFI:T:WPA;S:YourSSID;P:YourPassword;;
            String[] parts = wifiData.split(";");
            for (String part : parts) {
                if (part.startsWith("P:")) {
                    return part.substring(2); // Remove "P:"
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
