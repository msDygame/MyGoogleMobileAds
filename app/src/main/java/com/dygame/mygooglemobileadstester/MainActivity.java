package com.dygame.mygooglemobileadstester;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity
{
    protected Button AdViewButton ;
    protected Button InterstitialButton ;
    protected Button QuitButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdViewButton = (Button)findViewById(R.id.showButtonAdview) ;
        InterstitialButton = (Button)findViewById(R.id.showButtonInterstitial);
        QuitButton = (Button)findViewById(R.id.quit) ;
        AdViewButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                jumpAdview();
            }
        });
        InterstitialButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                jumpInterstitialAds() ;
            }
        });
        QuitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     *
     */
    public void jumpAdview()
    {
        //newintentン﹚Activityち传class
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, BannerSample.class) ;
        //ち传Activity
        startActivity(intent);
    }
    public void jumpInterstitialAds()
    {
        //newintentン﹚Activityち传class
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, InterstitialSample.class) ;
        //ち传Activity
        startActivity(intent);
    }
}
