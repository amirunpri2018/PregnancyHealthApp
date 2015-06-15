package com.example.psingh.sohaapp;


    import android.app.Activity;
    import android.content.Context;
    import android.content.Intent;
    import android.database.sqlite.SQLiteDatabase;
    import android.graphics.Color;
    import android.os.Bundle;

    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;

    import android.webkit.WebView;
    import android.webkit.WebViewClient;

    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    import java.io.FileInputStream;
    import java.io.FileOutputStream;

    public class MainActivity extends Activity  {
        public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
        Button b1,b2;
        EditText ed1,ed2;

        TextView tx1;
        int counter = 3;
        private SQLiteDatabase PregnantInputDataDB;


        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            b1=(Button)findViewById(R.id.button);
            ed1=(EditText)findViewById(R.id.editText);
            ed2=(EditText)findViewById(R.id.editText2);
            b2=(Button)findViewById(R.id.button2);
            tx1=(TextView)findViewById(R.id.editText);
            tx1.setVisibility(View.GONE);

            PregnantInputDataDB = openOrCreateDatabase("PregnantInputDataDB", Context.MODE_PRIVATE, null);
            PregnantInputDataDB.execSQL("CREATE TABLE IF NOT EXISTS PregnantInputData(ID VARCHAR,phoneNumber VARCHAR,name VARCHAR, email VARCHAR" +
                    "passWord VARCHAR, currentDate VARCHAR, edDate VARCHAR);");


            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(ed1.getText().toString().equals("admin") &&

                            ed2.getText().toString().equals("admin")) {
                        Toast.makeText(getApplicationContext(), "Saving...",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                        tx1.setVisibility(View.VISIBLE);
                        tx1.setBackgroundColor(Color.RED);
                        counter--;
                        tx1.setText(Integer.toString(counter));

                        if (counter == 0) {
                            b1.setEnabled(false);
                        }
                    }
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.

            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

        /** Called when the user clicks the Save button */
        public void saveInformation(View view) {
            //create an Intent to start an activity called DisplayMessageActivity with the following code
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            EditText editText = (EditText) findViewById(R.id.editText);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);


        }


}
