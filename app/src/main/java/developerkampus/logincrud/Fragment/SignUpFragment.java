package developerkampus.logincrud.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
public class SignUpFragment extends Fragment implements VolleyInterface {
    private EditText mUsername, mPassword;
    private Button mSignUp;
    private VolleyRequest mRequest;
    private ProgressBar mProgress;
    private JSONParser mJSONParser;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        mJSONParser = new JSONParser(getContext());
        mRequest = new VolleyRequest(this);
        mProgress = (ProgressBar) view.findViewById(R.id.progress_sign_up);
        mUsername = (EditText) view.findViewById(R.id.username);
        mPassword = (EditText) view.findViewById(R.id.password);
        mSignUp = (Button) view.findViewById(R.id.sign_up);
        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> map = new HashMap<>();
                map.put(Template.Query.TAG, Template.Query.SIGNUP);
                map.put(Template.Query.USERNAME, mUsername.getText().toString());
                map.put(Template.Query.PASSWORD, mPassword.getText().toString());
                mRequest.sendPostRequest(EndpointAPI.ANDEVINDO, map);
            }
        });
        return view;
    }

    void switchButtonProgress(boolean isLoading) {
        if (isLoading) {
            mSignUp.setVisibility(Button.GONE);
            mProgress.setVisibility(ProgressBar.VISIBLE);
        } else {
            mSignUp.setVisibility(Button.VISIBLE);
            mProgress.setVisibility(ProgressBar.GONE);
        }
    }

    @Override
    public void onPrepare() {
        switchButtonProgress(true);
    }

    @Override
    public void onSucces(JSONObject jsonObject) {
        switchButtonProgress(false);
        mJSONParser.isSuccess(jsonObject);
    }

    @Override
    public void onFailed(VolleyError errorListener) {
        switchButtonProgress(false);
        Toast.makeText(getActivity(), "Error : " + errorListener, Toast.LENGTH_SHORT).show();
    }
}


