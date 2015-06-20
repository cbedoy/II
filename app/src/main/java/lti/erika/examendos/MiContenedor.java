package lti.erika.examendos;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MiContenedor extends LinearLayout {


    private int a, b, c;

    public MiContenedor(Context context) {
        super(context);
        init();
    }

    public MiContenedor(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View view = ((LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.activity_main, null);

        SeekBar seekBar1 = (SeekBar) view.findViewById(R.id.seekBar1);
        SeekBar seekBar2 = (SeekBar) view.findViewById(R.id.seekBar2);
        SeekBar seekBar3 = (SeekBar) view.findViewById(R.id.seekBar3);
        final ContenedorCirculos circlesView = (ContenedorCirculos) view.findViewById(R.id.circulos);
        final View cuadro = view.findViewById(R.id.cuadrado);

        seekBar1.setMax(255);
        seekBar2.setMax(255);
        seekBar3.setMax(255);

        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(seekBar.getId() == R.id.seekBar1){
                    circlesView.setRed(progress);


                    a = progress;
                }else if(seekBar.getId() == R.id.seekBar2){
                    circlesView.setGreen(progress);

                    b = progress;
                }else if(seekBar.getId() == R.id.seekBar3){
                    circlesView.setBlue(progress);

                    c = progress;
                }
                cuadro.setBackgroundColor(Color.rgb(a, b, c));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        seekBar1.setOnSeekBarChangeListener(onSeekBarChangeListener);
        seekBar2.setOnSeekBarChangeListener(onSeekBarChangeListener);
        seekBar3.setOnSeekBarChangeListener(onSeekBarChangeListener);

        addView(view);

    }
}
