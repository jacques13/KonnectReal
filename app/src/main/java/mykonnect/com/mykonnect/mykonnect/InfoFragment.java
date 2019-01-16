package mykonnect.com.mykonnect.mykonnect;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


public class InfoFragment extends Fragment {
    public final static String TAG = InfoFragment.class.getSimpleName();
    public static InfoFragment newInstance() {
        return new InfoFragment();
    }
    private String[] socialMedia = {"facebook","twitter","instagram"
                                    ,"pinterest","tumblr","linkedin",
                                    "vine","bbm","whatsapp","google",
                                    "snapchat","wechat","mxit","zoosk"};





    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        final LinearLayout ll = (LinearLayout)v.findViewById(R.id.linearLay);
        //((MainActivity) getActivity()).internetFragTest();
        /*App a = new App();
        String[] r = a.getDetails();*/

        Toast.makeText(getActivity().getApplicationContext(),((PartyHelper) getActivity().getApplication()).getID(),
                Toast.LENGTH_LONG).show();
        GetInfo q = new GetInfo();
        q.getData(((PartyHelper) getActivity().getApplication()).getID());
        String[] r = q.info;

        for (int i=0;i<socialMedia.length;i++){
            EditText et = new EditText(getActivity());
            et.setTag(i);
             if(r[i].contains("&&&")){
                 et.setHint(socialMedia[i]+" Info...");

            }else{
                 et.setText(r[i]);

             }

            ll.addView(et);
        }

        Button b = new Button(getActivity());
        View.OnClickListener clicks=new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String s = "";
                for (int i=0;i<socialMedia.length;i++){
                    EditText text = (EditText) ll.findViewWithTag(i);
                    s += socialMedia[i]+"="+text.getText().toString()+"&";
                 }

                s +="u_id="+((PartyHelper) getActivity().getApplication()).getID();
                Toast.makeText(getActivity().getApplicationContext(), s,
                        Toast.LENGTH_LONG).show();
                Info info = new Info();
                info.getData(s);
                ((MainActivity) getActivity()).GoToProfile();

            }
        };
        b.setText("Done!!");
        b.setBackgroundResource(R.drawable.rounded);
        b.setTextAppearance(getActivity().getBaseContext(),R.style.Buttons);
        b.setOnClickListener(clicks);
        ll.addView(b);





        return  v ;
    }





}
