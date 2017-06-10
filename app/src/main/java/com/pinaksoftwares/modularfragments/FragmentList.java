package com.pinaksoftwares.modularfragments;

import android.app.Fragment;
import android.content.ComponentName;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentList extends Fragment implements AdapterView.OnItemClickListener{

    ListView lv_list;
    Communicator communicator;
    Integer i;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        if (savedInstanceState != null){
            i = savedInstanceState.getInt("position",0);
            //communicator.respond(i);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        communicator = (Communicator) getActivity();

        lv_list = (ListView) getActivity().findViewById(R.id.lv_fragment_list);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),R.array.list,android.R.layout.simple_expandable_list_item_1);
        lv_list.setAdapter(adapter);
        lv_list.setOnItemClickListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position",i);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        i = position;
        communicator.respond(i);
    }
}
