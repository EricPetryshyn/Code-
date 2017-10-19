package com.example.t00229613.calculator;

import android.annotation.TargetApi;
import android.content.Context;
import java.text.DecimalFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
@TargetApi(Build.VERSION_CODES.N)
public class Fragment2 extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    double result = 0;
    int sign = 1;
    String calc;
    boolean negative =false;
    double memory = 0;
    double current = 0;
    String zeros = "";
    OnFragmentInteractionListener listener;
    DecimalFormat style = new DecimalFormat("#.####");
    Button button01, button02, button03, button04, button05, button06, button07, button08, button09,
            button10, button11, button12, button13, button14, button15, button16, button17, button18,
            button19, button20, button21, button22;

    private OnFragmentInteractionListener mListener;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
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
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button01:
                memory = 0;

                break;

            case R.id.button02:
                current = memory;
                sign = 2;
                listener.onTextChange(String.valueOf(style.format(current)));

                break;

            case R.id.button03:
                memory += current;

                break;

            case R.id.button04:
                memory -= current;

                break;

            case R.id.button05:
                result = 0;
                sign = 1;
                negative =false;
                current = 0;
                zeros = "";
                calc = null;
                listener.onTextChange(String.valueOf(style.format(current)));

                break;

            case R.id.button06:
                if(negative){
                    negative = false;
                }
                else{
                    negative = true;
                }
                if(sign == 2){
                    current = 0;
                }
                if(negative){
                    listener.onTextChange("-" + (String.valueOf(style.format(current))));
                }
                else{
                    listener.onTextChange(String.valueOf(style.format(current)));
                }

                break;

            case R.id.button21:
                if(sign == 2){
                    current = 0;
                }
                if(sign >= 0 && sign < 3) {
                    sign = 3;
                    if(negative){
                        listener.onTextChange("-" + (String.valueOf(style.format(current))) + ".");
                    }
                    else{
                        listener.onTextChange((String.valueOf(style.format(current))) + ".");
                    }
                }

                break;

            case R.id.button08:
                if(String.valueOf(style.format(current)).length() < 9 || sign == 2) {
                    if (sign == 0 && current != 0) {
                        current = (current * 10) + 1;
                    } else if (sign == 3) {
                        current = current + .1;
                        sign = 4;
                    } else if (sign >= 4 && sign < 7) {
                        String temp = String.valueOf(style.format(current)) + zeros + "1";
                        zeros = "";
                        sign += 1;
                        current = Double.parseDouble(temp);
                    } else if (sign != 7) {
                        sign = 0;
                        current = 1;
                    }
                    if (negative) {
                        listener.onTextChange("-" + (String.valueOf(style.format(current))) + zeros);
                    } else {
                        listener.onTextChange(String.valueOf(style.format(current)) + zeros);
                    }
                }

                break;

            case R.id.button09:
                if(String.valueOf(style.format(current)).length() < 9 || sign == 2) {
                    if (sign == 0 && current != 0) {
                        current = (current * 10) + 2;
                    } else if (sign == 3) {
                        current = current + .2;
                        sign = 4;
                    } else if (sign >= 4 && sign < 7) {
                        String temp = String.valueOf(style.format(current)) + zeros + "2";
                        zeros = "";
                        sign += 1;
                        current = Double.parseDouble(temp);
                    } else if (sign != 7) {
                        sign = 0;
                        current = 2;
                    }
                    if (negative) {
                        listener.onTextChange("-" + (String.valueOf(style.format(current))) + zeros);
                    } else {
                        listener.onTextChange(String.valueOf(style.format(current)) + zeros);
                    }
                }

                break;

            case R.id.button10:
                if(String.valueOf(style.format(current)).length() < 9 || sign == 2) {
                    if (sign == 0 && current != 0) {
                        current = (current * 10) + 3;
                    } else if (sign == 3) {
                        current = current + .3;
                        sign = 4;
                    } else if (sign >= 4 && sign < 7) {
                        String temp = String.valueOf(style.format(current)) + zeros + "3";
                        zeros = "";
                        sign += 1;
                        current = Double.parseDouble(temp);
                    } else if (sign != 7) {
                        sign = 0;
                        current = 3;
                    }
                    if (negative) {
                        listener.onTextChange("-" + (String.valueOf(style.format(current))) + zeros);
                    } else {
                        listener.onTextChange(String.valueOf(style.format(current)) + zeros);
                    }
                }

                break;

            case R.id.button12:
                if(String.valueOf(style.format(current)).length() < 9 || sign == 2) {
                    if (sign == 0 && current != 0) {
                        current = (current * 10) + 4;
                    } else if (sign == 3) {
                        current = current + .4;
                        sign = 4;
                    } else if (sign >= 4 && sign < 7) {
                        String temp = String.valueOf(style.format(current)) + zeros + "4";
                        zeros = "";
                        sign += 1;
                        current = Double.parseDouble(temp);
                    } else if (sign != 7) {
                        sign = 0;
                        current = 4;
                    }
                    if (negative) {
                        listener.onTextChange("-" + (String.valueOf(style.format(current))) + zeros);
                    } else {
                        listener.onTextChange(String.valueOf(style.format(current)) + zeros);
                    }
                }

                break;

            case R.id.button13:
                if(String.valueOf(style.format(current)).length() < 9 || sign == 2) {
                    if (sign == 0 && current != 0) {
                        current = (current * 10) + 5;
                    } else if (sign == 3) {
                        current = current + .5;
                        sign = 4;
                    } else if (sign >= 4 && sign < 7) {
                        String temp = String.valueOf(style.format(current)) + zeros + "5";
                        zeros = "";
                        sign += 1;
                        current = Double.parseDouble(temp);
                    } else if (sign != 7) {
                        sign = 0;
                        current = 5;
                    }
                    if (negative) {
                        listener.onTextChange("-" + (String.valueOf(style.format(current))) + zeros);
                    } else {
                        listener.onTextChange(String.valueOf(style.format(current)) + zeros);
                    }
                }

                break;

            case R.id.button14:
                if(String.valueOf(style.format(current)).length() < 9 || sign == 2) {
                    if (sign == 0 && current != 0) {
                        current = (current * 10) + 6;
                    } else if (sign == 3) {
                        current = current + .6;
                        sign = 4;
                    } else if (sign >= 4 && sign < 7) {
                        String temp = String.valueOf(style.format(current)) + zeros + "6";
                        zeros = "";
                        sign += 1;
                        current = Double.parseDouble(temp);
                    } else if (sign != 7) {
                        sign = 0;
                        current = 6;
                    }
                    if (negative) {
                        listener.onTextChange("-" + (String.valueOf(style.format(current))) + zeros);
                    } else {
                        listener.onTextChange(String.valueOf(style.format(current)) + zeros);
                    }
                }

                break;

            case R.id.button16:
                if(String.valueOf(style.format(current)).length() < 9 || sign == 2) {
                    if (sign == 0 && current != 0) {
                        current = (current * 10) + 7;
                    } else if (sign == 3) {
                        current = current + .7;
                        sign = 4;
                    } else if (sign >= 4 && sign < 7) {
                        String temp = String.valueOf(style.format(current)) + zeros + "7";
                        zeros = "";
                        sign += 1;
                        current = Double.parseDouble(temp);
                    } else if (sign != 7) {
                        sign = 0;
                        current = 7;
                    }
                    if (negative) {
                        listener.onTextChange("-" + (String.valueOf(style.format(current))) + zeros);
                    } else {
                        listener.onTextChange(String.valueOf(style.format(current)) + zeros);
                    }
                }

                break;

            case R.id.button17:
                if(String.valueOf(style.format(current)).length() < 9 || sign == 2) {
                    if (sign == 0 && current != 0) {
                        current = (current * 10) + 8;
                    } else if (sign == 3) {
                        current = current + .8;
                        sign = 4;
                    } else if (sign >= 4 && sign < 7) {
                        String temp = String.valueOf(style.format(current)) + zeros + "8";
                        zeros = "";
                        sign += 1;
                        current = Double.parseDouble(temp);
                    } else if (sign != 7) {
                        sign = 0;
                        current = 8;
                    }
                    if (negative) {
                        listener.onTextChange("-" + (String.valueOf(style.format(current))) + zeros);
                    } else {
                        listener.onTextChange(String.valueOf(style.format(current)) + zeros);
                    }
                }

                break;

            case R.id.button18:
                if(String.valueOf(style.format(current)).length() < 9 || sign == 2) {
                    if (sign == 0 && current != 0) {
                        current = (current * 10) + 9;
                    } else if (sign == 3) {
                        current = current + .9;
                        sign = 4;
                    } else if (sign >= 4 && sign < 7) {
                        String temp = String.valueOf(style.format(current)) + zeros + "9";
                        zeros = "";
                        current = Double.parseDouble(temp);
                        sign += 1;
                    } else if (sign != 7) {
                        sign = 0;
                        current = 9;
                    }
                    if (negative) {
                        listener.onTextChange("-" + (String.valueOf(style.format(current))) + zeros);
                    } else {
                        listener.onTextChange(String.valueOf(style.format(current)) + zeros);
                    }
                }

                break;

            case R.id.button20:
                if(String.valueOf(style.format(current)).length() < 9 || sign == 2) {
                    if (sign == 0 && current != 0) {
                        current = (current * 10) + 0;
                    } else if (sign == 3) {
                        zeros = ".0";
                        sign = 4;
                    } else if (sign >= 4 && sign < 7) {
                        zeros += "0";
                        sign += 1;
                    } else if (sign != 7) {
                        sign = 0;
                        current = 0;
                    }
                    if (negative) {
                        listener.onTextChange("-" + (String.valueOf(style.format(current))) + zeros);
                    } else {
                        listener.onTextChange(String.valueOf(style.format(current)) + zeros);
                    }
                }

                break;

            case R.id.button19:
                if(sign != 1){
                    if(negative){
                        current = current * (-1);
                    }
                    if(calc == "+"){
                        result = result + current;
                    }
                    else if(calc == "-"){
                        result = result - current;
                    }
                    else if(calc == "*"){
                        result = result * current;
                    }
                    else if(calc == "/"){
                        result = result / current;
                    }
                    else{
                        result = current;
                    }
                    sign = 1;
                    negative = false;
                    calc = "+";
                    current = 0;
                    zeros = "";
                    if (String.valueOf(style.format(result)).length() <= 11) {
                        listener.onTextChange(String.valueOf(style.format(result)));
                    }else if (String.valueOf(style.format(result)).length() >= 100) {
                        listener.onTextChange("Error");
                    }else {
                        listener.onTextChange(String.valueOf(style.format(result)).substring(0,1) + "." + String.valueOf(style.format(result)).substring(1,5) + "e+" + (String.valueOf(style.format(result)).length()-1));
                    }
                }

            case R.id.button15:
                if(sign != 1){
                    if(negative){
                        current = current * (-1);
                    }
                    if(calc == "+"){
                        result = result + current;
                    }
                    else if(calc == "-"){
                        result = result - current;
                    }
                    else if(calc == "*"){
                        result = result * current;
                    }
                    else if(calc == "/"){
                        result = result / current;
                    }
                    else{
                        result = current;
                    }
                    sign = 1;
                    negative = false;
                    calc = "-";
                    current = 0;
                    zeros = "";
                    if (String.valueOf(style.format(result)).length() <= 11) {
                        listener.onTextChange(String.valueOf(style.format(result)));
                    }else if (String.valueOf(style.format(result)).length() >= 100) {
                        listener.onTextChange("Error");
                    }else {
                        listener.onTextChange(String.valueOf(style.format(result)).substring(0,1) + "." + String.valueOf(style.format(result)).substring(1,5) + "e+" + (String.valueOf(style.format(result)).length()-1));
                    }
                }

            case R.id.button11:
                if(sign != 1){
                    if(negative){
                        current = current * (-1);
                    }
                    if(calc == "+"){
                        result = result + current;
                    }
                    else if(calc == "-"){
                        result = result - current;
                    }
                    else if(calc == "*"){
                        result = result * current;
                    }
                    else if(calc == "/"){
                        result = result / current;
                    }
                    else{
                        result = current;
                    }
                    sign = 1;
                    negative = false;
                    calc = "*";
                    current = 0;
                    zeros = "";
                    if (String.valueOf(style.format(result)).length() <= 11) {
                        listener.onTextChange(String.valueOf(style.format(result)));
                    }else if (String.valueOf(style.format(result)).length() >= 100) {
                        listener.onTextChange("Error");
                    }else {
                        listener.onTextChange(String.valueOf(style.format(result)).substring(0,1) + "." + String.valueOf(style.format(result)).substring(1,5) + "e+" + (String.valueOf(style.format(result)).length()-1));
                    }
                }

            case R.id.button07:
                if(sign != 1){
                    if(negative){
                        current = current * (-1);
                    }
                    if(calc == "+"){
                        result = result + current;
                    }
                    else if(calc == "-"){
                        result = result - current;
                    }
                    else if(calc == "*"){
                        result = result * current;
                    }
                    else if(calc == "/"){
                        result = result / current;
                    }
                    else{
                        result = current;
                    }
                    sign = 1;
                    negative = false;
                    calc = "/";
                    current = 0;
                    zeros = "";
                    if (String.valueOf(style.format(result)).length() <= 11) {
                        listener.onTextChange(String.valueOf(style.format(result)));
                    }else if (String.valueOf(style.format(result)).length() >= 100) {
                        listener.onTextChange("Error");
                    }else {
                        listener.onTextChange(String.valueOf(style.format(result)).substring(0,1) + "." + String.valueOf(style.format(result)).substring(1,5) + "e+" + (String.valueOf(style.format(result)).length()-1));
                    }
                }

            case R.id.button22:
                if(sign != 1) {
                    if (negative) {
                        current = current * (-1);
                    }
                    if (calc == "+") {
                        result = result + current;
                    } else if (calc == "-") {
                        result = result - current;
                    } else if (calc == "*") {
                        result = result * current;
                    } else if (calc == "/") {
                        if (current == 0) {
                            result = 0;
                            sign = 1;
                            negative = false;
                            current = 0;
                            zeros = "";
                            calc = null;
                            listener.onTextChange("Error");
                            break;
                        } else {
                            result = result / current;
                        }
                    } else {
                        result = current;
                    }
                    negative = false;
                    sign = 2;
                    calc = null;
                    current = result;
                    zeros = "";
                    if (String.valueOf(style.format(result)).length() <= 11) {
                        listener.onTextChange(String.valueOf(style.format(result)));
                    }else if (String.valueOf(style.format(result)).length() >= 100) {
                        listener.onTextChange("Error");
                    }else {
                        listener.onTextChange(String.valueOf(style.format(result)).substring(0,1) + "." + String.valueOf(style.format(result)).substring(1,5) + "e+" + (String.valueOf(style.format(result)).length()-1));
                    }
                }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        button01 = (Button) view.findViewById(R.id.button01);
        button01.setOnClickListener(this);
        button02 = (Button) view.findViewById(R.id.button02);
        button02.setOnClickListener(this);
        button03 = (Button) view.findViewById(R.id.button03);
        button03.setOnClickListener(this);
        button04 = (Button) view.findViewById(R.id.button04);
        button04.setOnClickListener(this);
        button05 = (Button) view.findViewById(R.id.button05);
        button05.setOnClickListener(this);
        button06 = (Button) view.findViewById(R.id.button06);
        button06.setOnClickListener(this);
        button07 = (Button) view.findViewById(R.id.button07);
        button07.setOnClickListener(this);
        button08 = (Button) view.findViewById(R.id.button08);
        button08.setOnClickListener(this);
        button09 = (Button) view.findViewById(R.id.button09);
        button09.setOnClickListener(this);
        button10 = (Button) view.findViewById(R.id.button10);
        button10.setOnClickListener(this);
        button11 = (Button) view.findViewById(R.id.button11);
        button11.setOnClickListener(this);
        button12 = (Button) view.findViewById(R.id.button12);
        button12.setOnClickListener(this);
        button13 = (Button) view.findViewById(R.id.button13);
        button13.setOnClickListener(this);
        button14 = (Button) view.findViewById(R.id.button14);
        button14.setOnClickListener(this);
        button15 = (Button) view.findViewById(R.id.button15);
        button15.setOnClickListener(this);
        button16 = (Button) view.findViewById(R.id.button16);
        button16.setOnClickListener(this);
        button17 = (Button) view.findViewById(R.id.button17);
        button17.setOnClickListener(this);
        button18 = (Button) view.findViewById(R.id.button18);
        button18.setOnClickListener(this);
        button19 = (Button) view.findViewById(R.id.button19);
        button19.setOnClickListener(this);
        button20 = (Button) view.findViewById(R.id.button20);
        button20.setOnClickListener(this);
        button21 = (Button) view.findViewById(R.id.button21);
        button21.setOnClickListener(this);
        button22 = (Button) view.findViewById(R.id.button22);
        button22.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        public void onTextChange(CharSequence newText);
    }

    public void setListener(OnFragmentInteractionListener listener){
        this.listener = listener;
    }
}
