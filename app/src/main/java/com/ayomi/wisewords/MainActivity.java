package com.ayomi.wisewords;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.nav_view);

        mNavigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);
        mNavigationView.setCheckedItem(R.id.nav_home);

    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_wisdom_quotes:
                Intent wisdomIntent = new Intent(MainActivity.this, WisdomQuote.class);
                startActivity(wisdomIntent);
                break;
            case R.id.nav_motivational:
                Intent motivationIntent = new Intent(MainActivity.this, Motivational.class);
                startActivity(motivationIntent);
                break;
            case R.id.nav_write_ups:
                Intent writeupIntent = new Intent(MainActivity.this, WriteUp.class);
                startActivity(writeupIntent);
                break;
            case R.id.nav_stories:
                Intent storiesIntent = new Intent(MainActivity.this, Stories.class);
                startActivity(storiesIntent);
                break;
            case R.id.nav_app_info:
                appInfo();
                break;
            case R.id.nav_changelog:
               changeLog();
                break;
            case R.id.nav_survey:
                Toast.makeText(this, "Clicked Survey", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Clicked Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_rate:
                Toast.makeText(this, "Clicked Rate", Toast.LENGTH_SHORT).show();
                break;
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void wisdomQuotes(View view) {
        Toast.makeText(this, "Wisdom Quote clicked", Toast.LENGTH_SHORT).show();
    }

    public void otherApps(View view) {
        Toast.makeText(this, "Other App clicked", Toast.LENGTH_SHORT).show();
    }

    public void about(View view) {
        Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show();
    }

    public void stories(View view) {
        Toast.makeText(this, "Stories clicked", Toast.LENGTH_SHORT).show();
    }

    public void writeUps(View view) {
        Toast.makeText(this, "WriteUps clicked", Toast.LENGTH_SHORT).show();
    }

    public void motivationalQuotes(View view) {
        Toast.makeText(this, "Motivational Quote clicked", Toast.LENGTH_SHORT).show();
    }

    private void changeLog() {

        AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View myview = inflater.inflate(R.layout.change_log, null);

        mydialog.setView(myview);

        final AlertDialog dialog = mydialog.create();

        dialog.setCancelable(true);

        dialog.show();

    }

    private void appInfo() {

        AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View myview = inflater.inflate(R.layout.app_info, null);

        mydialog.setView(myview);

        final AlertDialog dialog = mydialog.create();

        dialog.setCancelable(true);

        dialog.show();

    }

    private void appInformation() {
        new AlertDialog.Builder(this).setIcon(R.drawable.fuoye).setTitle("About Fsocial")
                .setMessage("Fsocial is a Social Media Application specifically Designed" +
                        " to meet the social needs of Fuoye Student and its a Medium where you can " +
                        "connect and chat with fuoye student both in Oye and Ikole Campus" +
                        "(Aspirant who also wants to know more about Fuoye can Join ) Feel free to explore the Application" + "\n" + "\n" + "Version 2.1.0" + "\n" + "\n" + "\n" + " © 2020 Fsocial")
                .setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onStart();
                    }
                }).create().show();
    }
}