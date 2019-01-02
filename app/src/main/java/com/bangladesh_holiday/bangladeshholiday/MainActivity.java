package com.bangladesh_holiday.bangladeshholiday;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.github.chrisbanes.photoview.PhotoView;
import com.whiteelephant.monthpicker.MonthPickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.facebook.ads.*;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    @BindView(R.id.fab_calender)
    FloatingActionButton fabCalender;
    @BindView(R.id.current_month)
    TextView currentMonth;
    @BindView(R.id.current_photo)
    ImageView currentPhoto;
    private SliderLayout mDemoSlider;

    int m = 0;
    Context context;

    /*private AdView adView;*/

    private final String TAG = MainActivity.class.getSimpleName();
    private NativeAd nativeAd;
    private NativeAdLayout nativeAdLayout;
    private LinearLayout adView;

    private InterstitialAd interstitialAd;

    private NativeBannerAd nativeBannerAd;
    private NativeAdLayout nativeAdLayout3;
    private LinearLayout adView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = MainActivity.this;
        mDemoSlider = findViewById(R.id.slider);

        try {
            List<IMAGE_LOCATION> file_maps2 = new ArrayList<>();
            file_maps2.add(new IMAGE_LOCATION("JANUARY", R.drawable.january));
            file_maps2.add(new IMAGE_LOCATION("FEBRUARY", R.drawable.february));
            file_maps2.add(new IMAGE_LOCATION("MARCH", R.drawable.march));
            file_maps2.add(new IMAGE_LOCATION("APRIL", R.drawable.april));
            file_maps2.add(new IMAGE_LOCATION("MAY", R.drawable.may));
            file_maps2.add(new IMAGE_LOCATION("JUNE", R.drawable.june));
            file_maps2.add(new IMAGE_LOCATION("JULY", R.drawable.july));
            file_maps2.add(new IMAGE_LOCATION("AUGUST", R.drawable.august));
            file_maps2.add(new IMAGE_LOCATION("SEPTEMBER", R.drawable.september));
            file_maps2.add(new IMAGE_LOCATION("OCTOBER", R.drawable.october));
            file_maps2.add(new IMAGE_LOCATION("NOVEMBER", R.drawable.november));
            file_maps2.add(new IMAGE_LOCATION("DECEMBER", R.drawable.december));
            for (IMAGE_LOCATION name : file_maps2) {
                TextSliderView textSliderView = new TextSliderView(this);
                // initialize a SliderLayout
                textSliderView
                        .description(name.getName())
                        .image(name.getLoc())
                        .setScaleType(BaseSliderView.ScaleType.Fit)
                        .setOnSliderClickListener(this);

                //add your extra information
                textSliderView.bundle(new Bundle());
                textSliderView.getBundle()
                        .putInt("extra", name.getLoc());

                mDemoSlider.addSlider(textSliderView);
            }
            mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
            mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
            mDemoSlider.setCustomAnimation(new DescriptionAnimation());
            mDemoSlider.setDuration(4000);
            mDemoSlider.addOnPageChangeListener(this);

            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            m = month;
            if (m == 0) {
                currentMonth.setText(file_maps2.get(0).getName());
                //currentPhoto.setImageResource(R.drawable.january);
                Glide.with(context)
                        .load(R.drawable.january)
                        .into(currentPhoto);
            } else if (m == 1) {
                currentMonth.setText(file_maps2.get(1).getName());
                //currentPhoto.setImageResource(R.drawable.february);
                Glide.with(context)
                        .load(R.drawable.february)
                        .into(currentPhoto);
            } else if (m == 2) {
                currentMonth.setText(file_maps2.get(2).getName());
                //currentPhoto.setImageResource(R.drawable.march);
                Glide.with(context)
                        .load(R.drawable.march)
                        .into(currentPhoto);
            } else if (m == 3) {
                currentMonth.setText(file_maps2.get(3).getName());
                //currentPhoto.setImageResource(R.drawable.april);
                Glide.with(context)
                        .load(R.drawable.april)
                        .into(currentPhoto);
            } else if (m == 4) {
                currentMonth.setText(file_maps2.get(4).getName());
                //currentPhoto.setImageResource(R.drawable.may);
                Glide.with(context)
                        .load(R.drawable.may)
                        .into(currentPhoto);
            } else if (m == 5) {
                currentMonth.setText(file_maps2.get(5).getName());
                //currentPhoto.setImageResource(R.drawable.june);
                Glide.with(context)
                        .load(R.drawable.june)
                        .into(currentPhoto);
            } else if (m == 6) {
                currentMonth.setText(file_maps2.get(6).getName());
                //currentPhoto.setImageResource(R.drawable.july);
                Glide.with(context)
                        .load(R.drawable.july)
                        .into(currentPhoto);
            } else if (m == 7) {
                currentMonth.setText(file_maps2.get(7).getName());
                //currentPhoto.setImageResource(R.drawable.august);
                Glide.with(context)
                        .load(R.drawable.august)
                        .into(currentPhoto);
            } else if (m == 8) {
                currentMonth.setText(file_maps2.get(8).getName());
                //currentPhoto.setImageResource(R.drawable.september);
                Glide.with(context)
                        .load(R.drawable.september)
                        .into(currentPhoto);
            } else if (m == 9) {
                currentMonth.setText(file_maps2.get(9).getName());
                //currentPhoto.setImageResource(R.drawable.october);
                Glide.with(context)
                        .load(R.drawable.october)
                        .into(currentPhoto);
            } else if (m == 10) {
                currentMonth.setText(file_maps2.get(10).getName());
                //currentPhoto.setImageResource(R.drawable.november);
                Glide.with(context)
                        .load(R.drawable.november)
                        .into(currentPhoto);
            } else if (m == 11) {
                currentMonth.setText(file_maps2.get(11).getName());
                //currentPhoto.setImageResource(R.drawable.december);
                Glide.with(context)
                        .load(R.drawable.december)
                        .into(currentPhoto);
            }


            AudienceNetworkAds.initialize(this);
            loadNativeAd();
            //interstaler();

            native_banner();
            interstaler();
        } catch (Exception e) {
            Log.d("Error Line Number", Log.getStackTraceString(e));
        }
    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        //Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
        try {
            Intent i = new Intent(MainActivity.this, FULL_IMAGE.class);
            i.putExtra("image_id", (int) slider.getBundle().get("extra"));
            startActivity(i);
        } catch (Exception e) {
            Log.d("Error Line Number", Log.getStackTraceString(e));
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @OnClick(R.id.fab_calender)
    public void onViewClicked() {

        try {
            MonthPickerDialog.Builder builder = new MonthPickerDialog.Builder(MainActivity.this, new MonthPickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(int selectedMonth, int selectedYear) {
                    Log.d("Month", selectedMonth + "");
                    if (selectedMonth == 0) {
                        Intent i = new Intent(MainActivity.this, FULL_IMAGE.class);
                        i.putExtra("image_id", R.drawable.january);
                        startActivity(i);
                    } else if (selectedMonth == 1) {
                        Intent i = new Intent(MainActivity.this, FULL_IMAGE.class);
                        i.putExtra("image_id", R.drawable.february);
                        startActivity(i);
                    } else if (selectedMonth == 2) {
                        Intent i = new Intent(MainActivity.this, FULL_IMAGE.class);
                        i.putExtra("image_id", R.drawable.march);
                        startActivity(i);
                    } else if (selectedMonth == 3) {
                        Intent i = new Intent(MainActivity.this, FULL_IMAGE.class);
                        i.putExtra("image_id", R.drawable.april);
                        startActivity(i);
                    } else if (selectedMonth == 4) {
                        Intent i = new Intent(MainActivity.this, FULL_IMAGE.class);
                        i.putExtra("image_id", R.drawable.may);
                        startActivity(i);
                    } else if (selectedMonth == 5) {
                        Intent i = new Intent(MainActivity.this, FULL_IMAGE.class);
                        i.putExtra("image_id", R.drawable.june);
                        startActivity(i);
                    } else if (selectedMonth == 6) {
                        Intent i = new Intent(MainActivity.this, FULL_IMAGE.class);
                        i.putExtra("image_id", R.drawable.july);
                        startActivity(i);
                    } else if (selectedMonth == 7) {
                        Intent i = new Intent(MainActivity.this, FULL_IMAGE.class);
                        i.putExtra("image_id", R.drawable.august);
                        startActivity(i);
                    } else if (selectedMonth == 8) {
                        Intent i = new Intent(MainActivity.this, FULL_IMAGE.class);
                        i.putExtra("image_id", R.drawable.september);
                        startActivity(i);
                    } else if (selectedMonth == 9) {
                        Intent i = new Intent(MainActivity.this, FULL_IMAGE.class);
                        i.putExtra("image_id", R.drawable.october);
                        startActivity(i);
                    } else if (selectedMonth == 10) {
                        Intent i = new Intent(MainActivity.this, FULL_IMAGE.class);
                        i.putExtra("image_id", R.drawable.november);
                        startActivity(i);
                    } else if (selectedMonth == 11) {
                        Intent i = new Intent(MainActivity.this, FULL_IMAGE.class);
                        i.putExtra("image_id", R.drawable.december);
                        startActivity(i);
                    }
                }
            }, /* activated number in year */ 3, m);

            builder.showMonthOnly()
                    .build()
                    .show();
        } catch (Exception e) {
            Log.d("Error Line Number", Log.getStackTraceString(e));
        }
    }



    @Override
    protected void onDestroy() {
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();
    }



    private void loadNativeAd() {
        // Instantiate a NativeAd object.
        // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
        // now, while you are testing and replace it later when you have signed up.
        // While you are using this temporary code you will only get test ads and if you release
        // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
        nativeAd = new NativeAd(this, getResources().getString(R.string.home_page_native));
        nativeAd.setAdListener(new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Race condition, load() called again before last ad was displayed
                if (nativeAd == null || nativeAd != ad) {
                    return;
                }
                // Inflate Native Ad into Container
                inflateAd(nativeAd);
            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        });
        // Request an ad
        nativeAd.loadAd();
        showNativeAdWithDelay();
    }

    private void inflateAd(NativeAd nativeAd) {

        nativeAd.unregisterView();

        // Add the Ad view into the ad container.
        nativeAdLayout = findViewById(R.id.native_ad_container);
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
        adView = (LinearLayout) inflater.inflate(R.layout.native_ad_layout, nativeAdLayout, false);
        nativeAdLayout.addView(adView);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(MainActivity.this, nativeAd, nativeAdLayout);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);

        // Create native UI using the ad metadata.
        AdIconView nativeAdIcon = adView.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = adView.findViewById(R.id.native_ad_title);
        MediaView nativeAdMedia = adView.findViewById(R.id.native_ad_media);
        TextView nativeAdSocialContext = adView.findViewById(R.id.native_ad_social_context);
        TextView nativeAdBody = adView.findViewById(R.id.native_ad_body);
        TextView sponsoredLabel = adView.findViewById(R.id.native_ad_sponsored_label);
        Button nativeAdCallToAction = adView.findViewById(R.id.native_ad_call_to_action);

        // Set the Text.
        nativeAdTitle.setText(nativeAd.getAdvertiserName());
        nativeAdBody.setText(nativeAd.getAdBodyText());
        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());

        // Create a list of clickable views
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);

        // Register the Title and CTA button to listen for clicks.
        nativeAd.registerViewForInteraction(
                adView,
                nativeAdMedia,
                nativeAdIcon,
                clickableViews);
    }



    public void interstaler() {
        interstitialAd = new InterstitialAd(this, getResources().getString(R.string.inter));
        // Set listeners for the Interstitial Ad
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
                Log.e(TAG, "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                Log.e(TAG, "Interstitial ad dismissed.");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                // Show the ad
                interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
                Log.d(TAG, "Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
                Log.d(TAG, "Interstitial ad impression logged!");
            }
        });

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd();
        showAdWithDelay();
    }

    private void showAdWithDelay() {
        /**
         * Here is an example for displaying the ad with delay;
         * Please do not copy the Handler into your project
         */
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Check if interstitialAd has been loaded successfully
                if (interstitialAd == null || !interstitialAd.isAdLoaded()) {
                    return;
                }
                // Check if ad is already expired or invalidated, and do not show ad if that is the case. You will not get paid to show an invalidated ad.
                if (interstitialAd.isAdInvalidated()) {
                    return;
                }
                // Show the ad
                interstitialAd.show();
            }
        }, 1000 * 60); // Show the ad after 15 minutes
    }


    public void native_banner() {
        nativeBannerAd = new NativeBannerAd(this, getResources().getString(R.string.home_page_native_banner));
        nativeBannerAd.setAdListener(new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
                // Native ad finished downloading all assets
                Log.e(TAG, "Native ad finished downloading all assets.");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Native ad failed to load
                Log.e(TAG, "Native ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Native ad is loaded and ready to be displayed
                Log.d(TAG, "Native ad is loaded and ready to be displayed!");
                if (nativeBannerAd == null || nativeBannerAd != ad) {
                    return;
                }
                // Inflate Native Banner Ad into Container
                inflateAd2(nativeBannerAd);
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Native ad clicked
                Log.d(TAG, "Native ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Native ad impression
                Log.d(TAG, "Native ad impression logged!");
            }
        });
        // load the ad
        nativeBannerAd.loadAd();
    }

    private void inflateAd2(NativeBannerAd nativeBannerAd) {
        // Unregister last ad
        nativeBannerAd.unregisterView();

        // Add the Ad view into the ad container.
        nativeAdLayout3 = findViewById(R.id.native_banner_ad_container);
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        // Inflate the Ad view.  The layout referenced is the one you created in the last step.
        adView3 = (LinearLayout) inflater.inflate(R.layout.native_banner_ad_unit, nativeAdLayout3, false);
        nativeAdLayout3.addView(adView3);

        // Add the AdChoices icon
        RelativeLayout adChoicesContainer = adView3.findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(MainActivity.this, nativeBannerAd, nativeAdLayout3);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);

        // Create native UI using the ad metadata.
        TextView nativeAdTitle = adView3.findViewById(R.id.native_ad_title);
        TextView nativeAdSocialContext = adView3.findViewById(R.id.native_ad_social_context);
        TextView sponsoredLabel = adView3.findViewById(R.id.native_ad_sponsored_label);
        AdIconView nativeAdIconView = adView3.findViewById(R.id.native_icon_view);
        Button nativeAdCallToAction = adView3.findViewById(R.id.native_ad_call_to_action);

        // Set the Text.
        nativeAdCallToAction.setText(nativeBannerAd.getAdCallToAction());
        nativeAdCallToAction.setVisibility(
                nativeBannerAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdTitle.setText(nativeBannerAd.getAdvertiserName());
        nativeAdSocialContext.setText(nativeBannerAd.getAdSocialContext());
        sponsoredLabel.setText(nativeBannerAd.getSponsoredTranslation());

        // Register the Title and CTA button to listen for clicks.
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);
        nativeBannerAd.registerViewForInteraction(adView3, nativeAdIconView, clickableViews);
    }

    private void showNativeAdWithDelay() {
        /**
         * Here is an example for displaying the ad with delay;
         * Please do not copy the Handler into your project
         */
         Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Check if nativeAd has been loaded successfully
                if(nativeAd == null || !nativeAd.isAdLoaded()) {
                    return;
                }
                // Check if ad is already expired or invalidated, and do not show ad if that is the case. You will not get paid to show an invalidated ad.
                if(nativeAd.isAdInvalidated()) {
                    return;
                }
                inflateAd(nativeAd); // Inflate Native Ad into Container same as previous code example
            }
        }, 1000 * 60 ); // Show the ad after 15 minutes
    }
}