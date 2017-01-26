package com.example.derekshao.memegenerator;

import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class selectImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);

        //image names
        String[] image_names = {"Gnome Child", "Evil Kermit", "Pepe", "Donald", "Arthur"};

        ListAdapter imgAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, image_names);
        ListView list = (ListView)findViewById(R.id.image_list);
        list.setAdapter(imgAdapter);

        final Drawable pepe = ResourcesCompat.getDrawable(getResources(), R.drawable.pepe, null);
        final Drawable arthur_hand = ResourcesCompat.getDrawable(getResources(), R.drawable.arthur_hand, null);
        final Drawable evil_kermit = ResourcesCompat.getDrawable(getResources(), R.drawable.evil_kermit, null);

        list.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String img_name = String.valueOf(parent.getItemAtPosition(position));
                    BottomSectionFragment bottom = (BottomSectionFragment)getSupportFragmentManager().findFragmentById(R.id.fragment2);

                    switch(img_name) {
                        case "Arthur":
                            bottom.setNewPicture(arthur_hand);
                            onDestroy();
                            break;
                        case "Pepe":
                            bottom.setNewPicture(pepe);
                            break;
                        case "Evil Kermit":
                            bottom.setNewPicture(evil_kermit);
                            break;
                        default:
                            break;
                    }

                }
            }
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
