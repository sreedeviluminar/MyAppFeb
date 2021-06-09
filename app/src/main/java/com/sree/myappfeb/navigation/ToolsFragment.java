package com.sree.myappfeb.navigation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.sree.myappfeb.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToolsFragment extends Fragment {


    public ToolsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((NavActivity)getActivity()).setActionBarTitle("TOOLS");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tools, container, false);
    }

}
