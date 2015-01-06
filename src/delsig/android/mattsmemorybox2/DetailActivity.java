package delsig.android.mattsmemorybox2;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class DetailActivity extends Activity {

	private float lastX;
	private ViewFlipper v;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book);
		v  = (ViewFlipper) findViewById(R.id.flipper); //pages
		int page = 0; //page numbers
		Intent i = this.getIntent();
		ArrayList<Integer> pics = i.getIntegerArrayListExtra("photos"); 
		
		String title = i.getStringExtra("title");
		TextView t = (TextView) findViewById(R.id.pgTitle);
		t.setText(title);
		
		while(page < pics.size()){ //while you can still load two images per page
			//super awful ghettolicous hack to make layouts
			
			ImageView img = new ImageView(this);
			img.setImageResource(pics.get(page));
			
			v.addView(img);
			page++;
		}
		
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	public boolean onTouchEvent(MotionEvent touchevent)
	{
		switch (touchevent.getAction())
		{
		case MotionEvent.ACTION_DOWN:
		{
		lastX = touchevent.getX();
		break;
		}
		case MotionEvent.ACTION_UP:
		{
		float currentX = touchevent.getX();
		if (lastX < currentX)
		{
		if (v.getDisplayedChild()==0) break;
		v.setInAnimation(this, R.anim.in_from_left);
		v.setOutAnimation(this, R.anim.out_to_right);
		v.showNext();
		}
		if (lastX > currentX)
		{
		if (v.getDisplayedChild()==1) break;
		v.setInAnimation(this, R.anim.in_from_right);
		v.setOutAnimation(this, R.anim.out_to_left);
		v.showPrevious();
		}
		break;
		}
		}
		return false;
		}
	
}
