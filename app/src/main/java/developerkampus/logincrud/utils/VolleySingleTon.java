package developerkampus.logincrud.utils;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import developerkampus.logincrud.application.MyApplication;

/**
 * Created by Wamba on 23/05/2017.
 */

public class VolleySingleTon {
    private static VolleySingleTon sInstance = null;
    private RequestQueue mRequestQueue;

    private VolleySingleTon(){
        mRequestQueue = Volley.newRequestQueue(MyApplication.getContext());
    }



    public static VolleySingleTon getInstance() {
        if(sInstance == null){
            sInstance = new VolleySingleTon();
        }
        return sInstance;
    }

    public RequestQueue getRequestQueue(){
        return mRequestQueue;
    }
}
