package com.zyhp.restaurantmanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.adapter.MemberRecyclerViewAdapter;
import com.zyhp.restaurantmanagement.entity.Member;
import com.zyhp.restaurantmanagement.utils.FileViewer;
import com.zyhp.restaurantmanagement.utils.GetDialog;
import com.zyhp.restaurantmanagement.utils.GetString;
import com.zyhp.restaurantmanagement.utils.MyShow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */

public class MemberSetActivity extends BaseActivity implements View.OnClickListener {
    private TextView view_publictitle_title;

    private RelativeLayout view_publictitle_back;

    SwipeRefreshLayout activity_memberset_SwipeRefreshLayout;
    RecyclerView activity_memberset_recyclerView;
    MemberRecyclerViewAdapter memberRecyclerViewAdapter;
    List<Member> memberList;
    Activity activity;
    LinearLayoutManager linearLayoutManager;
    private MediaPlayer mediaPlayer;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            final int position = msg.arg1;
            Member member = memberList.get(position);
            if (msg.what == 0) {
                startActivity(new Intent(activity, MemberDetialsActivity.class).putExtra("member", member));
            } else if (msg.what == 1) {
                GetDialog.IsOperation(activity, "删除会员", "您确定要删除会员" + member.getName() + "吗", new GetDialog.IsOperationInterface() {
                    @Override
                    public void isOperation() {
                        memberList.remove(position);
                        memberRecyclerViewAdapter.notifyDataSetChanged();
                    }
                });

            } else {

                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                }
                List<Member> temp = new ArrayList();
                for (int i = 0; i < 10; i++) {
                    temp.add(new Member("新增的" + i, GetString.createRandom(true, 10), GetString.createRandom(true, 4), GetString.createRandom(true, 4)));
                }
                memberList.addAll(0, temp);
                memberRecyclerViewAdapter.notifyItemRangeInserted(0, 10);
                MyShow.myToash(activity, "刷新成功");
                activity_memberset_SwipeRefreshLayout.setRefreshing(false);
                linearLayoutManager.scrollToPositionWithOffset(0, 0);

            }


        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberset);
        activity = MemberSetActivity.this;
        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("会员管理");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);
        activity_memberset_SwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_memberset_SwipeRefreshLayout);
        activity_memberset_recyclerView = (RecyclerView) findViewById(R.id.activity_memberset_recyclerView);
        mediaPlayer = MediaPlayer.create(activity, R.raw.weibo);
        memberList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            memberList.add(new Member("秦五爷" + i, GetString.createRandom(true, 10), GetString.createRandom(true, 4), GetString.createRandom(true, 4)));

        }
         linearLayoutManager = new LinearLayoutManager(activity);
        activity_memberset_recyclerView.setLayoutManager(linearLayoutManager);
        memberRecyclerViewAdapter = new MemberRecyclerViewAdapter(memberList, handler);

        activity_memberset_SwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                activity_memberset_SwipeRefreshLayout.setRefreshing(true);

                handler.sendEmptyMessageDelayed(2, 2000);//延迟两秒 模拟正在加载
            }
        });
        activity_memberset_recyclerView.setAdapter(memberRecyclerViewAdapter);

        activity_memberset_recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.view_publictitle_back:
                finish();
                break;

        }
    }
}
