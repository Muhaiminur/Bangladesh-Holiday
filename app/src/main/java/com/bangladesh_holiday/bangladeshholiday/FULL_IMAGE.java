package com.bangladesh_holiday.bangladeshholiday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;

public class FULL_IMAGE extends AppCompatActivity {

    PhotoView photoview;
    int image_drawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full__image);
        photoview =findViewById(R.id.photo_view);
        //RECEIVE OUR DATA
        Intent i=getIntent();
        image_drawable=i.getExtras().getInt("image_id");
        photoview.setImageResource(image_drawable);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        photoview.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        photoview.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
        photoview.setAdjustViewBounds(false);
        photoview.setScaleType(ImageView.ScaleType.FIT_XY);
    }
}
