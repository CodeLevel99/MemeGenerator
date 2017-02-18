package com.example.derekshao.memegenerator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TopSectionFragment.TopSectionListener {

    //widgets
    private Toolbar toolbar;
    private TextView topText;
    private TextView bottomText;
    private EditText editTopText;
    private EditText editBottomText;
    private ImageView meme_photo;


    private static int REQUEST_IMAGE_CAPTURE = 1;
    private static int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //topText
        topText = (TextView) findViewById(R.id.topMemeText);
        bottomText = (TextView) findViewById(R.id.bottomMemeText);
        editTopText = (EditText) findViewById(R.id.topTextInput);
        editBottomText = (EditText) findViewById(R.id.bottomTextInput);



    }

    //inflates menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    //Adding and Handling actions from toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_takePhoto:
                dispatchTakePictureIntent();
                return true;
            case R.id.action_restore:
                restoreDefault();
                return true;
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "Not avaliable.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_selectImage:
                Intent start_image_selector = new Intent(this, selectImage.class);
                startActivity(start_image_selector);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //implemented method from top fragment, passes text to bottom fragment
    @Override
    public void createMeme(String top, String bottom) {

    }

    //restores default gnome child image
    public void restoreDefault() {
        Drawable image = ResourcesCompat.getDrawable(getResources(), R.drawable.gnome_child, null);
    }

    //creates take picture intent
    public void dispatchTakePictureIntent() {
        Intent takePictureIntent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    //result of photo intent
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText(MainActivity.this, "No image was taken.", Toast.LENGTH_SHORT).show();
                return;
            }
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Drawable image = new BitmapDrawable(getResources(), imageBitmap);


        }
    }

    public void setMemeText(String top, String bottom) {

        topText.setText(top);
        bottomText.setText(bottom);
    }

    public void setNewPicture(Drawable image) {

    }
}
