package com.dwg.egou;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/4/9.
 */
public class siderBar extends View {
    private onTouchSiderBar onTouchSiderBar;
    private Paint paint = new Paint();
    private String cityName[] = {"热门","A","B","C","D","E","F","G","H",
            "I","G","K","L","M","N","O","P",
            "Q","R","S","T","U","V","W","X","Y","Z"};
    private float letterSize = 50;

    public siderBar(Context context) {
        super(context);
    }

    public siderBar(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.GRAY);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextSize(letterSize);
        int height = getHeight();
        int width = getWidth();
        int each_height = height/cityName.length;
        for (int i = 0;i<cityName.length;i++)
        {
            float x =(width-each_height)/2 ;
            float y =(i+1)*each_height;
            canvas.drawText(cityName[i],x,y,paint);
        }
    }

    public void setOnTouchSiderBar(onTouchSiderBar onTouchSiderBar) {
        this.onTouchSiderBar = onTouchSiderBar;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {


        int  c = (int)(event.getY()/getHeight()*cityName.length);
        this.onTouchSiderBar.setOnTouchLetterListener(cityName[c]);
        Log.e("touch事件触发了","touch事件触发了"+c);
        return super.dispatchTouchEvent(event);
    }

}
interface onTouchSiderBar {
    void setOnTouchLetterListener(String s);
}