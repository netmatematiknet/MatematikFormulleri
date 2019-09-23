package com.mobilprogramlar.MatematikFormulleri;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class UygulamaUrunlerimiz extends AppCompatActivity {
ImageView goruntu1, goruntu2;
Button btn1, btn2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uygulama_urunlerimiz);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(getApplicationContext(),Uygulamalar.class);
                startActivity(i4);
            }
        });

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
