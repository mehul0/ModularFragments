package com.pinaksoftwares.modularfragments;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Arrays;

public class FragmentDetail extends Fragment {

    TextView tv_description;
    int i;
    String data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        if(savedInstanceState == null){

        }
        else{
            tv_description = (TextView) view.findViewById(R.id.tv_fragment_detail);
            Resources resources = getResources();
            String[] description = resources.getStringArray(R.array.description);
            String m  = Arrays.toString(savedInstanceState.getStringArray("description"));
            data = savedInstanceState.getString("description");
            tv_description.setText(data);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv_description = (TextView) getActivity().findViewById(R.id.tv_fragment_detail);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Resources resources = getResources();
        String[] description = resources.getStringArray(R.array.description);
        data= description[i];
        outState.putString("description", data);
    }

    public void changeData(int i){
        Resources resources = getResources();
        String[] description = resources.getStringArray(R.array.description);
        tv_description.setText(description[i]);
    }
}
