package com.example.dormmanage.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dormmanage.R;
import com.example.dormmanage.model.Visit;

import java.util.List;

public class VisitAdapter extends BaseAdapter {
    private List<Visit> visits;

    public VisitAdapter(List<Visit> visits) {
        this.visits = visits;
    }

    @Override
    public int getCount() {
        return visits.size();
    }

    @Override
    public Visit getItem(int position) {
        return visits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_visit, parent, false);
            holder = new ViewHolder();

            holder.tveName = convertView.findViewById(R.id.visit_name);
            holder.tveTime = convertView.findViewById(R.id.visit_time);
            holder.tveTel = convertView.findViewById(R.id.visit_tel);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Visit visit = visits.get(position);
        holder.tveName.setText(visit.getVisitName());
        holder.tveTime.setText(String.valueOf(visit.getVisitTime()));
        holder.tveTel.setText(String.valueOf(visit.getVisitTel()));
        return convertView;
    }
    static class ViewHolder {
        TextView tveName;
        TextView tveTime;
        TextView tveTel;

    }
}
