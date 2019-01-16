package mykonnect.com.mykonnect.mykonnect;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Settings.Secure;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends FragmentActivity {

    private AdView adView;
    private static final String AD_UNIT_ID = "ca-app-pub-4510811185421782/6314270150";
    private String DEVICE_ID  = "";


	private static final String TAG = MainActivity.class.getSimpleName();

    public Boolean InternetConnection;


    ListAsync listAsync;




    private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private String[] mDrawerItmes;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*Intent i = new Intent(this,MapsActivity.class);
        startActivity(i);*/
        listAsync = new ListAsync();
        listAsync.execute();
        if(hasActiveInternetConnection(getBaseContext())){
            ((PartyHelper)getApplication()).populateUserList();
            if(((PartyHelper)getApplication()).isLoggedIn()) {
                ((PartyHelper) getApplication()).populateInfo();
            }

        }
        DEVICE_ID = Secure.getString(getContentResolver(),
                Secure.ANDROID_ID);
        adView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(DEVICE_ID).build();
        adView.loadAd(adRequest);



       /* */




	mTitle = mDrawerTitle = getTitle();

        if(!((PartyHelper)this.getApplication()).isLoggedIn()){
            mDrawerItmes = new String[]{"Login", "Register","Ad Of The Day","Users"};

        }else{
            mDrawerItmes = new String[]{"Profile", "Ad Of The Day","Profile Picture","Put in your Info","Users","Opposite Gender","Random User","Search for a User","Change Password"};

        }

		//mDrawerItmes = getResources().getStringArray(R.array.drawer_titles);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		
		// set a custom shadow that overlays the main content when the drawer oepns
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,  GravityCompat.START);
		
		// Add items to the ListView
		mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mDrawerItmes));
		// Set the OnItemClickListener so something happens when a 
		// user clicks on an item.
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
		// Enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		
		mDrawerToggle = new ActionBarDrawerToggle(
				this, 
				mDrawerLayout, 
				R.drawable.ic_drawer, 
				R.string.drawer_open, 
				R.string.drawer_close
				) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}
			
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}
		};
		
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		// Set the default content area to item 0
		// when the app opens for the first time
		if(savedInstanceState == null) {
			navigateTo(0);
		}
	
	}
	
	/*
	 * If you do not have any menus, you still need this function
	 * in order to open or close the NavigationDrawer when the user 
	 * clicking the ActionBar app icon.
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	/*
	 * When using the ActionBarDrawerToggle, you must call it during onPostCreate()
	 * and onConfigurationChanged()
	 */
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}



    private class DrawerItemClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			navigateTo(position);

            mDrawerLayout.closeDrawers();


		}
	}
    public void getAd(){
     DEVICE_ID = Secure.getString(getContentResolver(),
                Secure.ANDROID_ID);
        adView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(DEVICE_ID).build();
        adView.loadAd(adRequest);
    }
	public void GoToUsers(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame,
                        UsersFragment.newInstance(),
                        UsersFragment.TAG).commit();
    }
    public void GoToLogin(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame,
                        LoginFragment.newInstance(),
                        LoginFragment.TAG).commit();
    }
    public void GoToProfile(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame,
                        ProfileFragment.newInstance(),
                        ProfileFragment.TAG).commit();
    }

	public void navigateTo(int position) {
		Log.v(TAG, "List View Item: " + position);
        if(!((PartyHelper)this.getApplication()).isLoggedIn()){
           //   mDrawerItmes = new String[]{"Login", "Register","Ad Of The Day","Users"};
            switch(position) {
                case 0:

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame,
                                    LoginFragment.newInstance(),
                                    LoginFragment.TAG).commit();
                    break;
                case 1:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame,
                                    RegisterFragment.newInstance(),
                                    RegisterFragment.TAG).commit();
                    break;
                case 2:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame,
                                    WebViewFragment.newInstance(),
                                    WebViewFragment.TAG).commit();
                    break;
                case 3:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame,
                                    UsersFragment.newInstance(),
                                    UsersFragment.TAG).commit();
                    break;
            }

        }else{
          //   mDrawerItmes = new String[]{
          // "Profile", "Ad Of The Day","Profile Picture",
          // "Put in your Info","Users","Opposite Gender",
          // "Random User","Search for a User","Change Password"};


            switch(position) {
                case 0:

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame,
                                    MyProfileFragment.newInstance(),
                                    MyProfileFragment.TAG).commit();
                    break;
                case 1:

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame,
                                    WebViewFragment.newInstance(),
                                    WebViewFragment.TAG).commit();
                    break;
                case 2:

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame,
                                    ProfilePicFragment.newInstance(),
                                    ProfilePicFragment.TAG).commit();
                    break;
                case 3:

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame,
                                    InfoFragment.newInstance(),
                                    InfoFragment.TAG).commit();
                    break;
                case 4:

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame,
                                    UsersFragment.newInstance(),
                                    UsersFragment.TAG).commit();
                    break;
                case 5:

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame,
                                    GenderFragment.newInstance(),
                                    GenderFragment.TAG).commit();
                    break;
                case 6:

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame,
                                    RandomFragment.newInstance(),
                                    RandomFragment.TAG).commit();
                    break;
                case 7:
                        getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame,
                                    SearchFragment.newInstance(),
                                    SearchFragment.TAG).commit();
                    break;

                case 8:

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame,
                                    ChangePasswordFragment.newInstance(),
                                    ChangePasswordFragment.TAG).commit();
                    break;
                 }

        }

    }










    @Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}
    public void internetFragTest() {
        ListAsync TestAsync = new ListAsync();
        TestAsync.execute();
    }
    public void setDrawer(){

        if(!((PartyHelper)this.getApplication()).isLoggedIn()){
            mDrawerItmes = new String[]{"Login", "Register","Ad Of The Day","Users"};

        }else{
            mDrawerItmes = new String[]{
                     "Profile", "Ad Of The Day","Profile Picture",
                     "Put in your Info","Users","Opposite Gender",
                     "Random User","Search for a User","Change Password"};
        }
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mDrawerItmes));
    }


    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
    public static boolean hasActiveInternetConnection(Context context) {
        if (isNetworkAvailable(context)) {
            try {
                StrictMode.enableDefaults();
                StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog()
                        .penaltyDeath().build());
                HttpURLConnection urlc = (HttpURLConnection) (new URL("http://www.google.com").openConnection());
                urlc.setRequestProperty("User-Agent", "Test");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(1500);
                urlc.connect();
                return (urlc.getResponseCode() == 200);
            } catch (IOException e) {
                Log.e("TAG", "Error checking internet connection", e);
            }
        } else {
            Log.d("TAG", "No network available!");
        }
        return false;
    }






    class ListAsync extends AsyncTask<Void, Integer, Boolean> {


        protected Boolean doInBackground(Void...arg0) {

            if(isNetworkAvailable(getBaseContext())){
                InternetConnection = true;
                Log.i("Internet","Async true");
                return true;
            }else{
                InternetConnection = false;
                Intent i = new Intent(getApplicationContext(),IntroActivity.class);
                startActivity(i);
                Log.i("Internet","Async false");
                return false;
            }


        }



        protected void onPostExecute(Boolean result) {
            return ;
        }
    }


}

