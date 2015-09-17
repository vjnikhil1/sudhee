package com.example.sudhee;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import com.cbit.sudhee.R;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WebDesigning extends Activity {
	
	public static final MediaType FORM_DATA_TYPE = 
			MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
	public static final String URL="https://docs.google.com/forms/d/1pqcXbFZEHRAErpuZENpwmXu3E7jdskRVmIxIaza56GI/formResponse";
	public static final String NAME="entry_1492076163";
	public static final String EMAIL="entry_957890553";
	public static final String YEAR="entry_123685659";
	public static final String COLLEGE="entry_1827733209";
	public static final String PHONE="entry_2112343123";
	public static final String NODE="entry_1035681932";
	
	private Context context;
	private EditText nameEditText;
	private EditText emailEditText;
	private EditText yearEditText;
	private EditText collegeEditText;
	private EditText phoneEditText;
	private EditText nodeEditText;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_designing);
		context=this;
        Button sendButton = (Button)findViewById(R.id.button1);
        nameEditText = (EditText)findViewById(R.id.editText1);
        emailEditText = (EditText)findViewById(R.id.editText2);
        yearEditText = (EditText)findViewById(R.id.editText3);
        collegeEditText = (EditText)findViewById(R.id.editText4);
        phoneEditText = (EditText)findViewById(R.id.editText5);
        nodeEditText = (EditText)findViewById(R.id.editText6);
        sendButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PostDataTask postDataTask = new PostDataTask();
				if(nameEditText.getText().toString().trim().equals("")||emailEditText.getText().toString().trim().equals("")||yearEditText.getText().toString().trim().equals("")||collegeEditText.getText().toString().trim().equals("")||phoneEditText.getText().toString().trim().equals("")||nodeEditText.getText().toString().trim().equals(""))
				{
					Toast.makeText(context,"Please fill all the details",Toast.LENGTH_LONG).show();
				}
				else
				{
				postDataTask.execute(URL,nameEditText.getText().toString(),
                        emailEditText.getText().toString(),yearEditText.getText().toString(),
                        collegeEditText.getText().toString(),phoneEditText.getText().toString(),nodeEditText.getText().toString());
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
				}
			}
		});
		
	}

	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	private class PostDataTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... contactData) {
            Boolean result = true;
            String url = contactData[0];
            String name = contactData[1];
            String email = contactData[2];
            String year = contactData[3];
            String college = contactData[4];
            String phone = contactData[5];
            String node = contactData[6];
            String postBody="";
            
            try {
				//all values must be URL encoded to make sure that special characters like & | ",etc.
				//do not cause problems
                postBody = NAME+"=" + URLEncoder.encode(name,"UTF-8") + 
							"&" + EMAIL + "=" + URLEncoder.encode(email,"UTF-8") + 
							"&" + YEAR + "=" + URLEncoder.encode(year,"UTF-8") + 
							"&" + COLLEGE + "=" + URLEncoder.encode(college,"UTF-8") + 
							"&" + PHONE + "=" + URLEncoder.encode(phone,"UTF-8") + 
							"&" + NODE + "=" + URLEncoder.encode(node,"UTF-8");
            } catch (UnsupportedEncodingException ex) {
                result=false;
            }
            
            try{
                //Create OkHttpClient for sending request
				OkHttpClient client = new OkHttpClient();
				//Create the request body with the help of Media Type
                RequestBody body = RequestBody.create(FORM_DATA_TYPE, postBody);
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
				//Send the request
                Response response = client.newCall(request).execute();
            }catch (IOException exception){
                result=false;
            }
            return result;
        }

        @Override
        protected void onPostExecute(Boolean result){
			//Print Success or failure message accordingly
            Toast.makeText(context,result?"Congratulations! You've successfully registered for Tech Fun":"There was some error in sending message. Please try again after some time.",Toast.LENGTH_LONG).show();
        }

    }
}
