package com.androyen.photogallery;

import android.media.session.MediaSession;
import android.os.HandlerThread;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by rnguyen on 11/13/14.
 */
public class ThumbnailDownloader<Token> extends HandlerThread {

    private static final String TAG = "ThumbnailDownloader";

    public ThumbnailDownloader() {
        super(TAG);
    }



    public void queueThumbnail(Token token, String url) {
        Log.i(TAG, "Got an URL: " + url);
    }
}
