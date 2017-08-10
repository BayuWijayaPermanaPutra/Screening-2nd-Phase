package suitmedia.com.testscreeningbayuwpp.Event;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import suitmedia.com.testscreeningbayuwpp.R;

/**
 * Created by Bayu WPP on 8/10/2017.
 */

public class EventImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Event> events;
    private static Context context;
    private static Activity activity;

    public EventImageAdapter(ArrayList<Event> events, Context context) {
        this.events = events;
        this.context = context;
        this.activity = (Activity) context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new EventImageHolder(inflater.inflate(R.layout.adapter_eventimage, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((EventImageHolder) holder).bindData(events.get(position));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    private class EventImageHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public EventImageHolder(View inflate) {
            super(inflate);
            inflate.setClickable(true);
            imageView = (ImageView) inflate.findViewById(R.id.adaptereventimage_imageview_eventimage);
            textView = (TextView) inflate.findViewById(R.id.adaptereventimage_textview_eventname);
        }

        public void bindData(Event event) {
            imageView.setBackgroundResource(event.getImage());
            textView.setText(event.getName());
        }
    }
}
