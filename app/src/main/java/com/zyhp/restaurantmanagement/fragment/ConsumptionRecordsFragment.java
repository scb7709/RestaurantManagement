package com.zyhp.restaurantmanagement.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.zyhp.restaurantmanagement.R;


/**
 * Created by Administrator on 2018/6/22.
 */

public class ConsumptionRecordsFragment extends Fragment {

ListView fragment_recordsofconsumption_listview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memberinformation, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragment_recordsofconsumption_listview=(ListView) view.findViewById(R.id.fragment_recordsofconsumption_listview);


    }

}
