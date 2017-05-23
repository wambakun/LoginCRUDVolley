package developerkampus.logincrud.inferface;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by Wamba on 23/05/2017.
 */

public interface VolleyInterface {
    void onPrepare();
    void onSucces(JSONObject jsonObject);
    void onFailed(VolleyError errorListener);
}
