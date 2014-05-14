package example.ejercicios;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	EditText textoEscrito;
	RadioButton figura;
	RadioButton texto;
	Spinner background;
	Spinner color;
	CheckBox figCirculo;
	CheckBox figRectangulo;
	CheckBox figPunto;
	CheckBox figImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoEscrito=(EditText) findViewById(R.id.textoEscrito);
        figura=(RadioButton) findViewById(R.id.figura);
        texto=(RadioButton) findViewById(R.id.texto);
        background=(Spinner) findViewById(R.id.background);
        color=(Spinner) findViewById(R.id.color);
        figCirculo=(CheckBox) findViewById(R.id.figCirculo);
        figRectangulo=(CheckBox) findViewById(R.id.figRectangulo);
        figPunto=(CheckBox) findViewById(R.id.figPunto);
        figImagen=(CheckBox) findViewById(R.id.figImagen);
        
        String []opciones={"Azul", "Rojo", "Amarillo", "Verde"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        background.setAdapter(adapter);
        color.setAdapter(adapter);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void enviar(View v) // View es para un metodo click
    {   	
    	Intent i=new Intent(this,dos.class);
    	i.putExtra("textoEscrito", textoEscrito.getText().toString());
    	i.putExtra("figura", figura.isChecked());
    	i.putExtra("texto", texto.isChecked());
    	i.putExtra("background", background.getSelectedItem().toString());
    	i.putExtra("color", color.getSelectedItem().toString());
    	startActivity(i);
    }
    
}
