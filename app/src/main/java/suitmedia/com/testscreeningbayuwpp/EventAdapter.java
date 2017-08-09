package suitmedia.com.testscreeningbayuwpp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Bayu WPP on 8/8/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Event> events;
    private static Context context;
    private static Activity activity;

    public EventAdapter(ArrayList eventList, Context context) {
        this.events = eventList;
        this.context = context;
        this.activity = (Activity) context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new EventHolder(inflater.inflate(R.layout.adapter_event, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((EventHolder) holder).bindData(events.get(position));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class EventHolder extends RecyclerView.ViewHolder {
        ImageView imageViewEvent;
        TextView textViewEventName;
        TextView textViewEventDate;
        public EventHolder(View inflate) {
            super(inflate);
            imageViewEvent = (ImageView) inflate.findViewById(R.id.adapterevent_imageview_eventimage);
            textViewEventDate= (TextView) inflate.findViewById(R.id.adapterevent_textview_eventdate);
            textViewEventName = (TextView) inflate.findViewById(R.id.adapterevent_textview_eventname);
            inflate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("eventName",events.get(getAdapterPosition()).getName());
                    activity.setResult(Activity.RESULT_OK, intent);
                    activity.finish();
                }
            });
        }
        void bindData(Event event){
            imageViewEvent.setBackgroundResource(event.getImage());
            textViewEventDate.setText(event.getDate());
            textViewEventName.setText(event.getName());
        }
    }
}
