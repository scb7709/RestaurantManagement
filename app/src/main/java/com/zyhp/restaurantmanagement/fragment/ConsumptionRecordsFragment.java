package com.zyhp.restaurantmanagement.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.entity.ConsumptionRecords;
import com.zyhp.restaurantmanagement.utils.GetString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/22.
 */

public class ConsumptionRecordsFragment extends Fragment {

    TableLayout fragment_recordsofconsumption_tableLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recordsofconsumption, container, false);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragment_recordsofconsumption_tableLayout = (TableLayout) view.findViewById(R.id.fragment_recordsofconsumption_tableLayout);
        fragment_recordsofconsumption_tableLayout.setStretchAllColumns(true);//设置所有的item都可伸缩扩展
        fragment_recordsofconsumption_tableLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);//设置分割线为中间显示
        buildTable();
    }


    public void buildTable() {
        List<ConsumptionRecords> consumptionRecordses = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            switch (i % 3) {
                case 0:
                    consumptionRecordses.add(new ConsumptionRecords("2018-07-10", GetString.createRandom(true, 4), "充值", "无"));
                    break;
                case 1:
                    consumptionRecordses.add(new ConsumptionRecords("2018-07-06", GetString.createRandom(true, 4), "现场就餐", "无"));
                    break;
                case 2:
                    consumptionRecordses.add(new ConsumptionRecords("2018-07-07", GetString.createRandom(true, 4), "外卖订单", "无"));
                    break;
            }

        }
        for (int i = 0; i < 100; i++) {
            ConsumptionRecords item = consumptionRecordses.get(i);//获取单行数据
            View layout = LayoutInflater.from(getActivity()).inflate(R.layout.tablelayout_item_recordsofconsumption  , null);//
            TextView time = (TextView) layout.findViewById(R.id.tablelayout_item_recordsofconsumption_time);
            TextView type = (TextView) layout.findViewById(R.id.tablelayout_item_recordsofconsumption_type);
            TextView money = (TextView) layout.findViewById(R.id.tablelayout_item_recordsofconsumption_money);
            TextView remarks = (TextView) layout.findViewById(R.id.tablelayout_item_recordsofconsumption_remarks);
            time.setText(item.getTime());
            type.setText(item.getType());
            money.setText(item.getMoney());
            remarks.setText(item.getRemarks());
            fragment_recordsofconsumption_tableLayout.addView(layout);//将这一行加入表格中
        }
    }
}
