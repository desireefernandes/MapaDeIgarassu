package iphan.pibex.igarassu.ifpe.edu.br.ui.activity;

import android.os.Bundle;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import iphan.pibex.igarassu.ifpe.edu.br.R;

public class SeeMoreActivity extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_more);

        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        String address = b.getString("address");
        String description = b.getString("description");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_see_more);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(name);

        TextView tv_address = (TextView) findViewById(R.id.tv_description);
        tv_address.setText(Html.fromHtml("<b>Endereço:</b> "
                + "<br> " + address
                + "<br> <br>" +
                "<b>Descrição:</b> "
                + "<br>" + description
        ));

        toolbarTextAppearance();

    }


    private void toolbarTextAppearance() {
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
