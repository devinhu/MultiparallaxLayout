package it.francescopezzato.android.multiparallaxlayout.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;

import com.afollestad.materialdialogs.MaterialDialog;

import it.francescopezzato.android.multiparallaxlayout.R;


public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		if (toolbar != null) {
			setSupportActionBar(toolbar);
		}
		getSupportFragmentManager()
			.beginTransaction().replace(R.id.content_container,new ExampleListFragment()).commit();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		if (id == R.id.action_settings) {
			about();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void about(){
		CharSequence content = Html.fromHtml(getString(R.string.dialog_about_content));
		new MaterialDialog.Builder(this)
			.title(R.string.dialog_about_title)
			.content(content)
			.positiveText(R.string.dialog_about_positive)
			.show();
	}
}
