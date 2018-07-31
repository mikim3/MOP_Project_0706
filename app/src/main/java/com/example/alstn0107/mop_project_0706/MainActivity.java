package com.example.alstn0107.mop_project_0706;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*   리스트뷰를 띄운다 그 리스트 뷰는 왼쪽에 사진 오른쪽에 텍스트로 구성되어 있게끔 만들었다.
        setContentView(R.layout.image_main);   //list_layout 일수도 있음
        String[] items = {"개보린" "토마토 쥬스", "포도 쥬스"};
        ListAdapter adapter = new ImageAdapter(this, items); //현재해당하는 메인Activity객체가 class로써 this로 들어가는 것이고
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(i));
                        Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
                    }
                }
        );
        */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = (DrawerLayout) findViewById(R.id.main);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.main_navigationView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //오른쪽위에 있는 버튼을 누른후 무슨 항목이 나올지를 정해줍니다.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.// 네비게이션 눌렀을때 무슨 명령을 실행할지 정한다.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Toast.makeText(getApplicationContext(), "nav_camera원래카메라클릭", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_gallery) {
            Toast.makeText(getApplicationContext(), "nav_gallery", Toast.LENGTH_SHORT).show();


        } else if (id == R.id.nav_slideshow) {

            Toast.makeText(getApplicationContext(), "nav_slideshow", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_memo) {

            Toast.makeText(getApplicationContext(), "nav_memo", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_image_search) {

            Toast.makeText(getApplicationContext(), "nav_image_search", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_piil_search) {
            Toast.makeText(getApplicationContext(), "nav_pill_search클릭 낱알검색으로 갑니다.", Toast.LENGTH_SHORT).show();
            //화면을 전환할때 사용하는 클래스 첫 번째 인자 값은 이동전 activity 두번쨰는 이동할 액티비티 .class
            Intent intent= new Intent(MainActivity.this,Search.class);
            //화면전환하기  인자 intent가 화면전환에대한 정보를 가지고 있음
            startActivity(intent);
        } else if (id == R.id.nav_send) {

            Toast.makeText(getApplicationContext(), "nav_send", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}

