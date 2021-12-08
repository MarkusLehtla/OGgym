package com.example.oggym.ui.login;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import com.example.oggym.R;
import com.example.oggym.image.ImageMaker;

public class QRView extends AppCompatActivity {
    Bitmap image = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        image = ImageMaker.imageDecode();

        ImageView imgViewer = (ImageView) findViewById(R.id.qr_code);
        imgViewer.setImageBitmap(image);

    }
}