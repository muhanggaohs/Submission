package com.angga.submission;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import static com.angga.submission.Home.EXTRA_FORM;
import static com.angga.submission.Home.EXTRA_NAME;
import static com.angga.submission.Home.EXTRA_URL;


public class Detail extends AppCompatActivity {
    public void onComposeAction(MenuItem mi) {
        Intent intent = new Intent(Detail.this,Home.class);
        startActivity(intent);
    }
    TextView name2,from;
    ImageView foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent =getIntent();
        String imageURL = intent.getStringExtra(EXTRA_URL);
        String name = intent.getStringExtra(EXTRA_NAME);
        String form = intent.getStringExtra(EXTRA_FORM);

        name2 = (TextView)findViewById(R.id.name);
        from = (TextView)findViewById(R.id.from);
        foto = (ImageView) findViewById(R.id.foto);

        Picasso.with(this).load(imageURL).fit().centerInside().into(foto);
        name2.setText(name);
        from.setText(form);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.kembali, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.kembali:
                Intent intent = new Intent(Detail.this,Home.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
