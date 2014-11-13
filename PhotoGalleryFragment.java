package com.androyen.photogallery;

import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by rnguyen on 11/13/14.
 */
public class PhotoGalleryFragment extends Fragment {

    private static final String TAG = PhotoGalleryFragment.class.getSimpleName();

    GridView mGridView;
    ArrayList<GalleryItem> mItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //retain fragment on rotation
        setRetainInstance(true);

        //Run the async background task
        new FetchItemsTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_gallery, container, false);

        mGridView = (GridView)v.findViewById(R.id.gridView);

        //Set up GridView adapter to persist across device rotation
        setupAdapter();
        return v;
    }

    void setupAdapter() {
        if (getActivity() == null || mGridView == null) {
            return;
        }

        if (mItems != null) {
            mGridView.setAdapter(new ArrayAdapter<GalleryItem>(getActivity(), android.R.layout.simple_gallery_item, mItems));
        }
        else {
            mGridView.setAdapter(null);
        }
    }

    //AsyncTask to run network on the background thread
    private class FetchItemsTask extends AsyncTask<Void, Void, ArrayList<GalleryItem>> {

        @Override
        protected ArrayList<GalleryItem> doInBackground(Void... params) {
//            try {
//                String result = new FlickrFetchr().getUrl("http://www.google.com");
//                Log.i(TAG, "Fetched contents of URL: " + result);
//            }
//            catch (IOException e) {
//                Log.e(TAG, "Failed to fetch URL: " + e);
//            }

            return new FlickrFetchr().fetchItems();

        }

        @Override
        protected void onPostExecute(ArrayList<GalleryItem> items) {
            mItems = items;
            setupAdapter(); // Update the main UI thread of list of Flickr objects
        }
    }


}
