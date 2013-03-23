package com.example.asteroides;

import java.util.Vector;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MiAdaptador extends BaseAdapter {

	private final Activity actividad;
	private final Vector<String> lista;
	public MiAdaptador(Activity actividad, Vector<String> lista) {
		super();
		this.actividad = actividad;
		this.lista = lista;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = actividad.getLayoutInflater();
		View view = inflater.inflate(R.layout.elemento_lista, null, true);
		TextView textView = (TextView) view.findViewById(R.id.titulo);
		textView.setText(lista.elementAt(position));
		String lspPuntiacion;
		lspPuntiacion = lista.elementAt(position).substring(0,6);
		Double ldPunt = Double.parseDouble(lspPuntiacion);
		int liSwitch = 2;
		if (ldPunt > 111000) liSwitch = 0;
		if (ldPunt == 111000) liSwitch = 1;
		if (ldPunt < 111000) liSwitch = 2;
		ImageView imageView = (ImageView) view.findViewById(R.id.icono);
		//switch (Math.round((float) Math.random() * 3)) {
		switch(liSwitch) {
		case 0:
			imageView.setImageResource(R.drawable.asteroide1);
			break;
		case 1:
			imageView.setImageResource(R.drawable.asteroide2);
			break;
		case 2:
			imageView.setImageResource(R.drawable.asteroide3);
			break;
		default:
			imageView.setImageResource(R.drawable.asteroide3);
			break;
		}
		return view;
	}
	public int getCount() {
		return lista.size();
	}
	public Object getItem(int arg0) {
		return lista.elementAt(arg0);
	}
	public long getItemId(int position) {
		return position;
	}

}
