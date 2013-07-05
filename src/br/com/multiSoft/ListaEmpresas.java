package br.com.multiSoft;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ListaEmpresas extends Activity {
	private ArrayAdapter<String> listaEmpresasAdapter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_empresas);
		ArrayList<String> teste= new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			teste.add("AFADFADFADS");
		}
		
		listaEmpresasAdapter = new ArrayAdapter<String>(this,
				android.R.layout.select_dialog_singlechoice, teste);
		
		atualizarListadeEmpresasVisiveis(null);
		adicionarAcaoAoDigitar();
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_empresas, menu);
		return true;
	}

	/**
	 * Metodo que ira acrescentar uma ação quando o texto mudar no textView
	 */
	public void adicionarAcaoAoDigitar() {
		EditText editText = (EditText) findViewById(R.id.textFilter);
		editText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				atualizarListadeEmpresasVisiveis(s);

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void atualizarListadeEmpresasVisiveis(CharSequence s) {
		if (s != null)
			listaEmpresasAdapter.getFilter().filter(s);
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(listaEmpresasAdapter);
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	}
	
}
