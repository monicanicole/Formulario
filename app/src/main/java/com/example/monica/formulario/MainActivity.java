package com.example.monica.formulario;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtnombre;
    EditText txtidentificacion;
    EditText txtapellido;
    EditText txtemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtidentificacion=(EditText)findViewById(R.id.txtidentificacion);
        txtnombre=(EditText)findViewById(R.id.txtnombre);
        txtapellido=(EditText)findViewById(R.id.txtapellido);
        txtemail=(EditText)findViewById(R.id.txtemail);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_cliente,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.action_add:
                String ident=txtidentificacion.getText().toString();
                String nombre=txtnombre.getText().toString();
                String apellido=txtapellido.getText().toString();
                String email=txtemail.getText().toString();

                if(ident.length() > 0 && nombre.length() > 0 && apellido.length() > 0 && email.length() >0 ){
                    Base usuario=new Base(this, "DBClientes",null,1);
                    SQLiteDatabase db=usuario.getWritableDatabase();
                    db.execSQL("INSERT INTO Cliente (identificacion,nombre, apellido,email) VALUES("+ident+",'"+nombre+"','"+apellido+"','"+email+"')");
                    db.close();
                    Toast.makeText(this, "El usuario se ha creado", Toast.LENGTH_SHORT).show();
                    txtidentificacion.setText("");
                    txtnombre.setText("");
                    txtapellido.setText("");
                    txtemail.setText("");
                }else {
                    Toast.makeText(this, "Debe ingresar todos los datos", Toast.LENGTH_SHORT).show();


                }

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
