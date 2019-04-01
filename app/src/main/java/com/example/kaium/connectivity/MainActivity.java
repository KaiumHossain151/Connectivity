package com.example.kaium.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv_connected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_connected = (TextView)findViewById(R.id.tv_connectivity);

        Connectivity conn = new Connectivity();

            if(conn.isConnectedMobile()){
                tv_connected.setText("Device is Connected by mobile network");
            }else if(conn.isConnectedWifi()){
                tv_connected.setText("Device is Connected by wifi network");
            }else{
                tv_connected.setText("Device is not Connected");
            }
    }


    public class Connectivity{

        private ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        private boolean isConnectedWifi(){
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == ConnectivityManager.TYPE_WIFI);
        }

        private boolean isConnectedMobile(){
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE);
        }

    }

//    private boolean amIConnected(){
//
//        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//        return networkInfo != null && networkInfo.isConnected();
//    }


//    public static NetworkInfo getNetworkInfo(Context context){
//        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        return cm.getActiveNetworkInfo();
//    }
//
//    public static boolean isConnected(Context context){
//        NetworkInfo info = MainActivity.getNetworkInfo(context);
//        return (info != null && info.isConnected());
//    }

}
