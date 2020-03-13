package com.example.mybolasepak;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mybolasepak.adapter.EventDetailAdapter;
import com.example.mybolasepak.database.model.EventDbModel;
import com.example.mybolasepak.model.Event;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabSekarang extends Fragment {

    private RecyclerView recyclerView;
    private EventDetailAdapter adapter;

    private ArrayList<EventDbModel> events;

    public TabSekarang() {
        // Required empty public constructor
    }

    public static TabSekarang newInstance(ArrayList<Event> events) {
        TabSekarang fragment = new TabSekarang();
        Bundle args = new Bundle();
        args.putParcelableArrayList("ARG_PARAM1", events);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            events =  getArguments().getParcelableArrayList("ARG_PARAM1");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_sekarang, container, false);
        recyclerView = view.findViewById(R.id.list_match_sekarang);
        adapter = new EventDetailAdapter(events);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
