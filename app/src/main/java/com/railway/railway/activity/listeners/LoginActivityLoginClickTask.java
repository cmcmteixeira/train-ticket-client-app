package com.railway.railway.activity.listeners;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.railway.railway.DaggerApplicationComponent;
import com.railway.railway.business.api.API;
import com.railway.railway.business.api.request.AuthRequest;
import com.railway.railway.business.api.entity.User;

import org.json.JSONException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;


public class LoginActivityLoginClickTask extends AsyncTask<String,Void,User> {
    private Context context;
    private final String username;
    private final String password;

    LoginActivityLoginClickTask(Context view,String username,String password){
        this.context = view;

        this.username = username;
        this.password = password;
    }

    @Override
    protected User doInBackground(String... params) {

        API api = DaggerApplicationComponent.create().provideRequestAPI();
        try {
            AuthRequest request = new AuthRequest(username,password);
            api.request(request);
            return request.getResponse();
        } catch (JSONException | TimeoutException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(User response) {
        Toast toast;
        if (response != null){
            toast = Toast.makeText(context,"A funcionar",Toast.LENGTH_LONG);
        } else {
            toast = Toast.makeText(context,"Deu erro",Toast.LENGTH_LONG);
        }
        toast.show();
    }
}
