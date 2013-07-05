package br.com.multiSoft;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import br.com.multiSoft.adapter.ImageAdapter;

public class Principal extends Activity {
	GridView gridView;
	/**
	 * Aqui fica todos os itens que tera o menu principal
	 */
	static String[] ITENS_MENU;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		gridView = (GridView) findViewById(R.id.gridView1);
		ITENS_MENU = getResources().getStringArray(R.array.menu_principal_item);
		gridView.setAdapter(new ImageAdapter(this, ITENS_MENU, "menu_principal"));

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				clickEmItemGrindView(v);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}

	public void clickEmItemGrindView(View v) {
		Toast.makeText(getApplicationContext(),
				((TextView) v.findViewById(R.id.grid_item_label)).getText(),
				Toast.LENGTH_SHORT).show();

	}
}
