package com.example.listviews.data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class ImageDownloadTask extends AsyncTask<String, Void, Bitmap> {

    ImageView imageView;

    public ImageDownloadTask(ImageView imageView) {
        this.imageView = imageView;
    }

    protected Bitmap doInBackground(String... params) {
        try {
            InputStream in = new java.net.URL(params[0]).openStream();
            return BitmapFactory.decodeStream(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
    }
}
