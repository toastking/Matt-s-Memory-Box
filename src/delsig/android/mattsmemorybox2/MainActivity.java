package delsig.android.mattsmemorybox2;
/**
 * Father's day gift, an app to display photos and memories on a timeline
 * @author Matthew Del Signore
 */
import java.util.ArrayList;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		android.app.ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		
		LinearLayout layout = (LinearLayout)findViewById(R.id.LinearLayout1);
		ArrayList<PhotoSet> photosets = new ArrayList<PhotoSet>();
		final Intent i = new Intent(this, DetailActivity.class);
		
		//Declare all the photos
		PhotoSet longlongTime = new PhotoSet("A Long Long Time Ago","Pictures from when I was a baby/toddler");
		PhotoSet slightlyLessTime = new PhotoSet("Slightly less time ago", "Photos from when I was in middle school/junior high");
		PhotoSet recent = new PhotoSet("Recent History","Photos from high school/college");
		
		photosets.add(longlongTime);
		photosets.add(slightlyLessTime);
		photosets.add(recent);
		
		//long ago picture
		longlongTime.addPhoto(R.drawable.longlongtime1);
		longlongTime.addPhoto(R.drawable.longlongtime2);
		longlongTime.addPhoto(R.drawable.longlongtime3);
		longlongTime.addPhoto(R.drawable.longlongtime4);
		longlongTime.addPhoto(R.drawable.longlongtime5);
		longlongTime.addPhoto(R.drawable.longlongtime6);
		longlongTime.addPhoto(R.drawable.longlongtime7);
		
		//slightly less time
		slightlyLessTime.addPhoto(R.drawable.slightyless1); //messed up spelling of slightly
		slightlyLessTime.addPhoto(R.drawable.slightlyless2);
		slightlyLessTime.addPhoto(R.drawable.slightyless3);
		slightlyLessTime.addPhoto(R.drawable.slightlyless4);
		slightlyLessTime.addPhoto(R.drawable.slightlyless5);
		slightlyLessTime.addPhoto(R.drawable.slightlyless6);
		
		//recent pictures
		recent.addPhoto(R.drawable.recent1);
		recent.addPhoto(R.drawable.recent2);
		recent.addPhoto(R.drawable.recent3);
		recent.addPhoto(R.drawable.recent4);
		
		
		for(final PhotoSet p: photosets){
			Button button = new Button(this);
			button.setBackgroundColor(0000);
			button.setText("¥"+p.getName());  //increment chapter counter and generate the button text
			button.setTextAppearance(this, R.style.buttontxt);
			button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
			layout.addView(button);
			
			button.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					ArrayList<Integer >arr =  p.getPhotosList();
					i.putIntegerArrayListExtra("photos",arr); //changes the arraylist to an array so it can be sent as an extra
					i.putExtra("title",p.getName());
					
					startActivity(i);
					
					
				}
			});
		}
		
		
		
	}
}
