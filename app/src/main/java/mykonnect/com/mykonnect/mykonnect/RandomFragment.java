package mykonnect.com.mykonnect.mykonnect;

import android.graphics.Color;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;


public class RandomFragment extends Fragment implements View.OnClickListener,
        Animation.AnimationListener{

    public List<User> users ;

    Animation animation1;
    Animation animation2;
    Animation in = new AlphaAnimation(0.0f, 1.0f);
    Animation out = new AlphaAnimation(1.0f, 0.0f);
    ImageView imgView ;
    TextView textView;
    int[] values = {850,800,750,700,650};
    boolean backs ;
    int counter = 0;
    LinearLayout scrollView;


    private AdView adView;
    private static final String AD_UNIT_ID = "ca-app-pub-4510811185421782/6314270150";
    private String DEVICE_ID  = "";

    public final static String TAG = RandomFragment.class.getSimpleName();
    public static RandomFragment newInstance() {
        return new RandomFragment();
    }
    public RandomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_random, container, false);
        scrollView = (LinearLayout)v.findViewById(R.id.scroll);
        ((MainActivity) getActivity()).internetFragTest();

        Button randomClick = (Button)v.findViewById(R.id.btnRandom);
        randomClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backs = true;
                scrollView.removeAllViews();
                Random ran = new Random();
                int x = ran.nextInt(users.size());
                User u = users.get(x);
                scrollView.addView(createLayout(850,u));
            }
        });


        DEVICE_ID = Settings.Secure.getString(getActivity().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        adView = (AdView) v.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(DEVICE_ID).build();
        adView.loadAd(adRequest);


        users =  ((PartyHelper) getActivity().getApplication()).getUsers();
        backs = true;

        Random ran = new Random();
        int x = ran.nextInt(users.size());
        User u = users.get(x);
        scrollView.addView(createLayout(850,u));


        animation1 = AnimationUtils.loadAnimation(getActivity(), R.anim.to_middle);
        animation1.setAnimationListener(this);
        animation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.from_middle);
        animation2.setAnimationListener(this);
        in.setDuration(1500);
        out.setDuration(500);
        AnimationSet as = new AnimationSet(true);
        as.addAnimation(out);
        as.addAnimation(in);

        return v;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation==animation1) {
            imgView.clearAnimation();
            imgView.setAnimation(animation2);
            imgView.startAnimation(animation2);

        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public RelativeLayout createLayout(int wH, final User u){
        int widthHeight = wH;
        Random ran = new Random();
        int x = ran.nextInt(250);
        int margin = x;

        View.OnClickListener clicks=new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int position  = (Integer) v.getTag();

                View relative =  scrollView.getChildAt(position);
                ImageView img = (ImageView) relative.findViewWithTag("img");
                TextView text = (TextView) relative.findViewWithTag("text");

                img.clearAnimation();
                img.setAnimation(animation1);
                img.startAnimation(animation1);
                imgView = img;
                textView = text;


                if (backs) {
                    img.setImageDrawable(null);
                    int iconColor = Color.parseColor("#FF0087AE");
                    img.setBackgroundColor(iconColor);
                    backs=false;
                    text.startAnimation(in);
                    text.setVisibility(View.VISIBLE);

                }else{
                    text.setVisibility(View.INVISIBLE);
                    Picasso.with(getActivity()).load("http://xpoliem.com/pPics/"+u.getIconID()).error(R.drawable.konnect).into(img);
                    img.setColorFilter(null);
                    backs=true;
                    text.startAnimation(out);
                }


            }
        };


        RelativeLayout layout = new RelativeLayout(getActivity());
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(widthHeight,widthHeight);
        rlp.setMargins(margin,margin,margin,margin);
        layout.setGravity(Gravity.CENTER);
        layout.setLayoutParams(rlp);
        layout.setOnClickListener(clicks);
        layout.setTag(counter);





        RelativeLayout.LayoutParams imglp = new RelativeLayout.LayoutParams(widthHeight,widthHeight);
        imglp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        imglp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        rlp.addRule(RelativeLayout.CENTER_IN_PARENT);

        imglp.setMargins(margin,margin,margin,margin);


        ImageView image = new ImageView(getActivity());
        Picasso.with(getActivity()).load("http://xpoliem.com/pPics/"+u.getIconID()).error(R.drawable.konnect).into(image);
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        // image.setImageResource(R.drawable.card_back);
        image.setLayoutParams(imglp);
        image.setTag("img");

        RelativeLayout.LayoutParams Tlp = new RelativeLayout.LayoutParams(widthHeight,widthHeight);
        Tlp.addRule(RelativeLayout.CENTER_IN_PARENT);
        Tlp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        /*Tlp.topMargin=10;
        Tlp.leftMargin=10;*/
        Tlp.setMargins(margin,margin,margin,margin);

        View.OnClickListener nameClick=new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((PartyHelper) getActivity().getApplication()).setU_ID(u.getId());
                ((MainActivity) getActivity()).GoToProfile();

            }
        };


        TextView text = new TextView(getActivity());
        text.setLayoutParams(Tlp);
        int iconColor = Color.parseColor("#f0f0f0f0");
        text.setTextColor(iconColor);
        text.setTextSize(12);
        text.setGravity(Gravity.CENTER);
        text.setText(u.getName()+"-"+u.getGender());
        text.setTag("text");
        text.setVisibility(View.INVISIBLE);
        text.setOnClickListener(nameClick);



        // Adds the view to the layout
        layout.setGravity(Gravity.CENTER);
        layout.addView(image);
        layout.addView(text);

        return layout;

    }


    @Override
    public void onClick(View view) {

    }
}
