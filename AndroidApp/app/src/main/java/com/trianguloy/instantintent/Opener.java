package com.trianguloy.instantintent;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.net.URISyntaxException;

public class Opener extends Activity {

    static class ExitException extends RuntimeException {
        public int string;

        ExitException(int string) {
            super();
            this.string = string;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            String url = getString(R.string.url) + getString(R.string.path);

            Intent intent = getIntent();
            if (intent == null) throw new ExitException(R.string.toast_nointent);

            String uri = intent.getDataString();
            if (uri == null) throw new ExitException(R.string.toast_nodata);
            Log.d("Data", uri);

            if (!uri.contains(url)) throw new ExitException(R.string.toast_invaliddata);
            uri = uri.substring(uri.indexOf(url) + url.length());
            if (uri.startsWith("/")) uri = uri.substring(1);
            if (uri.isEmpty()) throw new ExitException(R.string.toast_nourl);

            Log.d("URI", uri);

            try {
                startActivity(Intent.parseUri(uri, 0));
            } catch (URISyntaxException e) {
                e.printStackTrace();
                throw new ExitException(R.string.toast_invaliduri);
            } catch (ActivityNotFoundException a) {
                a.printStackTrace();
                throw new ExitException(R.string.toast_cantstart);
            }

        } catch (ExitException e) {
            Toast.makeText(this, getString(e.string), Toast.LENGTH_LONG).show();
        } catch (Throwable e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.toast_unknown, Toast.LENGTH_SHORT).show();
        } finally {
            finish();
        }
    }
}
