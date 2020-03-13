package com.example.mybolasepak.modellist;

import com.example.mybolasepak.database.model.TeamDbModel;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class TeamList {
    private ArrayList<TeamDbModel> teams;
}
