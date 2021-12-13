package com.example.oggym.ui.login;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.oggym.R;
import com.example.oggym.image.ImageMaker;

public class QRView extends AppCompatActivity {
    Bitmap image = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        image = ImageMaker.imageDecode();
        imageRequest();
        ImageView imgViewer = (ImageView) findViewById(R.id.qr_code);
        imgViewer.setImageBitmap(image);

    }

    private void imageRequest () {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://www.google.com/search?q=server&rlz=1C1GCEU_etEE969EE969&sxsrf=AOaemvJi5th9HDQj8CnmZ3eFEcy9M0EGaA:1639392168928&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjshYHfy-D0AhWRuYsKHdv0C3YQ_AUoAXoECAIQAw&biw=1280&bih=913&dpr=1#imgrc=iU5iO35HVH7ATM";
        Toast.makeText(this,"Debug", Toast.LENGTH_LONG).show();
            // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.e("Response is: ", response.substring(0,500));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Debug","Error while making webrequest");
            }
        });
    }
}