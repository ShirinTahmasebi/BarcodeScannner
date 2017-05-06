package shirin.tahmasebi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import tahmasebi.shirin.barcodescanner.R;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button scan_button;
    private TextView format_textview, content_textview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        scan_button = (Button) findViewById(R.id.scan_button);
        format_textview = (TextView) findViewById(R.id.scan_format);
        content_textview = (TextView) findViewById(R.id.scan_content);

        scan_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.scan_button) {
            // Scan
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // Retrieve scan result
        IntentResult scanningResult =
                IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanningResult != null) {
            // We have a result
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            format_textview.setText("FORMAT: " + scanFormat);
            content_textview.setText("CONTENT: " + scanContent);
        } else {
            Toast toast =
                    Toast.makeText(
                            getApplicationContext(),
                            R.string.error_nullScanResult,
                            Toast.LENGTH_SHORT
                    );
            toast.show();
        }
    }
}
