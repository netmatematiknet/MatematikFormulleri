package com.mobilprogramlar.MatematikFormulleri;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import android.support.v4.view.PagerAdapter;

public class FormulGoster extends Activity {
    public int keys = 0;
    static int[] images;
    static String[] title;
    static int page1 = 1;
    static TextView tv;
    ImageButton img_button_geri;

    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulgoster);
        tv = findViewById(R.id.textView3);

        FloatingActionButton fabButton1 = (FloatingActionButton) findViewById(R.id.fab);

        fabButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent geriIntent = new Intent(getApplicationContext(),Formuller.class);
                startActivity(geriIntent);
            }
        });


        try {   //getIntent ile konu id sini aldık
            Bundle extraData = getIntent().getExtras();
            int Konuid = extraData.getInt("id");
            //Toast.makeText(this, String.valueOf(Konuid) , Toast.LENGTH_SHORT).show();
            keys = Konuid;

            images = EEPROM.list;
            title = EEPROM.listString;
            //Toast.makeText(getApplicationContext(), title[0]+ " - " + String.valueOf(page1), Toast.LENGTH_SHORT).show();
            //tv.setText(title[0]+ " - " + String.valueOf(page1));
            //tv.setText(title[0]+String.valueOf(page1)+"/"+String.valueOf(images.length));

            //setTitle(title[0]);
            //setTitle("Nurullah");

            ExtendedViewPager mViewPager = findViewById(R.id.view_pager);

            final TouchImageAdapter tt = new TouchImageAdapter(keys, images);
            mViewPager.setAdapter(tt);
            mViewPager.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    //Toast.makeText(getApplicationContext(), "fff" , Toast.LENGTH_SHORT).show();
                    //tv.setText(title[0]+ " - " + String.valueOf(page1));
                }
            });

        }catch (Exception ex)
        {
            Toast.makeText(this, ex.getMessage() , Toast.LENGTH_LONG).show();
        }
    }

    public static class TouchImageAdapter extends PagerAdapter {
        int idMe=0;
        int []img;
        public TouchImageAdapter(int _id, int[] _img)
        {
            this.idMe = _id;
            this.img = _img;
        }

        //private static int[] images = { R.drawable.fortemelk1, R.drawable.fortemelk2, R.drawable.fortemelk3 };

        @Override
        public int getCount() {
        	return images.length;
        }

        @Override
        public View instantiateItem(final ViewGroup container, int position) {
            //Toast.makeText(get,"page1:"+page1,Toast.LENGTH_LONG).show();
            TouchImageView img = new TouchImageView(container.getContext());
            img.setImageResource(images[position]);
            container.addView(img, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            tv.setText(title[0]+String.valueOf(position)+"/"+String.valueOf(images.length));
            page1 = position+1;

            return img;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }
}
