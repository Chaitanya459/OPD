package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Handler;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    ListView myList;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        searchView = findViewById(R.id.mySearch);
        myList =findViewById(R.id.mylist);
        list = new ArrayList<String>();
        list.add("Yashoda Hospitals");
        list.add("KIMs Hospital");
        list.add("Omni Hospitals");
        list.add("Apollo Hospitals");
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        myList.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                              @Override
                                              public boolean onQueryTextSubmit(String query) {
                                                  return false;
                                              }

                                              @Override
                                              public boolean onQueryTextChange(String newText) {
                                                  adapter.getFilter().filter(newText);
                                                  return false;
                                              }
                                          });
        adapter = new ArrayAdapter<>(this,android.R.layout.activity_list_item,android.R.id.text1,list);
        myList.setAdapter(adapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intenta=new Intent(MainActivity.this,aactivity.class);
                    startActivity(intenta);
                }
                if(position==1){
                    Intent intentb=new Intent(MainActivity.this,bactivity.class);
                    startActivity(intentb);
                }
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "No Notifications Currently", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        Toast.makeText(getApplicationContext(), "Your Are Already In Home Page", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_Reports:
                        Intent intent1=new Intent(MainActivity.this,ThirdActivity.class);
                        startActivity(intent1);
                        Toast toast=Toast.makeText(getApplicationContext(), "Please atleast Visit One hospital to See Your Reports ", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                        break;
                    case R.id.nav_notifications:
                        Toast.makeText(getApplicationContext(), "No Notifications for you Currently", Toast.LENGTH_LONG).show();
                        Intent intent2=new Intent(MainActivity.this,FourthActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_Profile:

                        Intent intent3=new Intent(MainActivity.this,SixthActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_Payments:
                        Toast.makeText(getApplicationContext(), "NO Previous Payements", Toast.LENGTH_LONG).show();
                        Intent intent4=new Intent(MainActivity.this,SeventhActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.nav_YourBookings:
                        Intent intent5=new Intent(MainActivity.this,feedbackActivity.class);
                        startActivity(intent5);

                }

                return false;
            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
