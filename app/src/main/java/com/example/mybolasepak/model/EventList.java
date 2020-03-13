package com.example.mybolasepak.model;

import com.example.mybolasepak.database.model.EventDbModel;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class EventList {
    private ArrayList<EventDbModel> events;
}
