package com.toweroy.microm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TaskArrayAdapter extends ArrayAdapter<TaskItem> {
    private final Context context;
    private final TaskItem[] values;

    public TaskArrayAdapter(Context context, TaskItem[] values) {
        super(context, R.layout.rowlayout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
        TextView headerTextView = (TextView) rowView.findViewById(R.id.header);
        headerTextView.setText(values[position].getName());
        // Set task description
        TextView descriptionTextView = (TextView) rowView.findViewById(R.id.description);
        descriptionTextView.setText(values[position].getDescription());
        // Set current time spent interval
        TextView currentTimeSpentIntervalTextView = (TextView) rowView.findViewById(R.id.time_spent_interval);
        currentTimeSpentIntervalTextView.setText("15 mins");
        // Change the icon for Windows and iPhone
//            String s = values[position];
//            if (s.startsWith("Windows7") || s.startsWith("iPhone")
//                    || s.startsWith("Solaris")) {
//                imageView.setImageResource(R.drawable.no);
//            } else {
//                imageView.setImageResource(R.drawable.ok);
//            }

        return rowView;
    }
}
