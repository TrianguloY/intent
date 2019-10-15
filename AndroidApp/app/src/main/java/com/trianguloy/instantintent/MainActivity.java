package com.trianguloy.instantintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText edtxt_uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtxt_uri = findViewById(R.id.edtxt_uri);

    }

    public void onButtonClick(View view) {
        // one button only
        try {
            Intent intent = new Intent(this, Opener.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("https://" + getString(R.string.url) + getString(R.string.path) + edtxt_uri.getText()));
            startActivity(intent);
        } catch (Throwable e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.toast_cantstart, Toast.LENGTH_SHORT).show();
        }
    }
}
