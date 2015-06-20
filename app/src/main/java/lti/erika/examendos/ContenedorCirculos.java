package lti.erika.examendos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

public class ContenedorCirculos extends View {


    private Paint mFill;
    private Paint mColorRed;
    private Paint mColorGreen;
    private Paint mColorBlue;

    private int blue = 255;
    private int green = 255;
    private int red = 255;

    private int x;
    private int y;
    private int radio = 500;

    float densidad;


    public ContenedorCirculos(Context context) {
        super(context);
        this.inicializar();
    }

    public ContenedorCirculos(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.inicializar();
    }

    public ContenedorCirculos(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.inicializar();
    }

    private void inicializar() {

        this.densidad = getResources().getDisplayMetrics().density;

        mFill = new Paint();
        mColorRed = new Paint();
        mColorGreen = new Paint();
        mColorBlue = new Paint();
    }
    public void setRed(int color){
        this.red = color;
        invalidate();
    }

    public void setGreen(int color){
        this.green = color;
        invalidate();
    }


    public void setBlue(int color){
        this.blue = color;
        invalidate();
    }



    @Override
    protected void onMeasure(int widthMeasureSpec,
                             int heightMeasureSpec) {
        int ancho = calcularAncho(widthMeasureSpec);
        int alto = calcularAlto(heightMeasureSpec);
        setMeasuredDimension(ancho, alto);
    }

    private int calcularAlto(int limitesSpec) {
        int res = 200; // Alto por defecto 100
        int modo = MeasureSpec.getMode(limitesSpec);
        int limite =MeasureSpec.getSize(limitesSpec);

        if (modo == MeasureSpec.AT_MOST) {
            res = limite;
        } else if (modo == MeasureSpec.EXACTLY) {
            res = limite;
        }

        return res;
    }

    private int calcularAncho(int limitesSpec) {
        int res = 300; // Ancho por defecto 200

        int modo = MeasureSpec.getMode(limitesSpec);
        int limite =MeasureSpec.getSize(limitesSpec);

        if (modo == MeasureSpec.AT_MOST) {
            res = limite;
        } else if (modo == MeasureSpec.EXACTLY) {
            res = limite;
        }

        return res;
    }

    @Override
    protected void onDraw(Canvas canvas) {


        float w = this.getWidth();
        float h = this.getHeight();
        float cx = w / 2;
        float cy = h / 2;
        float r = w / 15;
        float tx = (float) (r * Math.cos(30 * Math.PI / 180));
        float ty = (float) (r * Math.sin(30 * Math.PI / 180));
        float expand= densidad;

        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        mFill.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));


        mColorRed.setStyle(Paint.Style.FILL);
        mColorRed.setColor(Color.argb(red, 255, 0, 0));
        mColorRed.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
        canvas.drawCircle(cx, cy - r, expand * r, mColorRed);

        mColorGreen.setStyle(Paint.Style.FILL);
        mColorGreen.setColor(Color.argb(green, 0, 255, 0));
        mColorGreen.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
        canvas.drawCircle(cx - tx, cy + ty, expand * r, mColorGreen);

        mColorBlue.setStyle(Paint.Style.FILL);
        mColorBlue.setColor(Color.argb(blue, 0, 0, 255));
        mColorBlue.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
        canvas.drawCircle(cx + tx, cy + ty, expand * r, mColorBlue);


    }
}
