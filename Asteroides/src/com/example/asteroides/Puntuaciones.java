package com.example.asteroides;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

/*public class Puntuaciones extends ListActivity {

 @Override
 public void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.puntuaciones);
 setListAdapter(new ArrayAdapter<String>(this,
 android.R.layout.simple_list_item_1,
 Asteroides.almacen.listaPuntuaciones(10)));
 }

 }*/

public class Puntuaciones extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.puntuaciones);
		setListAdapter(new MiAdaptador(this, // Lista de Layouts a partir de
												// nuestro adaptador
				Asteroides.almacen.listaPuntuaciones(10)));
		/* Ejercicio (importante
		 * setListAdapter( //Lista de Layouts predefinidos con el texto de la
		 * lista) new ArrayAdapter<String>(this, R.layout.elemento_lista,
		 * R.id.titulo, Asteroides.almacen.listaPuntuaciones(10)));
		 */
	}

	@Override
	protected void onListItemClick(ListView listView, View view, int position,
			long id) {
		super.onListItemClick(listView, view, position, id);
		Object o = getListAdapter().getItem(position);
		Toast.makeText(this, "Selección: " + Integer.toString(position)
		+ " - " + o.toString(), Toast.LENGTH_LONG).show();
	}
}
