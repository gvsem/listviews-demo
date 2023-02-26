package com.example.listviews;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listviews.data.Dialog;
import com.example.listviews.data.DialogService;
import com.example.listviews.listview.DialogAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView listview;
    private DialogAdapter dialogAdapter;
    private List<Dialog> dialogs = new ArrayList<>();

    private final DialogService dialogService = new DialogService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listview = findViewById(R.id.listview);

        dialogAdapter = new DialogAdapter(getApplicationContext(), dialogs);
        listview.setAdapter(dialogAdapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onResume() {
        super.onResume();
        dialogs.clear();
        new Thread(() -> {
            List<Dialog> newDialogs = dialogService.getDialogs();
            runOnUiThread(() -> {
                dialogs.clear();
                dialogs.addAll(newDialogs);
                dialogAdapter.notifyDataSetInvalidated();
            });
        }).start();
    }

}