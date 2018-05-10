package com.example.nishan.retrofit.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.nishan.retrofit.Model.Actor;
import com.example.nishan.retrofit.R;

import java.util.List;

public class ActorListAdapter extends ArrayAdapter<Actor>{
   private Context context;
   private List<Actor> actors;

   public ActorListAdapter(Context context, List<Actor> actors){
        super(context, R.layout.actor_row_layout, actors);
        this.context = context;
        this.actors = actors;
   }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.actor_row_layout, parent, false);

        Actor actor = actors.get(position);
        TextView textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        textViewName.setText("Name:"+actor.getName());
        TextView textViewDetails = (TextView) convertView.findViewById(R.id.textViewDetails);
        textViewDetails.setText("Details:"+actor.getDetails());
        TextView textViewCategory = (TextView) convertView.findViewById(R.id.textViewCategory);
        textViewCategory.setText("Category:"+actor.getCategory());

        return convertView;
   }
}
