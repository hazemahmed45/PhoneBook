package com.example.hazem.phonebook.Features.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hazem.phonebook.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KeyPadFragment extends Fragment {

    ViewGroup KeyPad;
    Button one,two,three,four,five,six,seven,eight,nine,zero,astric,sharp;
    ImageView callButton,deleteNum;
    ImageButton callKeyPad;
    View view;
    TextView DialNum;
    public KeyPadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.key_pad_fragment, container, false);
        SettingIDs();
        SettingEvents();
        return view;
    }
    void SettingIDs()
    {
        DialNum= (TextView) view.findViewById(R.id.dial_num);
        KeyPad= (ViewGroup) view.findViewById(R.id.keypad_view);
        one= (Button) view.findViewById(R.id.one);
        two= (Button) view.findViewById(R.id.two);
        three= (Button) view.findViewById(R.id.three);
        four= (Button) view.findViewById(R.id.four);
        five= (Button) view.findViewById(R.id.five);
        six= (Button) view.findViewById(R.id.six);
        seven= (Button) view.findViewById(R.id.seven);
        eight= (Button) view.findViewById(R.id.eight);
        nine= (Button) view.findViewById(R.id.nine);
        astric= (Button) view.findViewById(R.id.astric);
        zero= (Button) view.findViewById(R.id.zero);
        sharp= (Button) view.findViewById(R.id.sharp);
        callKeyPad= (ImageButton) view.findViewById(R.id.call_keypad);
        callButton= (ImageView) view.findViewById(R.id.call_button);
        deleteNum= (ImageView) view.findViewById(R.id.delete_num);

        KeyPad.setVisibility(View.GONE);
    }
    void SettingEvents()
    {
        callKeyPad.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View view) {
                slideUpDown(KeyPad);
            }
        });
        SetttingNumbersClickListener(one);
        SetttingNumbersClickListener(two);
        SetttingNumbersClickListener(three);
        SetttingNumbersClickListener(four);
        SetttingNumbersClickListener(five);
        SetttingNumbersClickListener(six);
        SetttingNumbersClickListener(seven);
        SetttingNumbersClickListener(eight);
        SetttingNumbersClickListener(nine);
        SetttingNumbersClickListener(astric);
        SetttingNumbersClickListener(sharp);
        SetttingNumbersClickListener(zero);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                intent.setData(Uri.parse("tel:" + DialNum.getText()));
                KeyPadFragment.this.startActivity(intent);
            }
        });
        deleteNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialNum.setText("");
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void slideUpDown(final View view)
    {
        if(!view.isShown()) {
            // Show the panel
            Animation bottomUp = AnimationUtils.loadAnimation(this.getContext(),
                    R.anim.slideup);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) callKeyPad.getLayoutParams();
            params.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            params.addRule(RelativeLayout.ABOVE,R.id.keypad_view);
//            callButton.startAnimation(bottomUp);
            KeyPad.startAnimation(bottomUp);
            KeyPad.setVisibility(View.VISIBLE);
        }
        else {
            // Hide the Panel
            Animation bottomDown = AnimationUtils.loadAnimation(this.getContext(),
                    R.anim.slidedown);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) callKeyPad.getLayoutParams();
            params.removeRule(RelativeLayout.ABOVE);
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//            KeyPad.startAnimation(bottomDown);
            callKeyPad.startAnimation(bottomDown);
            KeyPad.setVisibility(View.GONE);
        }
    }

    void SetttingNumbersClickListener(final Button button)
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer buffer=new StringBuffer(DialNum.getText().toString());
                buffer.append(button.getText().toString());
                DialNum.setText(buffer.toString());
            }
        });
    }
}
