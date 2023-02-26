package com.example.listviews.recyclerview;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listviews.R;
import com.example.listviews.data.Dialog;
import com.example.listviews.data.ImageDownloadTask;

import java.util.List;

public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.ViewHolder> {

    private final List<Dialog> dialogs;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTextview;
        private final TextView textTextview;
        private final ImageView avatarView;

        public ViewHolder(View view) {
            super(view);
            titleTextview = (TextView) view.findViewById(R.id.dialog_title);
            textTextview = (TextView) view.findViewById(R.id.dialog_text);
            avatarView = (ImageView) view.findViewById(R.id.avatarView);
        }

        public void setDialog(Dialog dialog) {
            titleTextview.setText(dialog.title);
            textTextview.setText(dialog.lastMessage);
            new ImageDownloadTask(avatarView).execute(dialog.imageUrl);
        }
    }

    public DialogAdapter(List<Dialog> dialogs) {
        this.dialogs = dialogs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.dialog_row_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.setDialog(dialogs.get(position));
    }

    @Override
    public int getItemCount() {
        return dialogs.size();
    }
}

