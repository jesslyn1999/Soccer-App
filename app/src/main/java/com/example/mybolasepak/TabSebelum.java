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
import com.example.mybolasepak.modellist.Event;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabSebelum#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabSebelum extends Fragment {

    private RecyclerView recyclerView;
    private EventDetailAdapter adapter;

    // TODO: Rename and change types of parameters
    private ArrayList<EventDbModel> events;

    public TabSebelum() {
        // Required empty public constructor
    }


    public static TabSebelum newInstance(ArrayList<Event> events) {
        TabSebelum fragment = new TabSebelum();
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
        View view = inflater.inflate(R.layout.fragment_tab_sebelum, container, false);
        recyclerView = view.findViewById(R.id.list_match_sebelum);
        adapter = new EventDetailAdapter(events);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
