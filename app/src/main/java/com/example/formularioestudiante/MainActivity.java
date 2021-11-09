package com.example.formularioestudiante;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //------------------------------------------------------------------------

    private EditText edt_dni = null;
    private EditText edt_nombre = null;
    private Spinner sp_cursos = null;
    private EditText edt_fechan = null;
    private EditText edt_horap = null;

    //------------------------------------------------------------------------
    // Recoger variables a nivel de clase

    private String dni;
    private String nombre;
    private String curso;
    private String fechan;
    private String horap;

    //------------------------------------------------------------------------




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_dni = (EditText) findViewById(R.id.edt_dni);
        edt_nombre = (EditText) findViewById(R.id.edt_nombre);
        sp_cursos = (Spinner) findViewById(R.id.sp_cursos);
        edt_fechan = (EditText) findViewById(R.id.edt_fechan);
        edt_horap = (EditText) findViewById(R.id.edt_horap);
        //----------------------------------------------------------------------------

        if(sp_cursos != null)
        {
            String[] cursos = {"1º DAM", "2º DAM", "1º SMR", "2º SMR"};
            //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sa_cursos, R.layout.estilospinner);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.estilospinner, cursos);
            sp_cursos.setAdapter(adapter);
            sp_cursos.setOnItemSelectedListener(this);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        curso = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void mostrar_datos(View view) {
        dni = String.valueOf(edt_dni.getText());
        nombre = String.valueOf(edt_nombre.getText());
        fechan = String.valueOf(edt_fechan.getText());
        horap = String.valueOf(edt_horap.getText());
        //----------------------------------------------------------------------
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("DATOS DE USUARIO");
        alerta1.setMessage("Son correctos los datos proporcionados?..");
        alerta1.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mostrarAlumno();
            }
        });
        alerta1.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mostrarMensaje();
            }
        });
        alerta1.show();
        //----------------------------------------------------------------------

    }

    private void mostrarMensaje() {
        Toast.makeText(this, "VUELVE A ESCRIBIR LOS DATOS", Toast.LENGTH_LONG).show();
    }


    private void mostrarAlumno() {
        Toast.makeText(this, "dni->" + dni + "\n" + "nombre->" + nombre + "\n" + "curso->" + curso + "\n" + "fecha de nacimiento->" + fechan + "\n" + "hora preferida de llamada" + horap + "\n", Toast.LENGTH_SHORT).show();
    }


    public void coger_fecha(View view) {
        DatePickerFragment calendario1 = new DatePickerFragment();
        calendario1.show(getSupportFragmentManager(), "DatePicker");
    }


    public void coger_hora(View view) {
        TimePickerFragment reloj1 = new TimePickerFragment();
        reloj1.show(getSupportFragmentManager(), "TimePicker");
    }

    public void crearFecha(int anyo, int mes, int dia) {
        String texto_anyo = String.valueOf(anyo);
        String texto_mes = String.valueOf(mes);
        String texto_dia = String.valueOf(dia);
        fechan = texto_dia + "/" + texto_mes + "/" + texto_anyo;
        edt_fechan.setText(fechan);
    }

    public void crearHora(int horas, int minutos) {
        String texto_hora = "";
        String texto_minutos = "";
        if(horas < 10)
        {
            texto_hora = "0" + String.valueOf(horas);
        }
        else
        {
            texto_hora = String.valueOf(horas);
        }
        if(minutos < 10)
        {
            texto_minutos = "0" + String.valueOf(minutos);
        }
        else
        {
            texto_minutos = String.valueOf(minutos);
        }
        
        horap = texto_hora + ":" + texto_minutos;
        edt_horap.setText(horap);
    }
}