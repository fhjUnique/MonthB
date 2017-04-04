package com.bwie.text.monthb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.bwie.text.monthb.adapter.RSimpAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/4/4.
 */

public class Fragment1 extends Fragment implements OnChildclickListener {


    private View view;
    private RecyclerView recyclerView;
    private List<String> list  = new ArrayList<>();
    private FragmentManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment1, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        manager = getActivity().getSupportFragmentManager();
        for (int i = 0; i < 10; i++) {
            list.add("条目"+i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RSimpAdapter rSimpAdapter = new RSimpAdapter(getActivity(), list);
        //注册
        rSimpAdapter.setOnChildClickListener(this);
        recyclerView.setAdapter(rSimpAdapter);
        manager.beginTransaction().add(R.id.fl,new Fragment2()).commit();

    }

    /**
     *   业务操作
     */
    @Override
    public void onChildClick(int position) {
        //创建右边fragment
        manager.beginTransaction().replace(R.id.fl,new Fragment2()).commit();
    }
}
