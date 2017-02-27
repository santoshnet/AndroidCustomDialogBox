package com.santoshnet.customdialogbox;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BAPUNU on 27-02-2017.
 */

public class SeatAdapter extends RecyclerView.Adapter<SeatAdapter.MyViewHolder> {

    Context mContext;
    private List<Seat> seatList;

    public SeatAdapter(List<Seat> seatList) {
        this.seatList = seatList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.seat_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Seat seat = seatList.get(position);
        holder.seatNo.setText(seat.getSeatNo());
        holder.seatNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return seatList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView seatNo;

        public MyViewHolder(View view) {
            super(view);
            seatNo = (TextView) view.findViewById(R.id.l_seatNo);

        }
    }
}