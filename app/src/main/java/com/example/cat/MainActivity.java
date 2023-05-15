package com.example.cat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private double x, z = 345;

    private Toast toast;

    private View.OnTouchListener listener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            System.out.println(event.getX() + " " + event.getY());

            if ((event.getX() > 345 - 50 && event.getX() > 345 + 50) &&
                    (event.getY() > 345 - 50 && event.getY() > 345 + 50)) {
               toast.show();

            }

            return true;
        }
    };

    private ConstraintLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = findViewById(R.id.myLayout);

        myLayout.setOnTouchListener(listener);

        toast = Toast.makeText(getApplicationContext(),
                "Вы нашли кота!!!", Toast.LENGTH_SHORT);
        LinearLayout toastContainer = (LinearLayout) toast.getView();
        ImageView catImage = new ImageView(getApplicationContext());
        catImage.setImageResource(R.drawable.cat);
        toastContainer.addView(catImage);
    }

}



