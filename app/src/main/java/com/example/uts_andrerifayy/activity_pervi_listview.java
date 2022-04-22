package com.example.uts_andrerifayy;

import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class activity_pervi_listview extends Fragment {

    public activity_pervi_listview(){

    }

    public static ArrayList<Shape> shappeList = new ArrayList<Shape>();
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_pervi_listview, container, false);
        setupData();

        listView = v.findViewById(R.id.shapeListview);
        activity_pervi_listview_cell adapter = new activity_pervi_listview_cell(getContext(), 0, shappeList);
        listView.setAdapter(adapter);

        setupOnClickListener();
        return v;
    }

    public void setupData(){
        Shape tsunade = new Shape("0", "Hokage         Kepala Desa Konohagakure", R.drawable.tsunade);
        shappeList.add(tsunade);

        Shape raikage = new Shape("1", "Raikage         Kepala Desa Kumogakure", R.drawable.raikage);
        shappeList.add(raikage);

        Shape kazekage = new Shape("2", "Kazekage        Kepala Desa Tsunagakure", R.drawable.kazekage);
        shappeList.add(kazekage);

        Shape mizukage = new Shape("3", "Mizukage        Kepala Desa Kirigakure", R.drawable.mizukage);
        shappeList.add(mizukage);

        Shape tsucikage = new Shape("4", "Tsucikage        Kepala Desa Iwagakure", R.drawable.tsucikage);
        shappeList.add(tsucikage);

    }

    private void setupOnClickListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Shape selectShape = (Shape) listView.getItemAtPosition(i);
                Intent showDetail = new Intent(getContext(), activity_pervi_listview_detail.class);
                showDetail.putExtra("id", selectShape.getId());
                startActivity(showDetail);
            }
        });
    }
}
