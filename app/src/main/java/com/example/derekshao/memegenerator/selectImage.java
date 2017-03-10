package com.example.derekshao.memegenerator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;



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

        list.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String img_name = String.valueOf(parent.getItemAtPosition(position));

                    Intent chosenImage = new Intent();
                    chosenImage.putExtra("image", img_name);
                    setResult(Activity.RESULT_OK, chosenImage);
                    finish();
                }
            }
        );
    }
}
