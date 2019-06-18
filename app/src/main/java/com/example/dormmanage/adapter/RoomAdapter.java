package com.example.dormmanage.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.dormmanage.R;
import com.example.dormmanage.model.Room;

public class RoomAdapter extends BaseAdapter {
    private List<Room> rooms;

    public RoomAdapter(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public int getCount() {
        return rooms.size();
    }

    @Override
    public Room getItem(int position) {
        return rooms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            holder = new ViewHolder();

            holder.tvName = convertView.findViewById(R.id.room_name);
            holder.tvExpectNumber = convertView.findViewById(R.id.room_expect);
            holder.tvRealNumber = convertView.findViewById(R.id.room_real);
            holder.tvCost = convertView.findViewById(R.id.room_cost);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Room room = rooms.get(position);
        holder.tvName.setText(room.getRoomName());
        holder.tvExpectNumber.setText(String.valueOf(room.getExpectNumber()));
        holder.tvRealNumber.setText(String.valueOf(room.getRealNumber()));
        holder.tvCost.setText(String.valueOf(room.getCost()));

        return convertView;
    }
    static class ViewHolder {
        TextView tvName;
        TextView tvExpectNumber;
        TextView tvRealNumber;
        TextView tvCost;

    }
}
