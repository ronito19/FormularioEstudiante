package com.example.formularioestudiante;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;


public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        final Calendar c = Calendar.getInstance();
        int anyo = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd1 = new DatePickerDialog(getActivity(), this, anyo, mes, dia);
        return dpd1;

    }


    @Override
    public void onDateSet(DatePicker datePicker, int anyo, int mes, int dia) {
        MainActivity activity1 = (MainActivity) getActivity();
        activity1.crearFecha(anyo, mes, dia);
    }
}