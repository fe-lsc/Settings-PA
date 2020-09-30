package com.example.settings;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    SharedPreferences mySharedPref;

    public SharedPref (Context context){
        mySharedPref = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }

    //metodo para salvar o NightMode como falso ou true
    public void setNightModeState (Boolean state){
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("NightMode", state);
        editor.commit();
    }

    //metodo para carregar o estado do NightMode
    public Boolean loadNightModeState(){
        Boolean state = mySharedPref.getBoolean("NightMode",false);
        return state;
    }
}
