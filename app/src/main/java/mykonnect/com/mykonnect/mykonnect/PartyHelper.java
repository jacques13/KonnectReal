package mykonnect.com.mykonnect.mykonnect;

import android.app.Application;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacques on 6/22/2015.
 */
public class PartyHelper extends Application {

    public String ID = "3";



    public String U_ID ;

    public boolean loggedIn = false;

    private List<User> users = new ArrayList<User>();
    String[] detailsApp;



    public boolean isLoggedIn() {
        return loggedIn;
    }





    public List<User> getUsers() {
        return users;
    }
    public void populateUserList(){
        new Thread(){
            public void run(){
            //    if(hasActiveInternetConnection(getBaseContext())){
                Users m = new Users();
                m.getData();
                // events.add(new Event(who,id,name,time,date,latitude,longitude,going));

                for(int i=0; i<m.usernames.length;i++){
                    users.add(new User(m.ids[i],m.usernames[i],m.images[i],m.genders[i]));
                    //Log.i("Tag", m.usernames[i]);
                }

              //   }else{

                }
           // }
        }.start();



    }

    public void populateInfo(){
        new Thread(){
            public void run(){
                GetInfo q = new GetInfo();
                q.getData(ID);
                detailsApp = q.info;

            }
        }.start();


    }



    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }



    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String getU_ID() {
        return U_ID;
    }

    public void setU_ID(String u_ID) {
        U_ID = u_ID;
    }



    public String GetUsername(){
        GetUser getUser = new GetUser();
        getUser.getData(ID);
        Toast.makeText(this, getUser.usernames
                , Toast.LENGTH_LONG).show();
        return getUser.usernames;
    }
    public String GetIcon(){
        GetUser getUser = new GetUser();
        getUser.getData(ID);
        return getUser.images;
    }
    public String GetGender(){
        GetUser getUser = new GetUser();
        getUser.getData(ID);

        return getUser.genders;
    }
    public String GetUsernames(String id){
        GetUser getUser = new GetUser();
        getUser.getData(id);
        Toast.makeText(this, getUser.usernames
                , Toast.LENGTH_LONG).show();
        return getUser.usernames;
    }
    public String GetIcons(String id){
        GetUser getUser = new GetUser();
        getUser.getData(id);
        return getUser.images;
    }
}
