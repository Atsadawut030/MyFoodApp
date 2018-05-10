package com.example.windows.myfoodapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //Explicit
    ListView listView;
    private int[] ints = new int[]{R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,
            R.drawable.food5,R.drawable.food6,R.drawable.food7,R.drawable.food8,R.drawable.food9,
            R.drawable.food10,R.drawable.food11,R.drawable.food12,R.drawable.food13,R.drawable.food14,
            R.drawable.food15,R.drawable.food16,R.drawable.food17,R.drawable.food18,R.drawable.food19,
            R.drawable.food20};

    private  String[] titleStrings, detailStrings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        //ดึงค่า XML ที่ไฟล์ my_content มาเเสดงผล
        titleStrings = getResources().getStringArray(R.array.title);
        detailStrings = getResources().getStringArray(R.array.detail);

        MyAdapter myAdapter = new MyAdapter(MainActivity.this, ints, titleStrings, detailStrings);
        listView.setAdapter(myAdapter);

        //เมื่อ Click เเต่ละ Item ใน ListView จะเชื่อมโยงไปหน้า Detail
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
                detailIntent.putExtra("Title", titleStrings[i]);
                detailIntent.putExtra("Detail", detailStrings[i]);
                detailIntent.putExtra("Image", ints[i]);
                startActivity(detailIntent);
            }
        });

    }//End Oncreate Method

    public void clickLink(View view)
    {
        Intent linkIntent = new Intent(Intent.ACTION_VIEW);
        linkIntent.setData(Uri.parse("https://cooking.kapook.com/"));
        startActivity(linkIntent);

    }//end clickLink Method


    public void clickAboutMe(View view) {
        Intent aboutmeIntent = new Intent(MainActivity.this, AboutMeActivity.class);
        startActivity(aboutmeIntent);
    }
}//End Class
