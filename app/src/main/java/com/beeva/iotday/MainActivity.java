package com.beeva.iotday;

import android.content.IntentFilter;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.beeva.ubiqlibrary.UbiqonsManager;
import com.beeva.ubiqlibrary.gcm.UbiqonsGcmBroadcastReceiver;
import com.beeva.ubiqlibrary.gcm.UbiqonsGcmIntentService;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        if(BuildConfig.DEBUG)
            UbiqonsManager.register(this, PrivateStatics.UUID, PrivateStatics.TOKEN, "test_group", "test_user");
        else {
            String deviceId = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
            UbiqonsManager.register(this, PrivateStatics.UUID, PrivateStatics.TOKEN, "api_hour", deviceId);
        }
        setUpWebView();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void setUpWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.theapihour.com/");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_schedule) {
            webView.loadUrl("http://www.theapihour.com/#ribbon");
            return true;
        }
        else if(item.getItemId() == android.R.id.home){
            webView.loadUrl("http://www.theapihour.com/#");
            return true;
        }
        else return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
            webView.goBack();
        else super.onBackPressed();
    }
}
