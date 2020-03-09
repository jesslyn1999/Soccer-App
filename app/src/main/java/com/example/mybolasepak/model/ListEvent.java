package com.example.mybolasepak.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ListEvent {
    private List<Event> events;
}
