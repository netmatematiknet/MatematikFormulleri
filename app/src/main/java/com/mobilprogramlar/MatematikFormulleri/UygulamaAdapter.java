package com.mobilprogramlar.MatematikFormulleri;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

//import java.util.List;

public class UygulamaAdapter extends RecyclerView.Adapter<UygulamaAdapter.MyViewHolder> {

    private Context mContext;
    private List<Uygulama> uygulamaList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);

            thumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    switch (getAdapterPosition()){
                        case 0:
                            //Toast.makeText(mContext,"Item " + getAdapterPosition() + " clicked", Toast.LENGTH_SHORT).show();
                            Intent i1=new Intent(mContext,UygulamaWebview.class);
                            i1.putExtra("uygulama_link", mContext.getString(R.string.uygulama_link_0));
                            mContext.startActivity(i1);
                            break;
                        case 1:
                            Intent i2=new Intent(mContext,UygulamaWebview.class);
                            i2.putExtra("uygulama_link",mContext.getString(R.string.uygulama_link_1));
                            mContext.startActivity(i2);
                            break;

                    }
                }
            });









        }
    }




    public UygulamaAdapter(Context mContext, List<Uygulama> uygulamaList) {
        this.mContext = mContext;
        this.uygulamaList = uygulamaList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.uygulama_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Uygulama uygulama = uygulamaList.get(position);
        holder.title.setText(uygulama.getName());
        //holder.count.setText(uygulama.getNumOfSongs() + " songs");
        holder.count.setText( "Nurullah Tayıpoğlu");

        // loading uygulama cover using Glide library
        Glide.with(mContext).load(uygulama.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });


    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.uygulama_menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Ayrıntı için resime tıklayınız", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Ayrıntı için resime tıklayınız", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return uygulamaList.size();
    }
}
