package williamsnchez.cuarto;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private String sexo;
    private static String fecha="";
    private String ciudad;
    private String hobbies;


public MainActivity()
    {

        ciudad="";
        hobbies="";
        sexo="";
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button botton = (Button)findViewById(R.id.aceptar);
        final EditText usuario = (EditText)findViewById(R.id.usuario);
        final EditText contraseña = (EditText)findViewById(R.id.contraseña);
        final EditText repetir = (EditText)findViewById(R.id.repetir);
        final EditText correo = (EditText)findViewById(R.id.correo);


        final Spinner spinner = (Spinner) findViewById(R.id.ciudad);
        final RadioGroup grupo = (RadioGroup)findViewById(R.id.sexo);
        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.masculino:

                        sexo="masculino";
                        break;
                    case R.id.femenino:
                        sexo="femenino";
                        break;
                }

            }
        });

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {
                        ciudad=String.valueOf(parent.getItemAtPosition(position));
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        ciudad="";
                    }
                });

        botton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hobbies="";
                verificar_hobbies();
                TextView resultado=(TextView)findViewById(R.id.verificar);
                if(usuario.getText().toString().equals("") || contraseña.getText().toString().equals("") || repetir.getText().toString().equals("")|| correo.getText().toString().equals("")|| hobbies.equals("")||sexo.equals("")|| ciudad.equals("") || fecha.equals("")){

                    resultado.setText("Lo sentimos, faltan datos");
                }
                else
                {
                    if (contraseña.getText().toString().equals(repetir.getText().toString())){

                        resultado.setText(" usuario: " +usuario.getText().toString() + "\n" +
                                "contraseña: " +contraseña.getText().toString() + "\n" +
                                " correo: " +correo.getText().toString() + "\n"+
                                " sexo: " +sexo + "\n"+
                                " fecha de nacimiento: " +fecha + "\n"+
                                " ciudad: " +ciudad + "\n"+
                                " hobbies: " +hobbies + "\n");
                    }
                  else

                    {

                        resultado.setText("las contraseñas no coinciden");
                    }

                }

            }
        });

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ciudades, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);


    }


    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public  static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            //procesamiento de los datos

            fecha= String.valueOf(day) +"/" + String.valueOf(month) +"/" + String.valueOf(year);
        }
    }

    public void verificar_hobbies(){
    if(((CheckBox)findViewById(R.id.futbol)).isChecked())
    {
        hobbies+="futbol ";

    }
        if(((CheckBox)findViewById(R.id.tv)).isChecked())
        {
            hobbies+="ver televisión ";

        }
        if(((CheckBox)findViewById(R.id.leer)).isChecked())
        {
            hobbies+="leer ";

        }
        if(((CheckBox)findViewById(R.id.dormir)).isChecked())
        {
            hobbies+="dormir ";

        }



    }

}
