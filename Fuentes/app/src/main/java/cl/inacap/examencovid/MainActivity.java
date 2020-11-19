package cl.inacap.examencovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView rutTxt, claveTxt;
    private Button btnIngreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.rutTxt = findViewById(R.id.txtNombre);
        this.claveTxt = findViewById(R.id.txtPass);
        this.btnIngreso = findViewById(R.id.btnInicioSecion);

        this.btnIngreso.setOnClickListener(view -> {
            String errores = "";
            String comparacion = null;
            if(rutTxt.getText().toString().isEmpty()){
                errores = errores + ("Debe ingresar nombre de usuario\n" );
                rutTxt.setBackground(getDrawable(R.drawable.borde_text));

            }else{
                rutTxt.setBackgroundColor(Color.WHITE);
                char extracto = rutTxt.getText().toString().charAt(rutTxt.getText().toString().length() - 2);
                if(rutTxt.getText().toString().length() == 9 || rutTxt.getText().toString().length() == 10 && extracto == '-'){
                    comparacion = rutTxt.getText().toString().substring(rutTxt.getText().toString().length() - 6, rutTxt.getText().toString().length() - 2);

                }else{
                    errores= errores + ("Nombre de usuario invalido\n");
                    rutTxt.setBackground(getDrawable(R.drawable.borde_text));
                }
            }
            int clave = 0;
            String clavePonderar = claveTxt.getText().toString().trim();
            if (clavePonderar.isEmpty()) {
                errores= errores + ("Debe ingresar su clave\n");
                claveTxt.setBackground(getDrawable(R.drawable.borde_text));


            }else {
                try {
                    clave = Integer.parseInt(clavePonderar);
                    if (clave >= 0 && comparacion.equals(claveTxt.getText().toString().trim())) {
                        claveTxt.setBackgroundColor(Color.WHITE);
                    }else{
                        errores= errores + ("clave incorrecta\n");
                        claveTxt.setBackground(getDrawable(R.drawable.borde_text));                    }
                } catch (Exception ex) {
                    errores= errores + ("Clave solo debe ser numeros\n");
                }
            }

            if(errores == ""){
                Toast.makeText(getApplicationContext(),"Login hecho con exito",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ListarPacientesActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(getApplicationContext(),errores.trim(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}