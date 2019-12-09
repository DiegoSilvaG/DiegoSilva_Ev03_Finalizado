package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Base_Act extends AppCompatActivity {

    private EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_);

        et1 = (EditText)findViewById(R.id.cod);
        et2 = (EditText)findViewById(R.id.nombre);
        et3 = (EditText)findViewById(R.id.precio);
    }
    public void añadirLibro(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Gestion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if (!et1.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo", et1.getText().toString());
            registro.put("nombre", et2.getText().toString());
            registro.put("precio",et3.getText().toString());

            BaseDeDatos.insert("libros", null, registro);
            BaseDeDatos.close();
            Toast.makeText(this,"Se a Ingresado un Libro", Toast.LENGTH_LONG).show();
        }
    }
    public void EliminarLibro(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Gestion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et1.getText().toString();//Se obtiene el codigo para eliminar el producto a partir del codigo
        BaseDeDatos.delete("libros", "codigo="+codigo, null);
        BaseDeDatos.close();
        Toast.makeText(this,"Elimine el producto con el codigo: "+codigo, Toast.LENGTH_SHORT).show();
    }
    public void ModificarLibros(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Gestion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String codigo = et1.getText().toString();
        ContentValues cont = new ContentValues();
        cont.put("codigo", et1.getText().toString());
        cont.put("nombre", et2.getText().toString());
        cont.put("precio", et3.getText().toString());

        if (!et1.getText().toString().isEmpty())
        {
            BaseDeDatos.update("libros", cont,"codigo="+codigo, null);
            Toast.makeText(this,"Se a actualizado el producto con el codigo: "+codigo, Toast.LENGTH_LONG).show();
        }
    }

}
