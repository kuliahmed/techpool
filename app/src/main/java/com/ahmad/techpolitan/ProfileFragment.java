package com.ahmad.techpolitan;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    SharedPreferences sharedpreferences;
    private TextView tvNip;
    private TextView profile_image;
    private TextView tvNameProfile;
    private TextView tvJabatan;
    private TextView tvNIK;
    private TextView tvDate;
    private TextView tvGender;
    private TextView tvAddress;
    private TextView tvEmail;
    private TextView tvPhone;
    private TextView tvStatus;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        try {
            getDataProfile();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        tvNameProfile = view.findViewById(R.id.tvNameProfile);
        tvNip = view.findViewById(R.id.tvNip);
        tvJabatan = view.findViewById(R.id.tvJabatan);
        tvNIK = view.findViewById(R.id.tvNIK);
        tvDate = view.findViewById(R.id.tvDate);
        tvGender = view.findViewById(R.id.tvGender);
        tvAddress = view.findViewById(R.id.tvAddress);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvPhone = view.findViewById(R.id.tvPhone);
        tvStatus = view.findViewById(R.id.tvStatus);

        return view;
    }

    public void getDataProfile() throws JSONException {
        sharedpreferences = getContext().getSharedPreferences("Settings",Context.MODE_PRIVATE);
        String myID = sharedpreferences.getString(LoginActivity.MY_ID,"4");
        JSONObject obj = new JSONObject();
        obj.put("id", myID);
        RequestQueue queue = Volley.newRequestQueue(this.getContext());
        String SPHERE_URL = "https://nachoscloth.xyz/api/profile";
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST,SPHERE_URL,obj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Response Rest",SPHERE_URL+ response.toString() + myID);
                        try {
                            if(response.getBoolean("status")){
                                JSONObject respobject = response.getJSONObject("data");

                                Log.d("Response Object", "onResponse: "+respobject.toString());



                                tvNameProfile.setText(respobject.getString("nama"));
                                tvNip.setText(respobject.getString("nip"));
                                tvNIK.setText(respobject.getString("nik"));
                                tvDate.setText(respobject.getString("ttl"));
                                tvGender.setText(respobject.getString("jenis_kelamin"));
                                tvAddress.setText(respobject.getString("alamat"));
                                tvEmail.setText(respobject.getString("email"));
                                tvPhone.setText(respobject.getString("telepon"));
                                tvStatus.setText(respobject.getString("status"));
                                tvJabatan.setText(respobject.getString("jabatan"));

//                                Toast.makeText(getApplicationContext(),response.getString("message"),Toast.LENGTH_SHORT).show();
//                                JSONObject data = response.getJSONObject("data");
//                                String myID = data.getString("id");
//                                editor.putString(MY_ID, myID);
//                                editor.apply();
//                                navigateToStartActivity();
                            }
//                            Toast.makeText(getApplicationContext(),response.getString("message"),Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
//                                hideProgressDialog();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Response Error",SPHERE_URL+ " error " +error.toString());
//                                hideProgressDialog();
                    }
                });
        queue.add(jsObjRequest);
    }
}