package com.dygame.mygooglemobileadstester;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * A simple {@link Activity} that embeds an AdView.
 */
public class BannerSample extends Activity
{
  /** The view to show the ad. */
  private AdView adView;
  protected Button quitButton ;
  /* Your ad unit id. Replace with your actual ad unit id. */
  private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/6300978111" ;
//String s = getString(R.string.banner_ad_unit_id) ;//���?

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_adview);

    // Create an ad.
    adView = new AdView(this);
    adView.setAdSize(AdSize.BANNER);
    adView.setAdUnitId(AD_UNIT_ID);

    // Add the AdView to the view hierarchy. The view will have no size
    // until the ad is loaded.
    LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
    layout.addView(adView);

    // Create an ad request. Check logcat output for the hashed device ID to
    // get test ads on a physical device.
    AdRequest adRequest = new AdRequest.Builder()
        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//          .addTestDevice("INSERT_YOUR_HASHED_DEVICE_ID_HERE")
        .build();

    // Start loading the ad in th  background.
    adView.loadAd(adRequest);
    /**
     *
     */
    quitButton = (Button)findViewById(R.id.quit) ;
    quitButton.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        finish();
      }
    });
  }

  @Override
  public void onResume()
  {
    super.onResume();
    if (adView != null)
    {
      adView.resume();
    }
  }

  @Override
  public void onPause()
  {
    if (adView != null)
    {
      adView.pause();
    }
    super.onPause();
  }

  /** Called before the activity is destroyed. */
  @Override
  public void onDestroy()
  {
    // Destroy the AdView.
    if (adView != null)
    {
      adView.destroy();
    }
    super.onDestroy();
  }
}
