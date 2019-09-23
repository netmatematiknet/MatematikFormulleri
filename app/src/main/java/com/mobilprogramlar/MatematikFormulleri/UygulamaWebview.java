package com.mobilprogramlar.MatematikFormulleri;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mobilprogramlar.MatematikFormulleri.R;

public class UygulamaWebview extends AppCompatActivity {
    private WebView webView;    //Webview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uygulama_webview);

        Bundle gelenVeri=getIntent().getExtras();
        //CharSequence gelenlink = gelenVeri.getCharSequence("uygulama_link");
        String gelenlink = gelenVeri.getString("uygulama_link");
        //Toast.makeText(getApplicationContext(), "Gelen Link: "+gelenlink,Toast.LENGTH_SHORT).show();
        webView = (WebView) findViewById(R.id.webview1);
        webView.getSettings().setJavaScriptEnabled(true);
        //final ProgressDialog progressDialog = ProgressDialog.show(getApplicationContext(), "nurullah", "Sayfa Yükleniyor...", true);
        webView.setWebViewClient(new WebViewClient() {
            // Sayfa Yüklenirken uygulama_bir hata oluşursa kullanıcıyı uyarıyoruz.
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(getApplicationContext(), "Sayfa Yüklenemedi!\b Sayfanın açılabilmesi için İnternet Bağlantınızın olması gerekir", Toast.LENGTH_LONG).show();
            }

        });

        webView.loadUrl(gelenlink);             //Web sayfamızın url'ini webView'e yüklüyoruz.


    }

}
