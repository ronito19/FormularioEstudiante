package com.example.formularioestudiante;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;


public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        Calendar calendario1 = Calendar.getInstance();
        int horas = calendario1.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario1.get(Calendar.MINUTE);
        TimePickerDialog tpd1 = new TimePickerDialog(getActivity(), this, horas, minutos, true);
        return tpd1;

    }


    @Override
    public void onTimeSet(TimePicker timePicker, int horas, int minutos) {
        MainActivity actividad1 = (MainActivity) getActivity();
        actividad1.crearHora(horas, minutos);
    }
}