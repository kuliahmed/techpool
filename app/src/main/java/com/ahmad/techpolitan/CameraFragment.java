package com.ahmad.techpolitan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CameraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CameraFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    int selectedType = 0;
    int typeWFH = 0;
    int typeWFO = 1;
    int typeVisit = 2;
    Context context;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CameraFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CameraFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CameraFragment newInstance(String param1, String param2) {
        CameraFragment fragment = new CameraFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_camera, container, false);

        TextView tvWFH = view.findViewById(R.id.tvWFH);
        TextView tvWFO = view.findViewById(R.id.tvWFO);
        TextView tvVisit = view.findViewById(R.id.tvVisit);
        context = view.getContext();

        tvWFH.setOnClickListener(view13 -> {
            final int sdk = android.os.Build.VERSION.SDK_INT;
            if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                tvWFH.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.outline_blue_button_selected));
                tvWFH.setTextColor(ContextCompat.getColor(context, R.color.white));

                tvWFO.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.outline_blue_button));
                tvWFO.setTextColor(ContextCompat.getColor(context, R.color.purple_500));

                tvVisit.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.outline_blue_button));
                tvVisit.setTextColor(ContextCompat.getColor(context, R.color.purple_500));
            } else {
                tvWFH.setBackground(ContextCompat.getDrawable(context, R.drawable.outline_blue_button_selected));
                tvWFH.setTextColor(ContextCompat.getColor(context, R.color.white));

                tvWFO.setBackground(ContextCompat.getDrawable(context, R.drawable.outline_blue_button));
                tvWFO.setTextColor(ContextCompat.getColor(context, R.color.purple_500));

                tvVisit.setBackground(ContextCompat.getDrawable(context, R.drawable.outline_blue_button));
                tvVisit.setTextColor(ContextCompat.getColor(context, R.color.purple_500));
            }

        });

        tvWFO.setOnClickListener(view12 -> {
            final int sdk = android.os.Build.VERSION.SDK_INT;
            if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                tvWFH.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.outline_blue_button));
                tvWFH.setTextColor(ContextCompat.getColor(context, R.color.purple_500));

                tvWFO.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.outline_blue_button_selected));
                tvWFO.setTextColor(ContextCompat.getColor(context, R.color.white));

                tvVisit.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.outline_blue_button));
                tvVisit.setTextColor(ContextCompat.getColor(context, R.color.purple_500));
            } else {
                tvWFH.setBackground(ContextCompat.getDrawable(context, R.drawable.outline_blue_button));
                tvWFH.setTextColor(ContextCompat.getColor(context, R.color.purple_500));

                tvWFO.setBackground(ContextCompat.getDrawable(context, R.drawable.outline_blue_button_selected));
                tvWFO.setTextColor(ContextCompat.getColor(context, R.color.white));

                tvVisit.setBackground(ContextCompat.getDrawable(context, R.drawable.outline_blue_button));
                tvVisit.setTextColor(ContextCompat.getColor(context, R.color.purple_500));
            }

        });

        tvVisit.setOnClickListener(view1 -> {
            final int sdk = android.os.Build.VERSION.SDK_INT;
            if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                tvWFH.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.outline_blue_button));
                tvWFH.setTextColor(ContextCompat.getColor(context, R.color.purple_500));

                tvWFO.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.outline_blue_button));
                tvWFO.setTextColor(ContextCompat.getColor(context, R.color.purple_500));

                tvVisit.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.outline_blue_button_selected));
                tvVisit.setTextColor(ContextCompat.getColor(context, R.color.white));
            } else {
                tvWFH.setBackground(ContextCompat.getDrawable(context, R.drawable.outline_blue_button));
                tvWFH.setTextColor(ContextCompat.getColor(context, R.color.purple_500));

                tvWFO.setBackground(ContextCompat.getDrawable(context, R.drawable.outline_blue_button));
                tvWFO.setTextColor(ContextCompat.getColor(context, R.color.purple_500));

                tvVisit.setBackground(ContextCompat.getDrawable(context, R.drawable.outline_blue_button_selected));
                tvVisit.setTextColor(ContextCompat.getColor(context, R.color.white));
            }

        });
        return view;
    }
}