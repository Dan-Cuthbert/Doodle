package com.example.mydoodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Dan Cuthbert on 10/29/2016.
 */
public class DoodleView extends View{

    private List<SinglePath> _paths = new ArrayList<SinglePath>();
    private SinglePath _currItem;
    private int _red = 0;
    private int _blue = 0;
    private int _green = 0;
    private int _opacity = 255;
    private int _brushSize = 10;
    private int _gradient = 0;
    private int _grad_col1 = 0;
    private int _grad_col2 = 0;
    private int _grad_col3 = 0;

    public DoodleView(Context context) {
        super(context);
        init(null,0, Color.argb(_opacity,_red,_green,_blue), _brushSize);
    }

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs,0, Color.argb(_opacity,_red,_green,_blue), _brushSize);
    }

    public DoodleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs,defStyleAttr, Color.argb(_opacity,_red,_green,_blue), _brushSize);
    }

    private void init(AttributeSet attrs, int defStyleAttr, int color, int size){
        Path path = new Path();
        Paint paintDoodle = new Paint();
        paintDoodle.setColor(color);
        paintDoodle.setStyle(Paint.Style.STROKE);
        paintDoodle.setStrokeWidth(size);
        _currItem = new SinglePath(path, paintDoodle);

        _paths.add(_currItem);
    }

    private void init_grad(int col1, int col2, int col3){
        Path path = new Path();
        Paint paintDoodle = new Paint();
        paintDoodle.setStyle(Paint.Style.STROKE);
        paintDoodle.setStrokeWidth(_brushSize);
        _currItem = new SinglePath(path, paintDoodle);

        _currItem.get_paint().setAntiAlias(true);
        LinearGradient gradient = new LinearGradient(30, 0, 50, 0,
                new int[] {col1, col2, col3}, null, Shader.TileMode.MIRROR);
        _currItem.get_paint().setShader(gradient);
        PathEffect cornerEffect = new CornerPathEffect(10);
        _currItem.get_paint().setPathEffect(cornerEffect);

        _paths.add(_currItem);
    }

    public class SinglePath {
        private Path _path;
        private Paint _paint;

        public SinglePath (Path path, Paint paint){
            _path = path;
            _paint = paint;
        }

        public Path get_path() {
            return _path;
        }

        public Paint get_paint() {
            return _paint;
        }
    }

    public void reset() {
        for (SinglePath sp : _paths) {
            sp.get_path().reset();
        }
        invalidate();
    }

    public void setColor(int color, int flag){
        if(flag == 1)
            _red = color;
        else if(flag == 2)
            _green = color;
        else
            _blue = color;
        _gradient = 0;
    }

    public void setOpacity(int opac){
        _opacity = opac;
    }

    public void setBrushSize(int size){
        _brushSize = size;
    }

    public void setGradient(int randomness){
        _gradient = randomness;

        if(randomness == 1){
            _grad_col1 = generateGradient();
            _grad_col2 = generateGradient();
            _grad_col3 = generateGradient();
        }
    }

    private int generateGradient(){
        Random num = new Random();

        return Color.rgb(num.nextInt(255-0),num.nextInt(255-0),num.nextInt(255-0));
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        for (SinglePath sp : _paths) {
            canvas.drawPath(sp.get_path(), sp.get_paint());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();

        switch(motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(_gradient == 0)
                    init(null,0,Color.argb(_opacity, _red, _green, _blue), _brushSize);
                else if(_gradient == 1)
                    init_grad(_grad_col1,_grad_col2,_grad_col3);
                else
                    init_grad(generateGradient(),generateGradient(),generateGradient());
                _currItem.get_path().moveTo(touchX,touchY);
            case MotionEvent.ACTION_MOVE:
                _currItem.get_path().lineTo(touchX,touchY);
        }

        invalidate();
        return true;
    }
}