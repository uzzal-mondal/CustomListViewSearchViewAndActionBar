package com.example.uzzal.customlistviewsearchviewandactionbar;

        import android.content.Intent;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        ActionBar actionBar = getSupportActionBar();
        TextView mDetailTv = findViewById(R.id.textView);


        Intent intent = getIntent();
        String myActionBarTitle = intent.getStringExtra("actionBarTitle");
        String mContetnt = intent.getStringExtra("contentPr");

        //setActionbar title
        actionBar.setTitle(myActionBarTitle);
        mDetailTv.setText(mContetnt);

    }
}
