package com.example.touch;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OnTouchListener {

	int corx, cory;
	Lienzo fondo;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        corx = 100;
        cory = 100;
        RelativeLayout layout1=(RelativeLayout) findViewById(R.id.r1);
        fondo = new Lienzo(this);
        fondo.setOnTouchListener(this);
        layout1.addView(fondo);
    }
    
    public boolean onTouch(View v, MotionEvent event)
    {
    	corx = (int) event.getX();
    	cory = (int) event.getY();
    	Toast.makeText(this, corx+" "+cory, Toast.LENGTH_SHORT).show();
    	fondo.invalidate();
    	
		return false;
    }

    class Lienzo extends View{

		public Lienzo(Context context) {
			super(context);
		}
		
		protected void onDraw(Canvas canvas)
		{
			canvas.drawARGB(200+cory, 255-corx, 255, 0);
			
			Paint pincel = new Paint();
			pincel.setARGB(255, 255, 100, 20);
			//pincel.setStrokeWidth(4);
			canvas.drawCircle(corx, cory, 15, pincel);
		}
    	
    }
    
}
