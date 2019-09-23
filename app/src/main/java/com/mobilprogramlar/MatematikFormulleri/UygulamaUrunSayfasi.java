package com.mobilprogramlar.MatematikFormulleri;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class UygulamaUrunSayfasi extends Activity {
    private String url1 = null;
    private Bundle Bundlelink = null;


    private WebView webView;
    private CustomWebViewClient webViewClient;
    //private String Url = "https://play.google.com/store/apps/details?id=com.ossmatematik.ygs";
    ProgressDialog mProgressDialog;

    @SuppressLint("SetJavaScriptEnabled") //javaScrit hata göstermesini kapattık
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uygulama_urunsayfasi);

        //getString(“key”), getInt(“key”), getBoolean(“key”)…
        //Bundlelink = getIntent().getExtras();
        //url1 = Bundlelink.getString(UygulamaUrunlerimiz.Url);

        //new EEPROM().reklamGoster(getApplicationContext(),new EEPROM().reklamIhtimali);

        mProgressDialog = new ProgressDialog(this);//ProgressDialog objesi oluşturuyoruz
        mProgressDialog.setMessage("Yükleniyor...");//ProgressDialog Yükleniyor yazısı
        webViewClient = new CustomWebViewClient();//CustomWebViewClient classdan webViewClient objesi oluşturuyoruz
        webView = (WebView) findViewById(R.id.webview1);//webview mızı xml uygulama_urunsayfasi.xmlyfasi.xml deki webview başlıyoruz

        webView.getSettings().setBuiltInZoomControls(true); //zoom yapılmasına izin verir
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(webViewClient); //oluşturduğumuz webViewClient objesini webViewımıza set ediyoruz
        webView.loadUrl(url1);
    }

    private class CustomWebViewClient extends WebViewClient {
        //Alttaki methodların hepsini kullanmak zorunda deilsiniz
        //Hangisi işinize yarıyorsa onu kullanabilirsiniz.

        /*
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) { //Sayfa yüklenirken çalışır
            super.onPageStarted(view, url, favicon);
            if(!mProgressDialog.isShowing())//mProgressDialog açık mı kontrol ediliyor
            {
                mProgressDialog.show();//mProgressDialog açık değilse açılıyor yani gösteriliyor ve yükleniyor yazısı çıkıyor
            }
        }
        @Override
        public void onPageFinished(WebView view, String url) {//sayfamız yüklendiğinde çallışyor.
            super.onPageFinished(view, url);
            if(mProgressDialog.isShowing()){//mProgressDialog açık mı kontrol
                mProgressDialog.dismiss();//mProgressDialog açıksa kapatılıyor
            }
        }
        */

        /*
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // Bu method açılan sayfa içinden başka linklere tıklandığında açılmasına yarıyor.
            //Bu methodu override etmez yada edip içini boş bırakırsanız ilk url den açılan sayfa dışında başka sayfaya geçiş yapamaz
            view.loadUrl(url);//yeni tıklanan url i açıyor
            return true;
        }
        */


    }




    public void onBackPressed() //Android Back Buttonunu Handle ettik. Back butonu uygulama_bir önceki sayfaya geri dönecek
    {
        if(webView.canGoBack()){//eğer varsa uygulama_bir önceki sayfaya gidecek
            webView.goBack();
        }else{                  //Sayfa yoksa uygulamadan çıkacak
            super.onBackPressed();
        }
    }













    //PAYLAŞ
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_message:
                anasayfa();
                break;
            case R.id.paylas:
                share();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
    public void anasayfa(){
        Intent myIntent = new Intent(getApplicationContext(), UygulamaUrunlerimiz.class);
        startActivity(myIntent);
    }
    public void share(){
        String paylasmesajbasligii = "Ygs Lys Pratik Matematik\n";
        String paylasmesaji = "Ygs Pratik Matematik 2006 yılından beri Üniversite hazırlık sınavlarında çıkmış "
                +"Tüm Matematik Soruları ve Çözümleri\n"
                //"ni bulabilirsiniz. "
                //+"İNDİR"
                +"https://play.google.com/store/apps/details?id=net.netmatematik.matematik";
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, paylasmesajbasligii);
        sharingIntent.putExtra(Intent.EXTRA_TEXT, paylasmesaji);
        startActivity(Intent.createChooser(sharingIntent, "Paylaşmak İçin Tıklayınız"));
    }
    //PAYLAŞ




    }
