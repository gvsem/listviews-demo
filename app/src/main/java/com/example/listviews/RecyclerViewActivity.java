package com.example.listviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.listviews.data.Dialog;
import com.example.listviews.data.DialogService;
import com.example.listviews.recyclerview.DialogAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView listview;
    private DialogAdapter dialogAdapter;
    private List<Dialog> dialogs = new ArrayList<>();

    private final DialogService dialogService = new DialogService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        listview = findViewById(R.id.recyclerview);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        listview.setLayoutManager(mLayoutManager);

        dialogAdapter = new DialogAdapter(dialogs);
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
                dialogAdapter.notifyDataSetChanged();
            });
        }).start();
    }

}