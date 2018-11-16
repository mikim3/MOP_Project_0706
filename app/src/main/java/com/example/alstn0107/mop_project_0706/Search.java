package com.example.alstn0107.mop_project_0706;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Search extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pill_search);

        Toast.makeText(getApplicationContext(), "nav_pill_search클릭후 onCreate실행", Toast.LENGTH_SHORT).show();

        // 액션바에 이화면의 이름을 나타내는 부분을 수정해줍니다.
        ActionBar ab = getSupportActionBar() ;
        ab.setTitle("ActionBar Title by setTitle()") ;

        ImageButton search_button=(ImageButton) findViewById(R.id.search_button);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //검색이 완료된 페이지로 가야합니다.

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bookmark, menu);
        return true;
    }

}
