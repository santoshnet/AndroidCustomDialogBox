package com.santoshnet.customdialogbox;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Seat> seatList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SeatAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDoalog(View view) {
        // Create custom dialog object
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        // Include dialog.xml file
        dialog.setContentView(R.layout.dialog);

        // set values for custom dialog components - text, image and button
        recyclerView = (RecyclerView) dialog.findViewById(R.id.recycler_view);
        ImageView image = (ImageView) dialog.findViewById(R.id.image);
        image.setImageResource(R.drawable.images);
        dialog.show();
        Button proceed = (Button) dialog.findViewById(R.id.proceed);

        mAdapter = new SeatAdapter(seatList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
        // if decline button is clicked, close the custom dialog
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                dialog.dismiss();
            }
        });

    }

    private void prepareMovieData() {
        Seat seat = new Seat("1");
        seatList.add(seat);

        seat = new Seat("2");
        seatList.add(seat);
        seat = new Seat("3");
        seatList.add(seat);
        seat = new Seat("4");
        seatList.add(seat);
        seat = new Seat("5");
        seatList.add(seat);
        seat = new Seat("6");
        seatList.add(seat);

        mAdapter.notifyDataSetChanged();
    }
}
