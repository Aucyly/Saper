package com.example.saper;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int WIDTH = 8;
    final int HEIGHT = 10;
    final int MINESCONST = 10;
    int MINESCURRENT = 10;

    int count_flazhok_mina=0;

    Button[][] yacheyki;
    TextView mines;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mines = findViewById(R.id.TV);
        mines.setText(""+MINESCURRENT+"/"+MINESCONST);
        generate();
    }

    public int r(int y, int x){
        return (int) (Math.random()*(x-y)+y);
    }

    public void generate(){
        GridLayout layout = findViewById(R.id.GRID);
        layout.removeAllViews();
        layout.setColumnCount(WIDTH);
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);

        yacheyki = new Button[HEIGHT][WIDTH];

        for(int i = 0; i < HEIGHT; i++){
            for(int j = 0; j < WIDTH; j++){
                yacheyki[i][j] = (Button) inflater.inflate(R.layout.yacheyki, layout, false);
                yacheyki[i][j].setText("");
            }
        }

        for(int i = 0; i < 10; i++) {
            int a;
            int b;
            do {
                a = r(0, HEIGHT);
                b = r(0, WIDTH);
            } while (yacheyki[a][b].getTag() == "*");
            //yacheyki[a][b].setText("*");
            yacheyki[a][b].setTag("*");
        }

        for(int fi = 0; fi < HEIGHT; fi++){
            for(int fj = 0; fj < WIDTH; fj++){

                int i = fi;
                int j = fj;


                if(yacheyki[i][j].getTag()!="*"){
                    int count_mines=0;

                    if(i==0 && j==0){
                        if(yacheyki[i+1][j].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i+1][j+1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i][j+1].getTag()=="*"){
                            count_mines++;
                        }


                    }else if(j==0 && i==HEIGHT-1){
                        if(yacheyki[i][j+1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i-1][j+1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i][j+1].getTag()=="*"){
                            count_mines++;
                        }


                    }else if(j==WIDTH-1 && i==HEIGHT-1){
                        if(yacheyki[i-1][j].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i][j-1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i-1][j-1].getTag()=="*"){
                            count_mines++;
                        }


                    }else if(i==0 && j==WIDTH-1){
                        if(yacheyki[i][j-1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i+1][j-1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i+1][j].getTag()=="*"){
                            count_mines++;
                        }


                    }else if(i==0){
                        if(yacheyki[i][j-1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i][j+1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i+1][j-1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i+1][j].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i+1][j+1].getTag()=="*"){
                            count_mines++;
                        }


                    }else if(j==0){
                        if(yacheyki[i-1][j].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i+1][j].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i-1][j+1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i][j+1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i+1][j+1].getTag()=="*"){
                            count_mines++;
                        }

                    } else if (i==HEIGHT-1) {
                        if(yacheyki[i][j-1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i][j+1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i-1][j-1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i-1][j].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i-1][j+1].getTag()=="*"){
                            count_mines++;
                        }

                    } else if (j==WIDTH-1) {
                        if(yacheyki[i-1][j].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i+1][j].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i-1][j-1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i][j-1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i+1][j-1].getTag()=="*"){
                            count_mines++;
                        }

                    } else{
                        if(yacheyki[i-1][j-1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i][j-1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i+1][j-1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i-1][j].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i+1][j].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i-1][j+1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i][j+1].getTag()=="*"){
                            count_mines++;
                        }
                        if(yacheyki[i+1][j+1].getTag()=="*"){
                            count_mines++;
                        }

                    }

                    if(count_mines==1){
                        yacheyki[i][j].setTag("1");
                    }
                    if(count_mines==2){
                        yacheyki[i][j].setTag("2");
                    }
                    if(count_mines==3){
                        yacheyki[i][j].setTag("3");
                    }
                    if(count_mines==4){
                        yacheyki[i][j].setTag("4");
                    }
                    if(count_mines==5){
                        yacheyki[i][j].setTag("5");
                    }
                    if(count_mines==0){
                        yacheyki[i][j].setTag("0");
                    }
                }


                yacheyki[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(yacheyki[i][j].getTag()=="*"){
                            view.setBackgroundColor(Color.RED);
                            Toast.makeText(getApplicationContext(),"GAME OVER",Toast.LENGTH_LONG).show();

                        }else {
                            if(yacheyki[i][j].getText()=="?"){
                                MINESCURRENT++;
                            }
                            yacheyki[i][j].setText(""+yacheyki[i][j].getTag());
                            if(yacheyki[i][j].getTag()==("5")){
                                yacheyki[i][j].setTextColor(Color.rgb(80,17,30));
                            }
                            if(yacheyki[i][j].getTag()==("4")){
                                yacheyki[i][j].setTextColor(Color.rgb(17,35,50));
                            }
                            if(yacheyki[i][j].getTag()==("3")){
                                yacheyki[i][j].setTextColor(Color.RED);
                            }
                            if(yacheyki[i][j].getTag()==("2")){
                                yacheyki[i][j].setTextColor(Color.rgb(255,152,0));
                            }
                            if(yacheyki[i][j].getTag()==("1")){
                                yacheyki[i][j].setTextColor(Color.rgb(4,159,10));
                            }
                            if(yacheyki[i][j].getTag()==("0")){
                                yacheyki[i][j].setTextColor(Color.rgb(100,100,100));
                            }
                        }
                    }
                });

                yacheyki[i][j].setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        if(yacheyki[i][j].getText()!="?"){
                            MINESCURRENT--;
                            mines.setText(""+MINESCURRENT+"/"+MINESCONST);
                            yacheyki[i][j].setText("?");
                            yacheyki[i][j].setTextColor(Color.rgb(33,150,243));
                            if(yacheyki[i][j].getTag()=="*"){
                                count_flazhok_mina++;
                            }
                            if(MINESCURRENT==0 && count_flazhok_mina==10){
                                Toast.makeText(getApplicationContext(),"WIN",Toast.LENGTH_LONG).show();
                            }
                        }else{
                            MINESCURRENT++;
                            if(yacheyki[i][j].getTag()=="*"){
                                count_flazhok_mina--;
                            }
                            mines.setText(""+MINESCURRENT+"/"+MINESCONST);
                            yacheyki[i][j].setText("");
                        }
                        return true;
                    }
                });

                layout.addView(yacheyki[i][j]);

            }
        }
    }
}