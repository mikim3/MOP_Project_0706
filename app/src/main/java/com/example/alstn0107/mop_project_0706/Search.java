package com.example.alstn0107.mop_project_0706;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Search extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        ImageButton search_button=(ImageButton) findViewById(R.id.search_button); // search_button이 원래 아이디 인데 안떠요 왜 안뜨지?
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //검색이 완료된 페이지로 가야합니다.

            }
        });


    }
}
