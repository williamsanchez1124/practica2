package williamsnchez.tercero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText variable1= (EditText)findViewById(R.id.variable1);
        final EditText variable2= (EditText)findViewById(R.id.variable2);
        final RadioGroup figura= (RadioGroup)findViewById(R.id.figura);
        Button calcular= (Button)findViewById(R.id.calcular);
        final TextView resultado= (TextView)findViewById(R.id.area);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nume1=0;
                double nume2=0;
                double resultados=0;



                switch (figura.getCheckedRadioButtonId()){

                    case R.id.cuadro:
                        nume1=Double.parseDouble(variable1.getText().toString());
                        resultados= nume1*nume1;
                        resultado.setText(String.valueOf(resultados));

                    break;

                    case R.id.circulo:
                        nume1=Double.parseDouble(variable1.getText().toString());
                        resultados= Math.PI*nume1*nume1;
                        resultado.setText(String.valueOf(resultados));

                        break;

                    case R.id.triangulo:
                        nume1=Double.parseDouble(variable1.getText().toString());
                        nume2=Double.parseDouble(variable2.getText().toString());
                        resultados= nume1*nume2/2;
                        resultado.setText(String.valueOf(resultados));

                        break;

                    case R.id.rectangulo:
                        nume1=Double.parseDouble(variable1.getText().toString());
                        nume2=Double.parseDouble(variable2.getText().toString());
                        resultados= nume1*nume2;
                        resultado.setText(String.valueOf(resultados));

                        break;



                }
            }
        });

       figura.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {

               switch (checkedId){

                   case R.id.cuadro:

                       variable1.setVisibility(View.VISIBLE);
                       variable2.setVisibility(View.INVISIBLE);
                       variable1.setHint("lado");
                       resultado.setVisibility(View.VISIBLE);
                       variable1.setText("");
                       variable2.setText("");
                       break;

                   case R.id.circulo:

                       variable1.setVisibility(View.VISIBLE);
                       variable2.setVisibility(View.INVISIBLE);
                       variable1.setHint("radio");
                       resultado.setVisibility(View.VISIBLE);
                       variable1.setText("");
                       variable2.setText("");
                       break;

                   case R.id.triangulo:

                       variable1.setVisibility(View.VISIBLE);
                       variable1.setHint("altura");
                       variable2.setVisibility(View.VISIBLE);
                       variable2.setHint("base");
                       resultado.setVisibility(View.VISIBLE);
                       variable1.setText("");
                       variable2.setText("");
                       break;

                   case R.id.rectangulo:

                       variable1.setVisibility(View.VISIBLE);
                       variable1.setHint("base");
                       variable2.setVisibility(View.VISIBLE);
                       variable2.setHint("altura");
                       resultado.setVisibility(View.VISIBLE);
                       variable1.setText("");
                       variable2.setText("");
                       break;

               }


           }
       });
    }
}
