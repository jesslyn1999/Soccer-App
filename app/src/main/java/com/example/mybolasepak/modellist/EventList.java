package com.example.mybolasepak.modellist;

import com.example.mybolasepak.database.model.EventDbModel;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class EventList {
    private ArrayList<EventDbModel> events;
}
