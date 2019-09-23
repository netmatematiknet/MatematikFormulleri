package com.mobilprogramlar.MatematikFormulleri;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
//import android.app.Person;

//import android.support.v7.app.ActionBarActivity;
//import android.view.Menu;
//import android.view.MenuItem;

public class Formuller extends AppCompatActivity {

    int[] images;
    EEPROM eeprom;
    Intent intent;
    Context context;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formuller);

        context = getApplicationContext();
        // Persons is creating
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Temel Kavramlar","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Sayı Basamakları","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Bölme ve Bölünebilme","Ygs-Lys",R.drawable.math64));
        persons.add(new Person("Obeb Okek","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Rasyonel Sayılar","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Basit Eşitsizlik","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Mutlak Değer","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Üslü Sayılar","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Köklü Sayılar","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Çarpanlara Ayırma","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Oran ve Orantı","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Denklem Çözme","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Sayı ve Kesir Problemleri","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Yaş Problemleri","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("İşçi ve Havuz Problemleri","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Yüzde Kar Zarar ve Faiz Problemleri","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Karışım Problemleri","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Hareket Problemleri","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Kümeler","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Kartezyen Çarpım","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Fonksiyonlar","Ygs-Lys Konusu",R.drawable.math64));

        persons.add(new Person("Permütasyon","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Kombinasyon","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Binom","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Olasılık","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("İstatistik","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Polinomlar","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("İkinci Derece Denklemler Konusu","Ygs-Lys",R.drawable.math64));
        persons.add(new Person("Karmaşık Sayılar","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Parabol","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Eşitsizlik","Ygs-Lys Konusu",R.drawable.math64));
        persons.add(new Person("Trigonometri","Ygs-Lys Konusu",R.drawable.math64));

        persons.add(new Person("Logaritma","Lys Konusu" ,R.drawable.math64));
        persons.add(new Person("Modüler Aritmetik","Lys Konusu",R.drawable.math64));
        persons.add(new Person("Diziler","Lys Konusu",R.drawable.math64));
        persons.add(new Person("Aritmetik Dizi","Lys Konusu",R.drawable.math64));
        persons.add(new Person("Geometrik Dizi","Lys Konusu",R.drawable.math64));
        persons.add(new Person("Özel Tanımlı Fonksiyonlar","Lys Konusu",R.drawable.math64));
        persons.add(new Person("Limit","Lys Konusu",R.drawable.math64));
        persons.add(new Person("Türev","Lys Konusu",R.drawable.math64));
        persons.add(new Person("İntegral","Lys Konusu",R.drawable.math64));

        // Adapter is creating
        PersonAdapter personAdapter = new PersonAdapter(this, R.layout.formuller_listview,persons);
        // Finding listview and persons will short in listview.
        ListView listviewPerson = (ListView)findViewById(R.id.listView_persons);
        if(listviewPerson != null){
            listviewPerson.setAdapter(personAdapter);
        }


        listviewPerson.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                switch (position){
                    case 0:
                        images = new int[]{ R.mipmap.fortemelk1, R.mipmap.fortemelk2, R.mipmap.fortemelk3 };
                        aokEEPROM(images, position, "Temel Kavramlar : " );
                        //aokEEPROM(images, position, "Temel Kavramlar : " + String.valueOf(images.length)+" sayfa");
                        break;
                    case 1:
                        images = new int[]{ R.mipmap.forsayibas1 };
                        aokEEPROM(images, position, "Sayı Basamakları : ");
                        break;
                    case 2:
                        images = new int[]{ R.mipmap.forbolme1, R.mipmap.forbolme2, R.mipmap.forbolme3, R.mipmap.forbolme4 };
                        aokEEPROM(images, position, "Bölme ve Bölünebilme : ");
                        break;
                    case 3:
                        images = new int[]{ R.mipmap.forobeb1, R.mipmap.forobeb2 };
                        aokEEPROM(images, position, "Obeb Okek : ");
                        break;
                    case 4:
                        images = new int[]{ R.mipmap.forrasyonel1, R.mipmap.forrasyonel2, R.mipmap.forrasyonel3 };
                        aokEEPROM(images, position, "Rasyonel Sayılar : ");
                        break;
                    case 5:
                        images = new int[]{ R.mipmap.forbasit1 };
                        aokEEPROM(images, position, "Basit Eşitsizlik : ");
                        break;
                    case 6:
                        images = new int[]{ R.mipmap.formutlak1, R.mipmap.formutlak2 };
                        aokEEPROM(images, position, "Mutlak Değer : ");
                        break;
                    case 7:
                        images = new int[]{ R.mipmap.foruslu1, R.mipmap.foruslu2 };
                        aokEEPROM(images, position, "Üslü Sayılar : ");
                        break;
                    case 8:
                        images = new int[]{ R.mipmap.forkoklu1, R.mipmap.forkoklu2, R.mipmap.forkoklu3 };
                        aokEEPROM(images, position, "Köklü Sayılar : ");
                        break;
                    case 9:
                        images = new int[]{ R.mipmap.forcarpan1, R.mipmap.forcarpan2 };
                        aokEEPROM(images, position, "Çarpanlara Ayırma : ");
                        break;
                    case 10:
                        images = new int[]{ R.mipmap.fororanti1, R.mipmap.fororanti2 };
                        aokEEPROM(images, position, "Oran ve Orantı : ");
                        break;
                    case 11:
                        images = new int[]{ R.mipmap.fordenklem1};
                        aokEEPROM(images, position, "Denklem Çözme : ");
                        break;
                    case 12:
                        images = new int[]{ R.mipmap.forsayikesir1 };
                        aokEEPROM(images, position, "Sayı ve Kesir Problemleri : ");
                        break;
                    case 13:
                        images = new int[]{ R.mipmap.foryas1 };
                        aokEEPROM(images, position, "Yaş Problemleri : ");
                        break;
                    case 14:
                        images = new int[]{ R.mipmap.forisci1 };
                        aokEEPROM(images, position, "İşçi ve Havuz Problemleri : ");
                        break;
                    case 15:
                        images = new int[]{ R.mipmap.foryuzde1 };
                        aokEEPROM(images, position, "Yüzde Kar Zarar ve Faiz Problemleri : ");
                        break;
                    case 16:
                        images = new int[]{ R.mipmap.forkarisim1 };
                        aokEEPROM(images, position, "Karışım Problemleri : ");
                        break;
                    case 17:
                        images = new int[]{ R.mipmap.forhiz1 };
                        aokEEPROM(images, position, "Hareket Problemleri : ");
                        break;
                    case 18:
                        images = new int[]{ R.mipmap.forkume1, R.mipmap.forkume2, R.mipmap.forkume3 };
                        aokEEPROM(images, position, "Kümeler : ");
                        break;
                    case 19:
                        images = new int[]{ R.mipmap.forkartezyen1 };
                        aokEEPROM(images, position, "Kartezyen Çarpım : ");
                        break;
                    case 20:
                        images = new int[]{ R.mipmap.forfonksiyon1, R.mipmap.forfonksiyon2, R.mipmap.forfonksiyon3, R.mipmap.forfonksiyon4 };
                        aokEEPROM(images, position, "Fonksiyon : ");
                        break;

                    case 21:
                        images = new int[]{ R.mipmap.forperm1 };
                        aokEEPROM(images, position, "Permütasyon : ");
                        break;
                    case 22:
                        images = new int[]{ R.mipmap.forkombin1, R.mipmap.forkombin2 };
                        aokEEPROM(images, position, "Kombinasyon : ");
                        break;
                    case 23:
                        images = new int[]{ R.mipmap.forbinom1 };
                        aokEEPROM(images, position, "Binom : ");
                        break;
                    case 24:
                        images = new int[]{ R.mipmap.forolas1, R.mipmap.forolas2 };
                        aokEEPROM(images, position, "Olasılık : ");
                        break;
                    case 25:
                        images = new int[]{ R.mipmap.foristatist1, R.mipmap.foristatist2, R.mipmap.foristatist3,
                                R.mipmap.foristatist4, R.mipmap.foristatist5 };
                        aokEEPROM(images, position, "İstatistik : ");
                        break;

                    case 26:
                        images = new int[]{ R.mipmap.forpol1, R.mipmap.forpol2, R.mipmap.forpol3, R.mipmap.forpol4 };
                        aokEEPROM(images, position, "Polinomlar : ");
                        break;
                    case 27:
                        images = new int[]{ R.mipmap.forikincider1, R.mipmap.forikincider2 };
                        aokEEPROM(images, position, "İkinci Derece Denklemler : ");
                        break;
                    case 28:
                        images = new int[]{ R.mipmap.forkarmasik1, R.mipmap.forkarmasik2, R.mipmap.forkarmasik3 };
                        aokEEPROM(images, position, "Karmaşık Sayı : ");
                        break;
                    case 29:
                        images = new int[]{ R.mipmap.forparabol1, R.mipmap.forparabol2, R.mipmap.forparabol3 };
                        aokEEPROM(images, position, "Parabol : ");
                        break;
                    case 30:
                        images = new int[]{ R.mipmap.foresits1, R.mipmap.foresits2 };
                        aokEEPROM(images, position, "Eşitsizlik : ");
                        break;

                    case 31:
                        images = new int[]{ R.mipmap.fortrigo1, R.mipmap.fortrigo2, R.mipmap.fortrigo3,
                                R.mipmap.fortrigo4, R.mipmap.fortrigo5, R.mipmap.fortrigo6,
                                R.mipmap.fortrigo7 };
                        aokEEPROM(images, position, "Trigonometri : ");
                        break;
                    case 32:
                        images = new int[]{ R.mipmap.forlogar1, R.mipmap.forlogar2, R.mipmap.forlogar3 };
                        aokEEPROM(images, position, "Logaritma : ");
                        break;
                    case 33:
                        images = new int[]{ R.mipmap.formoduler1, R.mipmap.formoduler2 };
                        aokEEPROM(images, position, "Modüler Aritmetik : ");
                        break;
                    case 34:
                        images = new int[]{ R.mipmap.fordiziler1 };
                        aokEEPROM(images, position, "Diziler : ");
                        break;
                    case 356:
                        images = new int[]{ R.mipmap.foraritdizi1 };
                        aokEEPROM(images, position, "Aritmetik Dizi : ");
                        break;
                    case 36:
                        images = new int[]{ R.mipmap.forgeodizi1 };
                        aokEEPROM(images, position, "Geometrik Dizi : ");
                        break;
                    case 37:
                        images = new int[]{ R.mipmap.forotf1, R.mipmap.forotf2, R.mipmap.forotf3 };
                        aokEEPROM(images, position, "Özel Tanımlı Fonksiyonlar : ");
                        break;
                    case 38:
                        images = new int[]{ R.mipmap.forlimit1, R.mipmap.forlimit2, R.mipmap.forlimit3,
                                R.mipmap.forlimit4, R.mipmap.forlimit5 };
                        aokEEPROM(images, position, "Limit : ");
                        break;
                    case 39:
                        images = new int[]{ R.mipmap.forturev1, R.mipmap.forturev2, R.mipmap.forturev3,
                                R.mipmap.forturev4, R.mipmap.forturev5, R.mipmap.forturev6,
                                R.mipmap.forturev7, R.mipmap.forturev8, R.mipmap.forturev9, };
                        aokEEPROM(images, position, "Türev : ");
                        break;
                    case 40:
                        images = new int[]{ R.mipmap.forintegral1, R.mipmap.forintegral2, R.mipmap.forintegral3,
                                R.mipmap.forintegral4, R.mipmap.forintegral5, R.mipmap.forintegral6,
                                R.mipmap.forintegral7, R.mipmap.forintegral8, R.mipmap.forintegral9,R.mipmap.forintegral91 };
                        aokEEPROM(images, position, "İntegral : ");
                        break;
                    default: break;
                }
            }
        });
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    */



    //@Override
    //public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       // int id = item.getItemId();
        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
        //    return true;
        //}
       // return super.onOptionsItemSelected(item);
    //}
    private void aokEEPROM(int []img, int ps, String title)
    {
        eeprom = new EEPROM();
        eeprom.setListCount(img.length);
        for(i=0;i<eeprom.getCount();i++)
        {
            eeprom.write(i, img[i], title);
        }
        aokIntent(ps);
    }
    private void aokIntent(int ps)  //intent ile MatematikGoster sayfasına Konu İd sini gönderiyrouz
    {
        intent = new Intent(context, FormulGoster.class);
        intent.cloneFilter();
        intent.putExtra("id", ps);
        startActivity(intent);
    }



/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        return super.onOptionsItemSelected(item);
    }
*/













}