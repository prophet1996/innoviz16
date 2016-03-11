package innoviz.ieee.niec.com.innoviz16;

import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RealSplash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT=3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_real_splash);

        TextView t= (TextView)findViewById(R.id.textsplash);
        final Typeface font=Typeface.createFromAsset(this.getAssets(),"fonts/fonta.otf");




        new Handler().postDelayed(new Runnable() {

            public void run() {
                Intent i = new Intent(RealSplash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }



}


