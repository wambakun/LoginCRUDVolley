package developerkampus.logincrud.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import developerkampus.logincrud.R;
import developerkampus.logincrud.inferface.VolleyInterface;
import developerkampus.logincrud.template.EndpointAPI;
import developerkampus.logincrud.template.Template;
import developerkampus.logincrud.utils.JSONParser;
import developerkampus.logincrud.utils.VolleyRequest;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteFragment extends Fragment implements VolleyInterface {
    private EditText mUsername;
    private Button mFind, mDelete;
    private VolleyRequest mRequestFind, mRequestDelete;
    private ProgressBar mProgressFind, mProgressDelete;
    private LinearLayout mDeleteLayout;
    private JSONParser mJSONParser;

    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);

        mJSONParser = new JSONParser(getContext());
        mDeleteLayout = (LinearLayout)view.findViewById(R.id.delete_layout);

        mRequestFind = new VolleyRequest(new VolleyInterface() {
            @Override
            public void onPrepare() {
                switchButtonProgressFind(true);
                mDeleteLayout.setVisibility(LinearLayout.GONE);
            }

            @Override
            public void onSucces(JSONObject jsonObject) {
                switchButtonProgressFind(false);
                if(mJSONParser.isSuccess(jsonObject)){
                    mDeleteLayout.setVisibility(LinearLayout.VISIBLE);
                }else{
                    mDeleteLayout.setVisibility(LinearLayout.GONE);
                }
            }

            @Override
            public void onFailed(VolleyError errorListener) {
                switchButtonProgressFind(false);
                mDeleteLayout.setVisibility(LinearLayout.GONE);
                Toast.makeText(getActivity(), "Error : " + errorListener, Toast.LENGTH_SHORT).show();
            }
        });

        mRequestDelete = new VolleyRequest(new VolleyInterface() {
            @Override
            public void onPrepare() {
                switchButtonProgressDelete(true);
            }

            @Override
            public void onSucces(JSONObject jsonObject) {
                switchButtonProgressDelete(false);
                mJSONParser.isSuccess(jsonObject);
                mDeleteLayout.setVisibility(LinearLayout.GONE);
            }

            @Override
            public void onFailed(VolleyError errorListener) {
                switchButtonProgressDelete(false);
                Toast.makeText(getActivity(), "Error : " + errorListener, Toast.LENGTH_SHORT).show();
            }
        });
        mProgressFind = (ProgressBar)view.findViewById(R.id.progress_find);
        mProgressDelete = (ProgressBar)view.findViewById(R.id.progress_delete);
        mUsername = (EditText)view.findViewById(R.id.username);
        mFind = (Button)view.findViewById(R.id.find);
        mFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,String> map = new HashMap<>();
                map.put(Template.Query.TAG, Template.Query.FIND);
                map.put(Template.Query.USERNAME, mUsername.getText().toString());
                mRequestFind.sendPostRequest(EndpointAPI.ANDEVINDO, map);
            }
        });

        mDelete = (Button)view.findViewById(R.id.delete);
        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> map = new HashMap<>();
                map.put(Template.Query.TAG, Template.Query.DELETE);
                map.put(Template.Query.USERNAME, mUsername.getText().toString());
                mRequestDelete.sendPostRequest(EndpointAPI.ANDEVINDO, map);
            }
        });
        return view;
    }

    void switchButtonProgressFind(boolean isLoading){
        if(isLoading){
            mFind.setVisibility(Button.GONE);
            mProgressFind.setVisibility(ProgressBar.VISIBLE);
        }else{
            mFind.setVisibility(Button.VISIBLE);
            mProgressFind.setVisibility(ProgressBar.GONE);
        }
    }

    void switchButtonProgressDelete(boolean isLoading){
        if(isLoading){
            mDelete.setVisibility(Button.GONE);
            mProgressDelete.setVisibility(ProgressBar.VISIBLE);
        }else{
            mDelete.setVisibility(Button.VISIBLE);
            mProgressDelete.setVisibility(ProgressBar.GONE);
        }
    }

    @Override
    public void onPrepare() {

    }

    @Override
    public void onSucces(JSONObject jsonObject) {

    }

    @Override
    public void onFailed(VolleyError errorListener) {

    }

}
