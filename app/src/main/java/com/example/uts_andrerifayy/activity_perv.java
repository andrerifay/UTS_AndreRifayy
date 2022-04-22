package com.example.uts_andrerifayy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class activity_perv extends AppCompatActivity {

    public static ArrayList<Shape> shapeList = new ArrayList<Shape>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perv);

        setupData();
        setUpList();
        setUpOnclickListener();
    }

    private void setupData()
    {
        Shape aoitodo = new Shape("0", "Aoi Todo        Tingkat 2", R.drawable.aoitodo);
        shapeList.add(aoitodo);

        Shape gojosatoru = new Shape("1","Gojo Satoru         Tingkat Spesial", R.drawable.gojosatoru);
        shapeList.add(gojosatoru);

        Shape mahito = new Shape("2","Mahito        Kutukan Spesial", R.drawable.mahito);
        shapeList.add(mahito);

        Shape jogo = new Shape("3","Jogo           Kutukan Spesial", R.drawable.jogo);
        shapeList.add(jogo);

        Shape inumaki = new Shape("4", "Inumaki       Tingkat 3", R.drawable.inumaki);
        shapeList.add(inumaki);

        Shape kentonanami = new Shape("5","Kento Nanami     Tingkat 1", R.drawable.kentonanami);
        shapeList.add(kentonanami);

        Shape makizenin= new Shape("6","Maki Zenin           Tingkat 3", R.drawable.makizenin);
        shapeList.add(makizenin);

        Shape toji = new Shape("7","Toji            Tingkat Spesial", R.drawable.toji);
        shapeList.add(toji);

        Shape sukuna = new Shape("8","Sukuna           Tingkat Spesial", R.drawable.sukuna);
        shapeList.add(sukuna);

        Shape yutaokotsu = new Shape("9","Yuta             Tingkat Spesial", R.drawable.yutaokotsu);
        shapeList.add(yutaokotsu);
    }

    private void setUpList()
    {
        listView = (ListView) findViewById(R.id.shapesListView);

        activity_perv_adapter adapter = new activity_perv_adapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Shape selectShape = (Shape) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), activity_perv_detail.class);
                showDetail.putExtra("id",selectShape.getId());
                startActivity(showDetail);
            }
        });

    }
}