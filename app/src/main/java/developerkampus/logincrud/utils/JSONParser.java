package developerkampus.logincrud.utils;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Wamba on 23/05/2017.
 */

public class JSONParser {
    private Context mContext;

    public JSONParser(Context context) {
        this.mContext = context;
    }

    public boolean isSuccess(JSONObject jsonObject){
        int kode = 0;
        String pesan = "";
        try {
            kode = jsonObject.getInt("kode");
            pesan = jsonObject.getString("pesan");
        } catch (JSONException e) {
            Toast.makeText(mContext, "" + e, Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(mContext, "" + jsonObject, Toast.LENGTH_SHORT).show();
        if(kode==2){
            return true;
        }else{
            return false;
        }

    }
}
