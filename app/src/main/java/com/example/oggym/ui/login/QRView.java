package com.example.oggym.ui.login;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        String url ="https://et.wikipedia.org/wiki/Server#/media/Fail:Serverarvuti.jpg";
        Toast.makeText(this,"Debug", Toast.LENGTH_LONG).show();
            // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.e("Response is: ", response.substring(0,500));
                        callback.onSuccess(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Debug","Error while making webrequest");
            }
        });
    }
}