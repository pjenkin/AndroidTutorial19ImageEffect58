package com.example.imageeffect58;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Drawable image_drawable;      // JPEGs need to be converted to bitmaps
    Bitmap image_bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // image processing in order to perform effect on image
        imageView = (ImageView) findViewById(R.id.image_view);
//        image_drawable = getDrawable(R.drawable.tommy_tucker);
        getResources().getDrawable(R.drawable.tommy_tucker);
        // NB getResources().getDrawable deprecated https://stackoverflow.com/q/29041027/11365317
        // however, minimum API level 17 (my phone) so can't use just getDrawable alone

        image_bitmap = ((BitmapDrawable) image_drawable).getBitmap();
        // get the manipulable bitmap of the image
        Bitmap newImage = invertImage(image_bitmap);
        imageView.setImageBitmap(newImage);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
