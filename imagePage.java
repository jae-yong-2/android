package com.example.houseapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class imagePage extends Activity {               //이미지로 넘어갔을때 페이지

    LinkedList<String> list=new LinkedList<String>();

    ListView listView;
    ImageView imageView;
    int message;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        listView = findViewById(R.id.listView);
        imageView=findViewById(R.id.text_text_view);


        Intent intent = getIntent();
        message=intent.getIntExtra("position",0);
        imageView.setImageURI(Uri.parse(ImageFile.getImage()[message]));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);     //리스트로 댓글 구현
        listView.setAdapter(adapter);      //클릭이벤트 함수
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        listView.setOnItemClickListener(listener);
    }
    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {              //리스트 클릭 이벤트
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getApplicationContext(),"test",Toast.LENGTH_SHORT);
        }
    };
}
