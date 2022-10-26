package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static int count;
    ViewFlipper viewFlipper, viewFlipper2;
    Button next, previous, random;
    Random r;
    ImageView pic1, pic2, pic3, pic4;
    String desc1, desc2, desc3, desc4;
    TextView tv;
    private int[] images = {R.id.imageView1,R.id.imageView2,R.id.imageView3,R.id.imageView4};
    private int[] text = {R.id.imageView1_dsc, R.id.imageView2_dsc, R.id.imageView3_dsc, R.id.imageView4_dsc};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        desc1 = "1 of 4";
        desc2 = "2 of 4";
        desc3 = "3 of 4";
        desc4 = "4 of 4";

        pic1 = findViewById(R.id.imageView1);

        pic2 = findViewById(R.id.imageView2);
        pic3 = findViewById(R.id.imageView3);
        pic4 = findViewById(R.id.imageView4);

        viewFlipper = findViewById(R.id.viewFlipper);
        viewFlipper2 = findViewById(R.id.viewFlipper2);

        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        random = findViewById(R.id.random);

        r = new Random();

        next.setOnClickListener(this);
        previous.setOnClickListener(this);
        random.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        tv = findViewById(R.id.imageView1_dsc);
        if (v == next) {
            viewFlipper.showNext();
            viewFlipper2.showNext();
        } else if (v == previous) {
            viewFlipper.showPrevious();
            viewFlipper2.showPrevious();
        } else {
           int randImgPos = r.nextInt(images.length);
           while (randImgPos == viewFlipper.getDisplayedChild()) {
               randImgPos = r.nextInt(images.length);
           }
           viewFlipper.setDisplayedChild(randImgPos);
           viewFlipper2.setDisplayedChild(randImgPos);

//           int randTxtPos = r.nextInt(text.length);
//           while(randTxtPos == viewFlipper2.getDisplayedChild()){
//               randTxtPos = r.nextInt(text.length);
//           }
//           viewFlipper2.setDisplayedChild(randTxtPos);

           }
//            int[] picture = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4};
//            Random r = new Random();
//            int n = r.nextInt(4);
//            random.setId(picture[n]);
//            findViewById(n).setVisibility(View.VISIBLE);
        }
}

