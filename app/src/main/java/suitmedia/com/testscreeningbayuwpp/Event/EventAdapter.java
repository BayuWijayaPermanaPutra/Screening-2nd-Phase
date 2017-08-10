package suitmedia.com.testscreeningbayuwpp.Event;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

import suitmedia.com.testscreeningbayuwpp.R;

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
        TextView textViewEventDesc;
        LinearLayout linearLayoutEventTags;

        public EventHolder(View inflate) {
            super(inflate);
            imageViewEvent = (ImageView) inflate.findViewById(R.id.adapterevent_imageview_eventimage);
            textViewEventDate= (TextView) inflate.findViewById(R.id.adapterevent_textview_eventdate);
            textViewEventName = (TextView) inflate.findViewById(R.id.adapterevent_textview_eventname);
            textViewEventDesc = (TextView) inflate.findViewById(R.id.adapterevent_textview_eventdescription);
            linearLayoutEventTags = (LinearLayout) inflate.findViewById(R.id.adapterevent_linear_eventtag);
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

            String[] tags = event.getTags().split(",");

            final int N = tags.length;
            final TextView[] myTextViews = new TextView[N];
            for (int i = 0; i < N; i++) {
                final TextView rowTextView = new TextView(context);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(0,5,5,5);
                rowTextView.setText("#"+tags[i]);
                rowTextView.setTextColor(Color.WHITE);
                rowTextView.setBackgroundColor(Color.parseColor("#9FA8DA"));
                rowTextView.setPadding(5,5,5,5);
                rowTextView.setLayoutParams(params);
                linearLayoutEventTags.addView(rowTextView);
                myTextViews[i] = rowTextView;
            }
            textViewEventName.setText(event.getName());
            if(event.getDescription().length() > 85) {
                textViewEventDesc.setText(Html.fromHtml(event.getDescription().substring(0,37)+"...."));
            }else{
                textViewEventDesc.setText(Html.fromHtml(event.getDescription()));
            }

        }
    }
}
