package com.toweroy.microm;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Date;

public class TaskFragment extends ListFragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public TaskFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TaskFragment newInstance(int sectionNumber) {
        TaskFragment fragment = new TaskFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        String[] values = new String[]{"Android", "iPhone", "WindowsMobile",
//                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//                "Linux", "OS/2"};
        TaskItem[] values = new TaskItem[]{new TaskItem.TaskItemBuilder(new Date(), "Sleep", "Being lazy", 60).updated(new Date()).build(),
                new TaskItem.TaskItemBuilder(new Date(), "Work", "Work, Work!", 500).updated(new Date()).build(),
                new TaskItem.TaskItemBuilder(new Date(), "Reading", "Not", 600).updated(new Date()).build(),
                new TaskItem.TaskItemBuilder(new Date(), "Eat", "Being fat", 60).updated(new Date()).build(),
                new TaskItem.TaskItemBuilder(new Date(), "Exercise", "Yeah right...", 60).updated(new Date()).build()};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_list_item_1, values);
        TaskArrayAdapter adapter = new TaskArrayAdapter(this.getActivity(), values);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO implement some logic
    }
}
