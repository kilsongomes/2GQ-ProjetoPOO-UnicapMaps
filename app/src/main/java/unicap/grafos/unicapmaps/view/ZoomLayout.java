package unicap.grafos.unicapmaps.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import unicap.grafos.unicapmaps.R;

public class ZoomLayout extends FrameLayout implements ScaleGestureDetector.OnScaleGestureListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{

    Context context;
    private enum Mode {
        NONE,
        DRAG,
        ZOOM
    }

    private static final String TAG = "ZoomLayout";
    private static float MIN_ZOOM = 1.0f;
    private static float MAX_ZOOM = 4.0f;

    private Mode mode = Mode.NONE;
    private float scale = 1.0f;
    private float lastScaleFactor = 0f;

    // Where the finger first  touches the screen
    private float startX = 0f;
    private float startY = 0f;


    // How much to translate the canvas
    private float dx = 0f;
    private float dy = 0f;
    private float prevDx = 0f;
    private float prevDy = 0f;

    private GestureDetector gestureDetector;

    public ZoomLayout(Context context) {

        super(context);
        this.context = context;
        init(context);
    }

    public ZoomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context);
    }

    public ZoomLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init(context);
    }

    public float getScale() {
        return scale;
    }

    private void init(Context context) {
        final ScaleGestureDetector scaleDetector = new ScaleGestureDetector(context, this);
        gestureDetector = new GestureDetector(context, this);
        gestureDetector.setOnDoubleTapListener(this);

        this.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        //Log.i(TAG, "DOWN" + "x = " + motionEvent.getX() + ", " + "y = " + motionEvent.getY());
                        if (scale > MIN_ZOOM) {
                            mode = Mode.DRAG;
                            startX = motionEvent.getX() - prevDx;
                            startY = motionEvent.getY() - prevDy;
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:

                        if (mode == Mode.DRAG) {
                            dx = motionEvent.getX() - startX;
                            dy = motionEvent.getY() - startY;
                            Log.i(TAG, "DRAG " + "x = " + dx + ", " + "y = " + dy);
                        }

                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        mode = Mode.ZOOM;
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        mode = Mode.NONE;
                        break;
                    case MotionEvent.ACTION_UP:
                        //Log.i(TAG, "UP");
                        mode = Mode.ZOOM;
                        prevDx = dx;
                        prevDy = dy;
                        break;
                }
                scaleDetector.onTouchEvent(motionEvent);
                gestureDetector.onTouchEvent(motionEvent);


                if ((mode == Mode.DRAG && scale >= MIN_ZOOM) || mode == Mode.ZOOM) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    float maxDx = (child().getWidth() - (child().getWidth() / scale)) / 2 * scale;
                    float maxDy = (child().getHeight() - (child().getHeight() / scale))/ 2 * scale;
                    dx = Math.min(Math.max(dx, -maxDx), maxDx);
                    dy = Math.min(Math.max(dy, -maxDy), maxDy);
                    //Log.i(TAG, "Width: " + child().getWidth() + ", scale " + scale + ", dx " + dx + ", max " + maxDx + ", prevDx " + prevDx);
                    applyScaleAndTranslation();
                }

                return true;
            }

        });
    }

    public void ajustScale(){
        float escalaInicial;

        int alturaViewPort = getHeight();
        int alturaChild = child().getHeight();

        escalaInicial = 1.0f*alturaViewPort/alturaChild;

        scale = escalaInicial;
        applyScaleAndTranslation();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return super.onTouchEvent(e);
    }


    // ScaleGestureDetector
    @Override
    public boolean onScaleBegin(ScaleGestureDetector scaleDetector) {
        //Log.i(TAG, "onScaleBegin");
        return true;
    }

    @Override
    public boolean onScale(ScaleGestureDetector scaleDetector) {
        float scaleFactor = scaleDetector.getScaleFactor();
        //Log.i(TAG, "onScale" + scaleFactor);
        if (lastScaleFactor == 0 || (Math.signum(scaleFactor) == Math.signum(lastScaleFactor))) {
            scale *= scaleFactor;
            scale = Math.max(MIN_ZOOM, Math.min(scale, MAX_ZOOM));
            lastScaleFactor = scaleFactor;
        } else {
            lastScaleFactor = 0;
        }
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector scaleDetector) {
        //Log.i(TAG, "onScaleEnd");
        mode = Mode.NONE;
        Log.i(TAG, Float.toString(scale));
    }

    private void applyScaleAndTranslation() {
        child().setScaleX(scale);
        child().setScaleY(scale);
        child().setTranslationX(dx);
        child().setTranslationY(dy);
    }

    private View child() {
        return getChildAt(0);
    }


    //Gesture detector

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.i(TAG, "SingleTapConfirmed");
        return true;
    }

    private void esconderViews() {
        View raiz = ((View) this.getParent()).getRootView();
        RelativeLayout layout_info = (RelativeLayout) raiz.findViewById(R.id.layout_info);
        RelativeLayout layout_botoes = (RelativeLayout) raiz.findViewById(R.id.layout_botoes);
        layout_info.setVisibility(INVISIBLE);
        layout_botoes.setVisibility(INVISIBLE);
    }

    private void mostrarViews() {
        View raiz = ((View) this.getParent()).getRootView();
        RelativeLayout layout_info = (RelativeLayout) raiz.findViewById(R.id.layout_info);
        RelativeLayout layout_botoes = (RelativeLayout) raiz.findViewById(R.id.layout_botoes);
        layout_info.setVisibility(VISIBLE);
        layout_botoes.setVisibility(VISIBLE);
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        //Log.i(TAG, "DoubleTap");
        float oldScale = scale;
        if(scale < MAX_ZOOM -2){
            scale += 2;
        } else{
            scale = MIN_ZOOM;
        }
        applyScaleAndTranslation();
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        //Log.i(TAG, "DoubleTapEvent");

        return true;
    }



    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return true;
    }
}
