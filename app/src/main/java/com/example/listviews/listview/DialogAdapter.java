package com.example.listviews.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listviews.R;
import com.example.listviews.data.Dialog;
import com.example.listviews.data.ImageDownloadTask;

import java.util.List;

public class DialogAdapter extends ArrayAdapter<Dialog> {

    public DialogAdapter(Context context, List<Dialog> arr) {
        super(context, R.layout.dialog_row_item, arr);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Dialog dialog = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_row_item, null);
        }

        ((TextView) convertView.findViewById(R.id.dialog_title)).setText(dialog.title);
        ((TextView) convertView.findViewById(R.id.dialog_text)).setText(dialog.lastMessage);
        new ImageDownloadTask(((ImageView) convertView.findViewById(R.id.avatarView))).execute(dialog.imageUrl);

        return convertView;
    }

}
