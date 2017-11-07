package shehan.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity {
/*initiating image viewers,buttons ,output image by cpu and palyer ,result*/

    Button b_rock,b_scissor,b_paper;
    ImageView iv_cpu,iv_me;
    String mychoice,cpuchocie,result;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
/*defining the buttons , image viewers of app and images*/
        iv_cpu= (ImageView) findViewById(R.id.iv_cpu);
        iv_me= (ImageView) findViewById(R.id.iv_me);

        b_rock=(Button) findViewById(R.id.rock);
        b_paper=(Button) findViewById(R.id.paper);
        b_scissor=(Button) findViewById(R.id.scissor);
        r=new Random();

        b_rock.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View V)
            {
                mychoice="rock";
                iv_me.setImageResource(R.drawable.rock);
                calculate();

            }
        });
        b_paper.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View V)
            {
                mychoice="paper";
                iv_me.setImageResource(R.drawable.paper);
                calculate();
            }
        });

        b_scissor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View V)
            {
                mychoice="scissor";
                iv_me.setImageResource(R.drawable.scissor);
                calculate();
            }
        });
    }
/* CPU automation image showing buy random*/
    public void calculate()
    {
    int cpu=r.nextInt(3);
        if(cpu==0)
        {
            cpuchocie="rock";
            iv_cpu.setImageResource(R.drawable.rock);

        }
        else if(cpu==1)
        {
            cpuchocie="paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }
        else if(cpu==2)
        {
            cpuchocie="scissor";
            iv_cpu.setImageResource(R.drawable.scissor);
        }
/*Way to find out the winner, losser ,and draw as the game */
        if(mychoice.equals("rock") && cpuchocie.equals("paper"))
        {
            result="You lose!!!!";
        }
        else if(mychoice.equals("scissor") && cpuchocie.equals("rock"))
        {
            result="You lose!!!!";
        }
        else if(mychoice.equals("paper") && cpuchocie.equals("scissor"))
        {
            result="You lose!!!!";
        }
        else if(mychoice.equals("paper") && cpuchocie.equals("rock"))
        {
            result="You win!!!!";
        }
        else if(mychoice.equals("scissor") && cpuchocie.equals("paper"))
        {
            result="You win!!!!";
        }
        else if(mychoice.equals("rock") && cpuchocie.equals("scissor"))
        {
            result="You win!!!!";
        }
        else if(mychoice.equals("paper") && cpuchocie.equals("paper"))
        {
            result="draw";
        }
        else if(mychoice.equals("scissor") && cpuchocie.equals("scissor"))
        {
            result="draw";
        }
        else if(mychoice.equals("rock") && cpuchocie.equals("rock"))
        {
            result="draw!!!!";
        }
        Toast.makeText(Game.this,result,Toast.LENGTH_SHORT).show();
    }



}
