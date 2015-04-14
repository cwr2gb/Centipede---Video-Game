   import acm.graphics.*;
   import acm.program.*;
   import acm.util.*;
   import javax.swing.*;
   import java.applet.*;
   import java.awt.*;
   import java.awt.event.*;
   
    public class RetroCentipede extends GraphicsProgram 
   {
   
   //Program Extras
   /****************************************************/
   //Ints for keeping track of the score and nuimber of mushrooms
      private int levelCount = 1;
      private int scoreCount = 0;
      private int currentCount = 0;
      private int centicount = 0;
   //background image
   //labels for score and number of mushrooms remaining
      private GLabel levelCounter, end, bonus;	
      private GLabel scoreCounter, mushroomCounter, currentCounter, centiCounter;	
      private GRect Background;
      private GOval CentipedeH,CentipedeB,CentipedeB2,CentipedeB3,CentipedeB4,
      CentipedeB5,CentipedeB6,CentipedeB7,CentipedeB8,CentipedeB9,
      CentipedeB10,CentipedeBt,CentiEye1, CentiEye2;
      private static final int centiradi = 12; 
      private static final int WIDTH = 600; 
      private static final int HEIGHT = 800; 
      private static final int PADDLE_WIDTH = 60; 
      private static final int PADDLE_HEIGHT = 10; 
      private static final int PADDLE_Y_OFFSET = 30; 
      private static final int MUSHROOM_SEP = 2; 
      private static final int MUSHROOM_WIDTH = 10;
      private static final int MUSHROOM_HEIGHT = 10;
      private static final int MUSHROOM2_SEP = 6; 
      private static final int MUSHROOM2_WIDTH = 6;
      private static final int MUSHROOM2_HEIGHT = 6;
      private static final int MUSHROOM_Y_OFFSET = 70; 
      private static final int MUSHROOM2_Y_OFFSET = 72; 
      private GImage ship = new GImage("ship.jpg");
      private int mushroomCount; 
      private GOval ball, ball2, ball3;
      private GRect mushroom, mushroom2;
      private double vx, vy, vxh, vyh, vx2, vy2, vx3, vy3, vx4, vy4, vx5, vy5, vx6, vy6,
      vx7, vy7, vx8, vy8, vx9, vy9, vx10, vy10, vx11, vy11, vx12, vy12, vxe1, vye1, vxe2, vye2;
      private double lastX;
      private int toggle = 0;
      
       public static void main(String[] args)
      {
         /*String song = JOptionPane.showInputDialog("Enter your Type of Music (Exactly how it appears):\n(Limited to: Rap, Rock, Pop, and None)");
         String songnum = JOptionPane.showInputDialog("Enter your Song Number:\n(Rap:1-5)   (Pop:1-2)   (Rock:1-3)   (None:0)");
         if(song.compareTo("None")==0)
         {
         }
         if(song.compareTo("Pop")==0 && songnum.compareTo("1")==0)
         {
            Song1 s1 = new Song1();
            s1.playsong();
         }
         else if(song.compareTo("Pop")==0 && songnum.compareTo("2")==0)
         {
            Song7 s7 = new Song7();
            s7.playsong();
         }
         if(song.compareTo("Rap")==0 && songnum.compareTo("1")==0)
         {
            Song2 s2 = new Song2();
            s2.playsong();
         }
         else if(song.compareTo("Rap")==0 && songnum.compareTo("2")==0)
         {
            Song3 s3 = new Song3();
            s3.playsong();
         }
         else if(song.compareTo("Rap")==0 && songnum.compareTo("3")==0)
         {
            Song4 s4 = new Song4();
            s4.playsong();
         }
         else if(song.compareTo("Rap")==0 && songnum.compareTo("4")==0)
         {
            Song5 s5 = new Song5();
            s5.playsong();
         }
         else if(song.compareTo("Rap")==0 && songnum.compareTo("5")==0)
         {
            Song8 s8 = new Song8();
            s8.playsong();
         }
         if(song.compareTo("Rock")==0 && songnum.compareTo("1")==0)
         {
            Song6 s6 = new Song6();
            s6.playsong();
         }
         else if(song.compareTo("Rock")==0 && songnum.compareTo("2")==0)
         {
            Song9 s9 = new Song9();
            s9.playsong();
         }
         else if(song.compareTo("Rock")==0 && songnum.compareTo("3")==0)
         {
            Song10 s10 = new Song10();
            s10.playsong();
         }*/
         String[] sizeArgs = { "width=" + WIDTH, "height=" + HEIGHT };
         new RetroCentipede().start(sizeArgs);
      }
      
       public void run()
      {
         setup();
         play();
      }
      
       public void setup()
      {
         Back();
         createCentipede();
         createMushrooms();
         createPaddle();
         createBall();
         createBall2();
         createBall3();
         addMouseListeners();
         counterSetup();
      }
      
       public void Back()
      {
         Background = new GRect(0,0,600,800);
         Background.setFilled(true);
         Background.setColor(Color.BLACK);
         add(Background);
      }
   
       public void counterSetup()
      {
         levelCounter = new GLabel("Level " + levelCount, 270, 16);
         levelCounter.setFont(new Font("OCR A Extended", Font.BOLD, 16));
         if(levelCount==1)
            levelCounter.setColor(Color.RED);
         if(levelCount==2)
            levelCounter.setColor(new Color(30,144,255));
         if(levelCount==3)
            levelCounter.setColor(Color.YELLOW);
         if(levelCount==4)
            levelCounter.setColor(Color.BLUE);
         if(levelCount==5)
            levelCounter.setColor(new Color(238,17,238));
         if(levelCount==6)
            levelCounter.setColor(new Color(221,170,017));
         if(levelCount==7)
            levelCounter.setColor(new Color(204,0,238));
         if(levelCount==8)
            levelCounter.setColor(Color.RED);
         if(levelCount==9)
            levelCounter.setColor(new Color(0,255,255));
         if(levelCount==10)
            levelCounter.setColor(new Color(238,204,051));
         if(levelCount==11)
            levelCounter.setColor(Color.RED);
         if(levelCount==12)
            levelCounter.setColor(new Color(204,0,238));
         if(levelCount==13)
            levelCounter.setColor(Color.BLUE);
         if(levelCount==14)
            levelCounter.setColor(new Color(255,68,170));
         if(levelCount==15)
            levelCounter.setColor(Color.WHITE);
         add(levelCounter);
      		
         scoreCounter = new GLabel("" + scoreCount, 150, 16);
         scoreCounter.setFont(new Font("OCR A Extended", Font.BOLD, 16));
         if(levelCount==1)
            scoreCounter.setColor(Color.RED);
         if(levelCount==2)
            scoreCounter.setColor(new Color(30,144,255));
         if(levelCount==3)
            scoreCounter.setColor(Color.YELLOW);
         if(levelCount==4)
            scoreCounter.setColor(Color.BLUE);
         if(levelCount==5)
            scoreCounter.setColor(new Color(238,17,238));
         if(levelCount==6)
            scoreCounter.setColor(new Color(221,170,017));
         if(levelCount==7)
            scoreCounter.setColor(new Color(204,0,238));
         if(levelCount==8)
            scoreCounter.setColor(Color.RED);
         if(levelCount==9)
            scoreCounter.setColor(new Color(0,255,255));
         if(levelCount==10)
            scoreCounter.setColor(new Color(238,204,051));
         if(levelCount==11)
            scoreCounter.setColor(Color.RED);
         if(levelCount==12)
            scoreCounter.setColor(new Color(204,0,238));
         if(levelCount==13)
            scoreCounter.setColor(Color.BLUE);
         if(levelCount==14)
            scoreCounter.setColor(new Color(255,68,170));
         if(levelCount==15)
            scoreCounter.setColor(Color.WHITE);
         add(scoreCounter);
         
         currentCounter = new GLabel("" + currentCount, 75, 16);
         currentCounter.setFont(new Font("OCR A Extended", Font.BOLD, 16));
         if(levelCount==1)
            currentCounter.setColor(Color.RED);
         if(levelCount==2)
            currentCounter.setColor(new Color(30,144,255));
         if(levelCount==3)
            currentCounter.setColor(Color.YELLOW);
         if(levelCount==4)
            currentCounter.setColor(Color.BLUE);
         if(levelCount==5)
            currentCounter.setColor(new Color(238,17,238));
         if(levelCount==6)
            currentCounter.setColor(new Color(221,170,017));
         if(levelCount==7)
            currentCounter.setColor(new Color(204,0,238));
         if(levelCount==8)
            currentCounter.setColor(Color.RED);
         if(levelCount==9)
            currentCounter.setColor(new Color(0,255,255));
         if(levelCount==10)
            currentCounter.setColor(new Color(238,204,051));
         if(levelCount==11)
            currentCounter.setColor(Color.RED);
         if(levelCount==12)
            currentCounter.setColor(new Color(204,0,238));
         if(levelCount==13)
            currentCounter.setColor(Color.BLUE);
         if(levelCount==14)
            currentCounter.setColor(new Color(255,68,170));;
         if(levelCount==15)
            currentCounter.setColor(Color.WHITE);
         add(currentCounter);
         
         if(levelCount==15)
         {
            centiCounter = new GLabel("Segs Killed: " + centicount, 435, 16);
            centiCounter.setFont(new Font("OCR A Extended", Font.BOLD, 16));
            centiCounter.setColor(Color.WHITE);
            add(centiCounter);
         }
         if(levelCount==15)
         {
            bonus = new GLabel("Think you're good. Try this!", 50, 400);
            bonus.setFont(new Font("ZBPrintArrow", Font.BOLD, 40));
            bonus.setColor(Color.RED);
            add(bonus);
         }
      }
   /********************************************************************
    *******************************************************************/
    
    
   
   //createBricks method -- called from the setup method
       public void createMushrooms()
      {
      //make the mushrooms
         for(int x = 0; x < 55; x++)
         {	
            for(int y = 1; y < 49; y++)
            {
               double m = Math.random();
               if(m<.06)
               {
                  mushroom = new GRect((y * MUSHROOM_WIDTH) + MUSHROOM_SEP*y + MUSHROOM_SEP/2, 
                     				MUSHROOM_Y_OFFSET + (MUSHROOM_HEIGHT * x) + MUSHROOM_SEP*x, 
                     					MUSHROOM_WIDTH, 
                     					MUSHROOM_HEIGHT);
                  mushroom.setFilled(true);
                  if(levelCount==1)
                     mushroom.setColor(Color.RED);
                  else if (levelCount==2)
                     mushroom.setColor(new Color(30,144,255));
                  else if (levelCount==3)
                     mushroom.setColor(Color.YELLOW);
                  else if (levelCount==4)
                     mushroom.setColor(Color.BLUE);
                  else if (levelCount==5)
                     mushroom.setColor(new Color(238,17,238));
                  else if (levelCount==6)
                     mushroom.setColor(new Color(221,170,017));
                  else if (levelCount==7)
                     mushroom.setColor(new Color(204,0,238));
                  else if (levelCount==8)
                     mushroom.setColor(Color.RED);
                  else if (levelCount==9)
                     mushroom.setColor(new Color(0,255,255));
                  else if (levelCount==10)
                     mushroom.setColor(new Color(238,204,051));
                  else if (levelCount==11)
                     mushroom.setColor(Color.RED);
                  else if (levelCount==12)
                     mushroom.setColor(new Color(204,0,238));
                  else if (levelCount==13)
                     mushroom.setColor(Color.BLUE);
                  else if (levelCount==14)
                     mushroom.setColor(new Color(255,68,170));
                  else if (levelCount==15)
                     mushroom.setColor(Color.WHITE);
                  add(mushroom);
                  
                  mushroom2 = new GRect((y * MUSHROOM2_WIDTH) + MUSHROOM2_SEP*y + MUSHROOM2_SEP/2, 
                     				MUSHROOM2_Y_OFFSET + (MUSHROOM2_HEIGHT * x) + MUSHROOM2_SEP*x, 
                     					MUSHROOM2_WIDTH, 
                     					MUSHROOM2_HEIGHT);
                     					
                  mushroom2.setFilled(true);
                  if(levelCount==1)
                     mushroom2.setColor(Color.GREEN);
                  else if (levelCount==2)
                     mushroom2.setColor(new Color(160,32,240));
                  else if (levelCount==3)
                     mushroom2.setColor(Color.RED);
                  else if (levelCount==4)
                     mushroom2.setColor(new Color(255,215,0));
                  else if (levelCount==5)
                     mushroom2.setColor(new Color(0,255,255));
                  else if (levelCount==6)
                     mushroom2.setColor(new Color(64,224,208));
                  else if (levelCount==7)
                     mushroom2.setColor(Color.YELLOW);
                  else if (levelCount==8)
                     mushroom2.setColor(new Color(64,224,208));
                  else if (levelCount==9)
                     mushroom2.setColor(new Color(238,034,187));
                  else if (levelCount==10)
                     mushroom2.setColor(Color.BLUE);
                  else if (levelCount==11)
                     mushroom2.setColor(new Color(0,255,255));
                  else if (levelCount==12)
                     mushroom2.setColor(Color.GREEN);
                  else if (levelCount==13)
                     mushroom2.setColor(new Color(238,034,187));
                  else if (levelCount==14)
                     mushroom2.setColor(new Color(255,221,204));
                  add(mushroom2);
               }
            }
         }
      }
      
   	//Create Centipede
       public void createCentipede()
      {
      //Speeds
         if(levelCount==1)
         {
            vxh=1;
            vx2=1;
            vx3=1;
            vx4=1;
            vx5=1;
            vx6=1;
            vx7=1;
            vx8=1;
            vx9=1;
            vx10=1;
            vx11=1;
            vx12=1;
            vxe1=1;
            vxe2=1;
         }
         else if(levelCount==2)
         {
            vxh=1;
            vx2=1;
            vx3=1;
            vx4=1;
            vx5=1;
            vx6=1;
            vx7=1;
            vx8=1;
            vx9=1;
            vx10=1;
            vx11=1;
            vx12=1;
            vxe1=1;
            vxe2=1;
         }
         else if(levelCount==3||levelCount==15)
         {
            vxh=1;
            vx2=1;
            vx3=1;
            vx4=1;
            vx5=1;
            vx6=1;
            vx7=1;
            vx8=1;
            vx9=1;
            vx10=1;
            vx11=1;
            vx12=1;
            vxe1=1;
            vxe2=1;
         }
         else if(levelCount==4)
         {
            vxh=1;
            vx2=1;
            vx3=1;
            vx4=1;
            vx5=1;
            vx6=1;
            vx7=1;
            vx8=1;
            vx9=1;
            vx10=1;
            vx11=1;
            vx12=1;
            vxe1=1;
            vxe2=1;
         }
         else if(levelCount==5)
         {
            vxh=2;
            vx2=2;
            vx3=2;
            vx4=2;
            vx5=2;
            vx6=2;
            vx7=2;
            vx8=2;
            vx9=2;
            vx10=2;
            vx11=2;
            vx12=2;
            vxe1=2;
            vxe2=2;
         }
         else if(levelCount==6)
         {
            vxh=2;
            vx2=2;
            vx3=2;
            vx4=2;
            vx5=2;
            vx6=2;
            vx7=2;
            vx8=2;
            vx9=2;
            vx10=2;
            vx11=2;
            vx12=2;
            vxe1=2;
            vxe2=2;
         }
         else if(levelCount==7)
         {
            vxh=2;
            vx2=2;
            vx3=2;
            vx4=2;
            vx5=2;
            vx6=2;
            vx7=2;
            vx8=2;
            vx9=2;
            vx10=2;
            vx11=2;
            vx12=2;
            vxe1=2;
            vxe2=2;
         }
         else if(levelCount==8)
         {
            vxh=2;
            vx2=2;
            vx3=2;
            vx4=2;
            vx5=2;
            vx6=2;
            vx7=2;
            vx8=2;
            vx9=2;
            vx10=2;
            vx11=2;
            vx12=2;
            vxe1=2;
            vxe2=2;
         }
         else if(levelCount==9)
         {
            vxh=3;
            vx2=3;
            vx3=3;
            vx4=3;
            vx5=3;
            vx6=3;
            vx7=3;
            vx8=3;
            vx9=3;
            vx10=3;
            vx11=3;
            vx12=3;
            vxe1=3;
            vxe2=3;
         }
         else if(levelCount==10)
         {
            vxh=3;
            vx2=3;
            vx3=3;
            vx4=3;
            vx5=3;
            vx6=3;
            vx7=3;
            vx8=3;
            vx9=3;
            vx10=3;
            vx11=3;
            vx12=3;
            vxe1=3;
            vxe2=3;
         }
         else if(levelCount==11)
         {
            vxh=3;
            vx2=3;
            vx3=3;
            vx4=3;
            vx5=3;
            vx6=3;
            vx7=3;
            vx8=3;
            vx9=3;
            vx10=3;
            vx11=3;
            vx12=3;
            vxe1=3;
            vxe2=3;
         }
         else if(levelCount==12)
         {
            vxh=3;
            vx2=3;
            vx3=3;
            vx4=3;
            vx5=3;
            vx6=3;
            vx7=3;
            vx8=3;
            vx9=3;
            vx10=3;
            vx11=3;
            vx12=3;
            vxe1=3;
            vxe2=3;
         }
         else if(levelCount==13)
         {
            vxh=4;
            vx2=4;
            vx3=4;
            vx4=4;
            vx5=4;
            vx6=4;
            vx7=4;
            vx8=4;
            vx9=4;
            vx10=4;
            vx11=4;
            vx12=4;
            vxe1=4;
            vxe2=4;
         }
         else if(levelCount==14)
         {
            vxh=4;
            vx2=4;
            vx3=4;
            vx4=4;
            vx5=4;
            vx6=4;
            vx7=4;
            vx8=4;
            vx9=4;
            vx10=4;
            vx11=4;
            vx12=4;
            vxe1=4;
            vxe2=4;
         }
      	//Head
         CentipedeH = new GOval(132,50,centiradi,centiradi);
         CentipedeH.setFilled(true);
         if(levelCount==1)
            CentipedeH.setColor(Color.GREEN);
         else if (levelCount==2)
            CentipedeH.setColor(new Color(160,32,240));
         else if (levelCount==3)
            CentipedeH.setColor(Color.RED);
         else if (levelCount==4)
            CentipedeH.setColor(new Color(255,215,0));
         else if (levelCount==5)
            CentipedeH.setColor(new Color(0,255,255));
         else if (levelCount==6)
            CentipedeH.setColor(new Color(64,224,208));
         else if (levelCount==7)
            CentipedeH.setColor(Color.YELLOW);
         else if (levelCount==8)
            CentipedeH.setColor(new Color(64,224,208));
         else if (levelCount==9)
            CentipedeH.setColor(new Color(238,034,187));
         else if (levelCount==10)
            CentipedeH.setColor(Color.BLUE);
         else if (levelCount==11)
            CentipedeH.setColor(new Color(0,255,255));
         else if (levelCount==12)
            CentipedeH.setColor(Color.GREEN);
         else if (levelCount==13)
            CentipedeH.setColor(Color.RED);
         else if (levelCount==14)
            CentipedeH.setColor(new Color(255,221,204));
         else if (levelCount==15)
            CentipedeH.setColor(Color.BLACK);
         add(CentipedeH);
         
         //Eyes
         CentiEye1 = new GOval(132+(7),58,5,5);
         CentiEye1.setFilled(true);
         if(levelCount==1)
            CentiEye1.setColor(Color.RED);
         else if (levelCount==2)
            CentiEye1.setColor(new Color(30,144,255));
         else if (levelCount==3)
            CentiEye1.setColor(Color.YELLOW);
         else if (levelCount==4)
            CentiEye1.setColor(Color.BLUE);
         else if (levelCount==5)
            CentiEye1.setColor(new Color(238,17,238));
         else if (levelCount==6)
            CentiEye1.setColor(new Color(221,170,017));
         else if (levelCount==7)
            CentiEye1.setColor(new Color(204,0,238));
         else if (levelCount==8)
            CentiEye1.setColor(Color.RED);
         else if (levelCount==9)
            CentiEye1.setColor(new Color(64,224,208));
         else if (levelCount==10)
            CentiEye1.setColor(new Color(238,204,051));
         else if (levelCount==11)
            CentiEye1.setColor(Color.RED);
         else if (levelCount==12)
            CentiEye1.setColor(new Color(204,0,238));
         else if (levelCount==13)
            CentiEye1.setColor(Color.BLUE);
         else if (levelCount==14)
            CentiEye1.setColor(new Color(255,68,170));
         else if (levelCount==15)
            CentiEye1.setColor(Color.BLACK);
         add(CentiEye1);
         
         CentiEye2 = new GOval(132+(7),50,5,5);
         CentiEye2.setFilled(true);
         if(levelCount==1)
            CentiEye2.setColor(Color.RED);
         else if (levelCount==2)
            CentiEye2.setColor(new Color(30,144,255));
         else if (levelCount==3)
            CentiEye2.setColor(Color.YELLOW);
         else if (levelCount==4)
            CentiEye2.setColor(Color.BLUE);
         else if (levelCount==5)
            CentiEye2.setColor(new Color(238,17,238));
         else if (levelCount==6)
            CentiEye2.setColor(new Color(221,170,017));
         else if (levelCount==7)
            CentiEye2.setColor(new Color(204,0,238));
         else if (levelCount==8)
            CentiEye2.setColor(Color.RED);
         else if (levelCount==9)
            CentiEye2.setColor(new Color(64,224,208));
         else if (levelCount==10)
            CentiEye2.setColor(new Color(238,204,051));
         else if (levelCount==11)
            CentiEye2.setColor(Color.RED);
         else if (levelCount==12)
            CentiEye2.setColor(new Color(204,0,238));
         else if (levelCount==13)
            CentiEye2.setColor(Color.BLUE);
         else if (levelCount==14)
            CentiEye2.setColor(new Color(255,68,170));
         else if (levelCount==15)
            CentiEye2.setColor(Color.BLACK);
         add(CentiEye2);
         
      	//Segments
         CentipedeB = new GOval(132-(12),50,centiradi,centiradi);
         CentipedeB.setFilled(true);
         if(levelCount==1)
            CentipedeB.setColor(Color.GREEN);
         else if (levelCount==2)
            CentipedeB.setColor(new Color(160,32,240));
         else if (levelCount==3)
            CentipedeB.setColor(Color.RED);
         else if (levelCount==4)
            CentipedeB.setColor(new Color(255,215,0));
         else if (levelCount==5)
            CentipedeB.setColor(new Color(0,255,255));
         else if (levelCount==6)
            CentipedeB.setColor(new Color(64,224,208));
         else if (levelCount==7)
            CentipedeB.setColor(Color.YELLOW);
         else if (levelCount==8)
            CentipedeB.setColor(new Color(64,224,208));
         else if (levelCount==9)
            CentipedeB.setColor(new Color(238,034,187));
         else if (levelCount==10)
            CentipedeB.setColor(Color.BLUE);
         else if (levelCount==11)
            CentipedeB.setColor(new Color(0,255,255));
         else if (levelCount==12)
            CentipedeB.setColor(Color.GREEN);
         else if (levelCount==13)
            CentipedeB.setColor(Color.RED);
         else if (levelCount==14)
            CentipedeB.setColor(new Color(255,221,204));
         else if (levelCount==15)
            CentipedeB.setColor(Color.BLACK);
         add(CentipedeB);
      	
         CentipedeB2 = new GOval(132-(24),50,centiradi,centiradi);
         CentipedeB2.setFilled(true);
         if(levelCount==1)
            CentipedeB2.setColor(Color.GREEN);
         else if (levelCount==2)
            CentipedeB2.setColor(new Color(160,32,240));
         else if (levelCount==3)
            CentipedeB2.setColor(Color.RED);
         else if (levelCount==4)
            CentipedeB2.setColor(new Color(255,215,0));
         else if (levelCount==5)
            CentipedeB2.setColor(new Color(0,255,255));
         else if (levelCount==6)
            CentipedeB2.setColor(new Color(64,224,208));
         else if (levelCount==7)
            CentipedeB2.setColor(Color.YELLOW);
         else if (levelCount==8)
            CentipedeB2.setColor(new Color(64,224,208));
         else if (levelCount==9)
            CentipedeB2.setColor(new Color(238,034,187));
         else if (levelCount==10)
            CentipedeB2.setColor(Color.BLUE);
         else if (levelCount==11)
            CentipedeB2.setColor(new Color(0,255,255));
         else if (levelCount==12)
            CentipedeB2.setColor(Color.GREEN);
         else if (levelCount==13)
            CentipedeB2.setColor(Color.RED);
         else if (levelCount==14)
            CentipedeB2.setColor(new Color(255,221,204));
         else if (levelCount==15)
            CentipedeB2.setColor(Color.BLACK);
         add(CentipedeB2);
      	
         CentipedeB3 = new GOval(132-(36),50,centiradi,centiradi);
         CentipedeB3.setFilled(true);
         if(levelCount==1)
            CentipedeB3.setColor(Color.GREEN);
         else if (levelCount==2)
            CentipedeB3.setColor(new Color(160,32,240));
         else if (levelCount==3)
            CentipedeB3.setColor(Color.RED);
         else if (levelCount==4)
            CentipedeB3.setColor(new Color(255,215,0));
         else if (levelCount==5)
            CentipedeB3.setColor(new Color(0,255,255));
         else if (levelCount==6)
            CentipedeB3.setColor(new Color(64,224,208));
         else if (levelCount==7)
            CentipedeB3.setColor(Color.YELLOW);
         else if (levelCount==8)
            CentipedeB3.setColor(new Color(64,224,208));
         else if (levelCount==9)
            CentipedeB3.setColor(new Color(238,034,187));
         else if (levelCount==10)
            CentipedeB3.setColor(Color.BLUE);
         else if (levelCount==11)
            CentipedeB3.setColor(new Color(0,255,255));
         else if (levelCount==12)
            CentipedeB3.setColor(Color.GREEN);
         else if (levelCount==13)
            CentipedeB3.setColor(Color.RED);
         else if (levelCount==14)
            CentipedeB3.setColor(new Color(255,221,204));
         else if (levelCount==15)
            CentipedeB3.setColor(Color.BLACK);
         add(CentipedeB3);
      	
         CentipedeB4 = new GOval(132-(48),50,centiradi,centiradi);
         CentipedeB4.setFilled(true);
         if(levelCount==1)
            CentipedeB4.setColor(Color.GREEN);
         else if (levelCount==2)
            CentipedeB4.setColor(new Color(160,32,240));
         else if (levelCount==3)
            CentipedeB4.setColor(Color.RED);
         else if (levelCount==4)
            CentipedeB4.setColor(new Color(255,215,0));
         else if (levelCount==5)
            CentipedeB4.setColor(new Color(0,255,255));
         else if (levelCount==6)
            CentipedeB4.setColor(new Color(64,224,208));
         else if (levelCount==7)
            CentipedeB4.setColor(Color.YELLOW);
         else if (levelCount==8)
            CentipedeB4.setColor(new Color(64,224,208));
         else if (levelCount==9)
            CentipedeB4.setColor(new Color(238,034,187));
         else if (levelCount==10)
            CentipedeB4.setColor(Color.BLUE);
         else if (levelCount==11)
            CentipedeB4.setColor(new Color(0,255,255));
         else if (levelCount==12)
            CentipedeB4.setColor(Color.GREEN);
         else if (levelCount==13)
            CentipedeB4.setColor(Color.RED);
         else if (levelCount==14)
            CentipedeB4.setColor(new Color(255,221,204));
         else if (levelCount==15)
            CentipedeB4.setColor(Color.BLACK);
         add(CentipedeB4);
      	
         CentipedeB5 = new GOval(132-(60),50,centiradi,centiradi);
         CentipedeB5.setFilled(true);
         if(levelCount==1)
            CentipedeB5.setColor(Color.GREEN);
         else if (levelCount==2)
            CentipedeB5.setColor(new Color(160,32,240));
         else if (levelCount==3)
            CentipedeB5.setColor(Color.RED);
         else if (levelCount==4)
            CentipedeB5.setColor(new Color(255,215,0));
         else if (levelCount==5)
            CentipedeB5.setColor(new Color(0,255,255));
         else if (levelCount==6)
            CentipedeB5.setColor(new Color(64,224,208));
         else if (levelCount==7)
            CentipedeB5.setColor(Color.YELLOW);
         else if (levelCount==8)
            CentipedeB5.setColor(new Color(64,224,208));
         else if (levelCount==9)
            CentipedeB5.setColor(new Color(238,034,187));
         else if (levelCount==10)
            CentipedeB5.setColor(Color.BLUE);
         else if (levelCount==11)
            CentipedeB5.setColor(new Color(0,255,255));
         else if (levelCount==12)
            CentipedeB5.setColor(Color.GREEN);
         else if (levelCount==13)
            CentipedeB5.setColor(Color.RED);
         else if (levelCount==14)
            CentipedeB5.setColor(new Color(255,221,204));
         else if (levelCount==15)
            CentipedeB5.setColor(Color.BLACK);
         add(CentipedeB5);
         
         CentipedeB6 = new GOval(132-(72),50,centiradi,centiradi);
         CentipedeB6.setFilled(true);
         if(levelCount==1)
            CentipedeB6.setColor(Color.GREEN);
         else if (levelCount==2)
            CentipedeB6.setColor(new Color(160,32,240));
         else if (levelCount==3)
            CentipedeB6.setColor(Color.RED);
         else if (levelCount==4)
            CentipedeB6.setColor(new Color(255,215,0));
         else if (levelCount==5)
            CentipedeB6.setColor(new Color(0,255,255));
         else if (levelCount==6)
            CentipedeB6.setColor(new Color(64,224,208));
         else if (levelCount==7)
            CentipedeB6.setColor(Color.YELLOW);
         else if (levelCount==8)
            CentipedeB6.setColor(new Color(64,224,208));
         else if (levelCount==9)
            CentipedeB6.setColor(new Color(238,034,187));
         else if (levelCount==10)
            CentipedeB6.setColor(Color.BLUE);
         else if (levelCount==11)
            CentipedeB6.setColor(new Color(0,255,255));
         else if (levelCount==12)
            CentipedeB6.setColor(Color.GREEN);
         else if (levelCount==13)
            CentipedeB6.setColor(Color.RED);
         else if (levelCount==14)
            CentipedeB6.setColor(new Color(255,221,204));
         else if (levelCount==15)
            CentipedeB6.setColor(Color.BLACK);
         add(CentipedeB6);
      	
         CentipedeB7 = new GOval(132-(84),50,centiradi,centiradi);
         CentipedeB7.setFilled(true);
         if(levelCount==1)
            CentipedeB7.setColor(Color.GREEN);
         else if (levelCount==2)
            CentipedeB7.setColor(new Color(160,32,240));
         else if (levelCount==3)
            CentipedeB7.setColor(Color.RED);
         else if (levelCount==4)
            CentipedeB7.setColor(new Color(255,215,0));
         else if (levelCount==5)
            CentipedeB7.setColor(new Color(0,255,255));
         else if (levelCount==6)
            CentipedeB7.setColor(new Color(64,224,208));
         else if (levelCount==7)
            CentipedeB7.setColor(Color.YELLOW);
         else if (levelCount==8)
            CentipedeB7.setColor(new Color(64,224,208));
         else if (levelCount==9)
            CentipedeB7.setColor(new Color(238,034,187));
         else if (levelCount==10)
            CentipedeB7.setColor(Color.BLUE);
         else if (levelCount==11)
            CentipedeB7.setColor(new Color(0,255,255));
         else if (levelCount==12)
            CentipedeB7.setColor(Color.GREEN);
         else if (levelCount==13)
            CentipedeB7.setColor(Color.RED);
         else if (levelCount==14)
            CentipedeB7.setColor(new Color(255,221,204));
         else if (levelCount==15)
            CentipedeB7.setColor(Color.BLACK);
         add(CentipedeB7);
      	
         CentipedeB8 = new GOval(132-(96),50,centiradi,centiradi);
         CentipedeB8.setFilled(true);
         if(levelCount==1)
            CentipedeB8.setColor(Color.GREEN);
         else if (levelCount==2)
            CentipedeB8.setColor(new Color(160,32,240));
         else if (levelCount==3)
            CentipedeB8.setColor(Color.RED);
         else if (levelCount==4)
            CentipedeB8.setColor(new Color(255,215,0));
         else if (levelCount==5)
            CentipedeB8.setColor(new Color(0,255,255));
         else if (levelCount==6)
            CentipedeB8.setColor(new Color(64,224,208));
         else if (levelCount==7)
            CentipedeB8.setColor(Color.YELLOW);
         else if (levelCount==8)
            CentipedeB8.setColor(new Color(64,224,208));
         else if (levelCount==9)
            CentipedeB8.setColor(new Color(238,034,187));
         else if (levelCount==10)
            CentipedeB8.setColor(Color.BLUE);
         else if (levelCount==11)
            CentipedeB8.setColor(new Color(0,255,255));
         else if (levelCount==12)
            CentipedeB8.setColor(Color.GREEN);
         else if (levelCount==13)
            CentipedeB8.setColor(Color.RED);
         else if (levelCount==14)
            CentipedeB8.setColor(new Color(255,221,204));
         else if (levelCount==15)
            CentipedeB8.setColor(Color.BLACK);
         add(CentipedeB8);
      	
         CentipedeB9 = new GOval(132-(108),50,centiradi,centiradi);
         CentipedeB9.setFilled(true);
         if(levelCount==1)
            CentipedeB9.setColor(Color.GREEN);
         else if (levelCount==2)
            CentipedeB9.setColor(new Color(160,32,240));
         else if (levelCount==3)
            CentipedeB9.setColor(Color.RED);
         else if (levelCount==4)
            CentipedeB9.setColor(new Color(255,215,0));
         else if (levelCount==5)
            CentipedeB9.setColor(new Color(0,255,255));
         else if (levelCount==6)
            CentipedeB9.setColor(new Color(64,224,208));
         else if (levelCount==7)
            CentipedeB9.setColor(Color.YELLOW);
         else if (levelCount==8)
            CentipedeB9.setColor(new Color(64,224,208));
         else if (levelCount==9)
            CentipedeB9.setColor(new Color(238,034,187));
         else if (levelCount==10)
            CentipedeB9.setColor(Color.BLUE);
         else if (levelCount==11)
            CentipedeB9.setColor(new Color(0,255,255));
         else if (levelCount==12)
            CentipedeB9.setColor(Color.GREEN);
         else if (levelCount==13)
            CentipedeB9.setColor(Color.RED);
         else if (levelCount==14)
            CentipedeB9.setColor(new Color(255,221,204));
         else if (levelCount==15)
            CentipedeB9.setColor(Color.BLACK);
         add(CentipedeB9);
      	
         CentipedeB10 = new GOval(132-(120),50,centiradi,centiradi);
         CentipedeB10.setFilled(true);
         if(levelCount==1)
            CentipedeB10.setColor(Color.GREEN);
         else if (levelCount==2)
            CentipedeB10.setColor(new Color(160,32,240));
         else if (levelCount==3)
            CentipedeB10.setColor(Color.RED);
         else if (levelCount==4)
            CentipedeB10.setColor(new Color(255,215,0));
         else if (levelCount==5)
            CentipedeB10.setColor(new Color(0,255,255));
         else if (levelCount==6)
            CentipedeB10.setColor(new Color(64,224,208)); 
         else if (levelCount==7)
            CentipedeB10.setColor(Color.YELLOW);
         else if (levelCount==8)
            CentipedeB10.setColor(new Color(64,224,208));
         else if (levelCount==9)
            CentipedeB10.setColor(new Color(238,034,187));
         else if (levelCount==10)
            CentipedeB10.setColor(Color.BLUE);
         else if (levelCount==11)
            CentipedeB10.setColor(new Color(0,255,255));
         else if (levelCount==12)
            CentipedeB10.setColor(Color.GREEN);
         else if (levelCount==13)
            CentipedeB10.setColor(Color.RED);
         else if (levelCount==14)
            CentipedeB10.setColor(new Color(255,221,204));
         else if (levelCount==15)
            CentipedeB10.setColor(Color.BLACK);
         add(CentipedeB10);
      	
         //Booty
         CentipedeBt = new GOval(132-(132),50,centiradi,centiradi);
         CentipedeBt.setFilled(true);
         if(levelCount==1)
            CentipedeBt.setColor(Color.GREEN);
         else if (levelCount==2)
            CentipedeBt.setColor(new Color(160,32,240));
         else if (levelCount==3)
            CentipedeBt.setColor(Color.RED);
         else if (levelCount==4)
            CentipedeBt.setColor(new Color(255,215,0));
         else if (levelCount==5)
            CentipedeBt.setColor(new Color(0,255,255));
         else if (levelCount==6)
            CentipedeBt.setColor(new Color(64,224,208));
         else if (levelCount==7)
            CentipedeBt.setColor(Color.YELLOW);
         else if (levelCount==8)
            CentipedeBt.setColor(new Color(64,224,208));
         else if (levelCount==9)
            CentipedeBt.setColor(new Color(238,034,187));
         else if (levelCount==10)
            CentipedeBt.setColor(Color.BLUE);
         else if (levelCount==11)
            CentipedeBt.setColor(new Color(0,255,255));
         else if (levelCount==12)
            CentipedeBt.setColor(Color.GREEN);
         else if (levelCount==13)
            CentipedeBt.setColor(Color.RED);
         else if (levelCount==14)
            CentipedeBt.setColor(new Color(255,221,204));
         else if (levelCount==15)
            CentipedeBt.setColor(Color.BLACK);
         add(CentipedeBt);
      }
      
        //createPaddle method -- called from the setup method
       public void createPaddle()
      {
      
         add(ship,WIDTH/2-25 ,HEIGHT-40);
      }

/*	public void createPaddle()
      {
         paddle = new GRect((WIDTH/2)-(PADDLE_WIDTH/2) , HEIGHT-30, PADDLE_WIDTH, PADDLE_HEIGHT);
         paddle.setFilled(true);
         paddle.setFillColor(Color.BLACK);
         add(paddle);
      }*/

   //createBall method -- called from the setup method
       public void createBall()
      {
         ball =  new GOval(ship.getX()+14,HEIGHT-40,6,10);
         ball.setFilled(true);
         ball.setFillColor(Color.RED);
         add(ball);
      }
       public void createBall2()
      {
         ball2 =  new GOval(ship.getX()+30,HEIGHT-40,6,10);
         ball2.setFilled(true);
         ball2.setFillColor(Color.RED);
         if(currentCount>999)
            add(ball2);
      }
       public void createBall3()
      {
         ball3 =  new GOval(ship.getX(),HEIGHT-40,6,10);
         ball3.setFilled(true);
         ball3.setFillColor(Color.RED);
         if(currentCount>999)
            add(ball3);
      }
   
   //play method -- called from the run method after setup
       public void play()
      {
         playBall();
      }
   
   //playBall method -- called from the play method
       public void playBall()
      {	
      //continuous loop
         while(true)
         {	
         
         //move the ball
            ball.move(0, -12);  
            if(currentCount>999)
            {
               ball2.move(0, -12);
               ball3.move(0, -12);
            }
         //pause
            pause(10);
         
         //check for contact along the outer walls
            if(ball.getY() <= 0)
            {
               remove(ball);
               createBall();
               play();
               vy = vy;	
            }
            else
               destroy();
            if(ball2.getY() <= 0)
            {
               remove(ball2);
               createBall2();	
               play();
               vy = vy;	
            }
            else
               destroy();
            if(ball3.getY() <= 0)
            {
               remove(ball3);
               createBall3();
               play();
               vy = vy;	
            }
            else
               destroy();
         }
      }
      
   	
       public void destroy()
      {
         GObject collider = getCollidingObject();
         GObject collider2 = getCollidingObject2();
         GObject collider3 = getCollidingObject3();
         
         if(collider == ship || collider == Background)
            vy = vy;
         else if(collider instanceof GRect) 
         {
            remove(collider);
            currentCount = currentCount + 10; 				
            currentCounter.setLabel("" + currentCount);				
            remove(ball);
            createBall();
            playBall();
         }
         else if(collider instanceof GOval)
         {
            if(levelCount==15)
               remove(bonus);
            centicount+=1;
            if(levelCount==15)
               centiCounter.setLabel("Segs Killed: " + centicount);
            if(centicount==1)
               remove(CentipedeBt);
            else if (centicount==2)
               remove(CentipedeB10);
            else if (centicount==3)
               remove(CentipedeB9);
            else if (centicount==4)
               remove(CentipedeB8);
            else if (centicount==5)
               remove(CentipedeB7);
            else if (centicount==6)
               remove(CentipedeB6);
            else if (centicount==7)
               remove(CentipedeB5);
            else if (centicount==8)
               remove(CentipedeB4);
            else if (centicount==9)
               remove(CentipedeB3);
            else if (centicount==10)
               remove(CentipedeB2);
            else if (centicount==11)
               remove(CentipedeB);
            else if (centicount==12)
            {
               remove(CentipedeH);
               remove(CentiEye1);
               remove(CentiEye2);
            }
            currentCount = currentCount + 100;
            currentCounter.setLabel("" + currentCount);
            remove(ball);
            createBall();
            playBall();
         }			
         
      	
         if(collider2 == ship || collider2 == Background)
            vy=vy;
         else if(collider2 instanceof GRect) 
         {
            remove(collider2);
            currentCount = currentCount + 10; 				
            currentCounter.setLabel("" + currentCount);		
            remove(ball2);
            createBall2();
            playBall();
         }
         else if(collider2 instanceof GOval)
         {
            centicount+=1;
            if(levelCount==15)
               centiCounter.setLabel("Segs Killed: " + centicount);
            if(centicount==1)
               remove(CentipedeBt);
            else if (centicount==2)
               remove(CentipedeB10);
            else if (centicount==3)
               remove(CentipedeB9);
            else if (centicount==4)
               remove(CentipedeB8);
            else if (centicount==5)
               remove(CentipedeB7);
            else if (centicount==6)
               remove(CentipedeB6);
            else if (centicount==7)
               remove(CentipedeB5);
            else if (centicount==8)
               remove(CentipedeB4);
            else if (centicount==9)
               remove(CentipedeB3);
            else if (centicount==10)
               remove(CentipedeB2);
            else if (centicount==11)
               remove(CentipedeB);
            else if (centicount==12)
            {
               remove(CentipedeH);
               remove(CentiEye1);
               remove(CentiEye2);
            }
            currentCount = currentCount + 100;
            currentCounter.setLabel("" + currentCount);
            remove(ball);
            createBall();
            playBall();
         }
         
      	
         if(collider3 == ship || collider3 == Background)
            vy = vy;
         else if(collider3 instanceof GRect) 
         {
            remove(collider3);
            currentCount = currentCount + 10; 				
            currentCounter.setLabel("" + currentCount);			
            remove(ball3);
            createBall3();
            playBall();
         }
         else if(collider3 instanceof GOval)
         {
            centicount+=1;
            if(levelCount==15)
               centiCounter.setLabel("Segs Killed: " + centicount);
            if(centicount==1)
               remove(CentipedeBt);
            else if (centicount==2)
               remove(CentipedeB10);
            else if (centicount==3)
               remove(CentipedeB9);
            else if (centicount==4)
               remove(CentipedeB8);
            else if (centicount==5)
               remove(CentipedeB7);
            else if (centicount==6)
               remove(CentipedeB6);
            else if (centicount==7)
               remove(CentipedeB5);
            else if (centicount==8)
               remove(CentipedeB4);
            else if (centicount==9)
               remove(CentipedeB3);
            else if (centicount==10)
               remove(CentipedeB2);
            else if (centicount==11)
               remove(CentipedeB);
            else if (centicount==12)
            {
               remove(CentipedeH);
               remove(CentiEye1);
               remove(CentiEye2);
            }
            currentCount = currentCount + 100;
            currentCounter.setLabel("" + currentCount);
            remove(ball);
            createBall();
            playBall();
         }
         
         if(centicount==12 && levelCount==15)
            End();
         
         if(centicount==12 && levelCount<15)
         {
            levelCount+=1;
            scoreCount= scoreCount + currentCount;
            currentCount= 0;
            centicount=0;
            currentCounter.setLabel("" + currentCount);
            scoreCounter.setLabel("" + scoreCount);
            levelCounter.setLabel("Level " + levelCount);
            remove(ball2);
            remove(ball3);
            Back();
            counterSetup();
            createPaddle();
            createCentipede();
            createMushrooms();
            playBall();
         }
         GObject collider4 = getCollidingObject4();
         GObject collider5 = getCollidingObject5();
         GObject collider6 = getCollidingObject6();
         GObject collider7 = getCollidingObject7();
         GObject collider8 = getCollidingObject8();
         GObject collider9 = getCollidingObject9();
         GObject collider10 = getCollidingObject10();
         GObject collider11 = getCollidingObject11();
         GObject collider12 = getCollidingObject12();
         GObject collider13 = getCollidingObject13();
         GObject collider14 = getCollidingObject14();
         GObject collider15 = getCollidingObject15();
         	
         CentipedeH.move(vxh,vyh);
         vyh=0;
         if(CentipedeH.getX() >= 586 || CentipedeH.getX() == 0)
         {
            vxh=vxh*-1;
            vyh= 8;
         }
         if(CentipedeH.getY()>= 760)
            End();
         if(collider4 == Background)
            vxh=vxh;
         if(collider4 instanceof GRect && collider4 != Background)
         {
            vxh=vxh*-1;
            vyh= 8;
            CentipedeH.move(vxh,vyh);
            vxe1=vxe1*-1;
            vye1= 8;
            CentiEye1.move(vxe1,vye1); 
            vxe2=vxe2*-1;
            vye2= 8;
            CentiEye2.move(vxe2,vye2);  
         }
            
         CentipedeB.move(vx2,vy2);
         vy2=0;
         if(CentipedeB.getX() >= 586 || CentipedeB.getX() == 0)
         {
            vx2=vx2*-1;
            vy2= 8;
         }
         if(collider5 == Background)
            vx2=vx2;
         else
            if(collider5 instanceof GRect)
            {
               vx2=vx2*-1;
               vy2= 8;
               CentipedeB.move(vx2,vy2); 
            }
            
         CentipedeB2.move(vx3,vy3);
         vy3=0;
         if(CentipedeB2.getX() >= 586|| CentipedeB2.getX() == 0)
         {
            vx3=vx3*-1;
            vy3= 8;
         }
         if(collider6 == Background)
            vx3=vx3;
         else
            if(collider6 instanceof GRect)
            {
               vx3=vx3*-1;
               vy3= 8;
               CentipedeB2.move(vx3,vy3); 
            }
            
         CentipedeB3.move(vx4,vy4);
         vy4=0;
         if(CentipedeB3.getX() >= 586|| CentipedeB3.getX() == 0)
         {
            vx4=vx4*-1;
            vy4= 8;
         }
         if(collider7 == Background)
            vx4=vx4;
         else
            if(collider7 instanceof GRect)
            {
               vx4=vx4*-1;
               vy4= 8;
               CentipedeB3.move(vx4,vy4); 
            }
            
         CentipedeB4.move(vx5,vy5);
         vy5=0;
         if(CentipedeB4.getX() >= 586|| CentipedeB4.getX() == 0)
         {
            vx5=vx5*-1;
            vy5= 8;
         }
         if(collider8 == Background)
            vx5=vx5;
         else
            if(collider8 instanceof GRect)
            {
               vx5=vx5*-1;
               vy5= 8;
               CentipedeB4.move(vx5,vy5); 
            }
            
         CentipedeB5.move(vx6,vy6);
         vy6=0;
         if(CentipedeB5.getX() >= 586|| CentipedeB5.getX() == 0)
         {
            vx6=vx6*-1;
            vy6= 8;
         }
         if(collider9 == Background)
            vx6=vx6;
         else
            if(collider9 instanceof GRect)
            {
               vx6=vx6*-1;
               vy6= 8;
               CentipedeB5.move(vx6,vy6); 
            }
            
         CentipedeB6.move(vx7,vy7);
         vy7=0;
         if(CentipedeB6.getX() >= 586 || CentipedeB6.getX() == 0)
         {
            vx7=vx7*-1;
            vy7= 8;
         }
         if(collider11 == Background)
            vx7=vx7;
         else
            if(collider11 instanceof GRect)
            {
               vx7=vx7*-1;
               vy7= 8;
               CentipedeB6.move(vx7,vy7); 
            }
               
         CentipedeB7.move(vx8,vy8);
         vy8=0;
         if(CentipedeB7.getX() >= 586 || CentipedeB7.getX() == 0)
         {
            vx8=vx8*-1;
            vy8= 8;
         }
         if(collider12 == Background)
            vx8=vx8;
         else
            if(collider12 instanceof GRect)
            {
               vx8=vx8*-1;
               vy8= 8;
               CentipedeB7.move(vx8,vy8); 
            }
               
         CentipedeB8.move(vx9,vy9);
         vy9=0;
         if(CentipedeB8.getX() >= 586 || CentipedeB8.getX() == 0)
         {
            vx9=vx9*-1;
            vy9= 8;
         }
         if(collider13 == Background)
            vx9=vx9;
         else
            if(collider13 instanceof GRect)
            {
               vx9=vx9*-1;
               vy9= 8;
               CentipedeB8.move(vx9,vy9); 
            }
               
         CentipedeB9.move(vx10,vy10);
         vy10=0;
         if(CentipedeB9.getX() >= 586 || CentipedeB9.getX() == 0)
         {
            vx10=vx10*-1;
            vy10= 8;
         }
         if(collider14 == Background)
            vx10=vx10;
         else
            if(collider14 instanceof GRect)
            {
               vx10=vx10*-1;
               vy10= 8;
               CentipedeB9.move(vx10,vy10); 
            }
               
         CentipedeB10.move(vx11,vy11);
         vy11=0;
         if(CentipedeB10.getX() >= 586 || CentipedeB10.getX() == 0)
         {
            vx11=vx11*-1;
            vy11= 8;
         }
         if(collider15 == Background)
            vx11=vx11;
         else
            if(collider15 instanceof GRect)
            {
               vx11=vx11*-1;
               vy11= 8;
               CentipedeB10.move(vx11,vy11); 
            }
               
         CentipedeBt.move(vx12,vy12);
         vy12=0;
         if(CentipedeBt.getX() >= 586 || CentipedeBt.getX() == 0)
         {
            vx12=vx12*-1;
            vy12= 8;
         }
         if(collider10 == Background)
            vx12=vx12;
         else
            if(collider10 instanceof GRect)
            {
               vx12=vx12*-1;
               vy12= 8;
               CentipedeBt.move(vx12,vy12); 
            }
      
            
         CentiEye1.move(vxe1,vye1);
         vye1=0;
         if(CentiEye1.getX() >= 590 || CentiEye1.getX() <= 4)
         {
            vxe1=vxe1*-1;
            vye1= 8;
         }
         
            
         CentiEye2.move(vxe2,vye2);
         vye2=0;
         if(CentiEye2.getX() >= 590 || CentiEye2.getX() <= 4)
         {
            
            vxe2=vxe2*-1;
            vye2= 8;
         }
      }
      
       public void End()
      {
         Back();
         end = new GLabel("GAME OVER", 170, 400);
         end.setFont(new Font("OCR A Extended", Font.BOLD, 50));
         end.setColor(Color.RED);
         add(end);
         GLabel end2 = new GLabel("SCORE:" + (scoreCount + currentCount), 150, 450);
         end2.setFont(new Font("OCR A Extended", Font.BOLD, 50));
         end2.setColor(Color.RED);
         add(end2);
         remove(ship);
         remove(levelCounter);
         remove(scoreCounter);
         remove(currentCounter);
         for(int x=0;x<1;x--)
         {
            remove(ball);
            remove(ball2);
            remove(ball3);
         }
      }
      
     //getCollidingObject -- called from the playBall method
   //discovers and returns the object that the ball collided with
       private GObject getCollidingObject()
      {
         if(getElementAt(ball.getX(),ball.getY()) != null)
            return getElementAt(ball.getX(), ball.getY());
         else if(getElementAt(ball.getX()+6*2, ball.getY()) != null)
            return getElementAt(ball.getX()+6*2, ball.getY());
         else 
            return null;
      } 
               
       private GObject getCollidingObject2()
      {
         if(getElementAt(ball2.getX(), ball2.getY()) != null)
            return getElementAt(ball2.getX(), ball2.getY());
         else if(getElementAt(ball2.getX()+6*2, ball2.getY()) != null)
            return getElementAt(ball2.getX()+6*2, ball2.getY());
         else 
            return null;
      }
      
       private GObject getCollidingObject3()
      {
         if(getElementAt(ball3.getX(), ball3.getY()) != null)
            return getElementAt(ball3.getX(), ball3.getY());
         else if(getElementAt(ball3.getX()+6*2, ball3.getY()) != null)
            return getElementAt(ball3.getX()+6*2, ball3.getY());
         else 
            return null;
      }
      
       private GObject getCollidingObject4()
      {
         if(getElementAt(CentipedeH.getX(),CentipedeH.getY()) != null)
            return getElementAt(CentipedeH.getX(), CentipedeH.getY());
         else if(getElementAt(CentipedeH.getX()+6*2, CentipedeH.getY()) != null)
            return getElementAt(CentipedeH.getX()+6*2, CentipedeH.getY());
         else if(getElementAt(CentipedeH.getX()+6*2, CentipedeH.getY()+6*2) != null)
            return getElementAt(CentipedeH.getX()+6*2, CentipedeH.getY()+6*2);
         else if(getElementAt(CentipedeH.getX(), CentipedeH.getY()+6*2) != null)
            return getElementAt(CentipedeH.getX(), CentipedeH.getY()+6*2);
         else 
            return null;
      }
      
       private GObject getCollidingObject5()
      {  
         if(getElementAt(CentipedeB.getX(),CentipedeB.getY()) != null)
            return getElementAt(CentipedeB.getX(), CentipedeB.getY());
         else if(getElementAt(CentipedeB.getX()+6*2, CentipedeB.getY()) != null)
            return getElementAt(CentipedeB.getX()+6*2, CentipedeB.getY());
         else if(getElementAt(CentipedeB.getX()+6*2, CentipedeB.getY()+6*2) != null)
            return getElementAt(CentipedeB.getX()+6*2, CentipedeB.getY()+6*2);
         else if(getElementAt(CentipedeB.getX(), CentipedeB.getY()+6*2) != null)
            return getElementAt(CentipedeB.getX(), CentipedeB.getY()+6*2);
         else 
            return null;
      }
      		
       private GObject getCollidingObject6()
      {    
         if(getElementAt(CentipedeB2.getX(),CentipedeB2.getY()) != null)
            return getElementAt(CentipedeB2.getX(), CentipedeB2.getY());
         else if(getElementAt(CentipedeB2.getX()+6*2, CentipedeB2.getY()) != null)
            return getElementAt(CentipedeB2.getX()+6*2, CentipedeB2.getY());
         else if(getElementAt(CentipedeB2.getX()+6*2, CentipedeB2.getY()+6*2) != null)
            return getElementAt(CentipedeB2.getX()+6*2, CentipedeB2.getY()+6*2);
         else if(getElementAt(CentipedeB2.getX(), CentipedeB2.getY()+6*2) != null)
            return getElementAt(CentipedeB2.getX(), CentipedeB2.getY()+6*2);
         else 
            return null;
      }
      		
       private GObject getCollidingObject7()
      {     
         if(getElementAt(CentipedeB3.getX(),CentipedeB3.getY()) != null)
            return getElementAt(CentipedeB3.getX(), CentipedeB3.getY());
         else if(getElementAt(CentipedeB3.getX()+6*2, CentipedeB3.getY()) != null)
            return getElementAt(CentipedeB3.getX()+6*2, CentipedeB3.getY());
         else if(getElementAt(CentipedeB3.getX()+6*2, CentipedeB3.getY()+6*2) != null)
            return getElementAt(CentipedeB3.getX()+6*2, CentipedeB3.getY()+6*2);
         else if(getElementAt(CentipedeB3.getX(), CentipedeB3.getY()+6*2) != null)
            return getElementAt(CentipedeB3.getX(), CentipedeB3.getY()+6*2);
         else 
            return null;
      }
      		
       private GObject getCollidingObject8()
      {     
         if(getElementAt(CentipedeB4.getX(),CentipedeB4.getY()) != null)
            return getElementAt(CentipedeB4.getX(), CentipedeB4.getY());
         else if(getElementAt(CentipedeB4.getX()+6*2, CentipedeB4.getY()) != null)
            return getElementAt(CentipedeB4.getX()+6*2, CentipedeB4.getY());
         else if(getElementAt(CentipedeB4.getX()+6*2, CentipedeB4.getY()+6*2) != null)
            return getElementAt(CentipedeB4.getX()+6*2, CentipedeB4.getY()+6*2);
         else if(getElementAt(CentipedeB4.getX(), CentipedeB4.getY()+6*2) != null)
            return getElementAt(CentipedeB4.getX(), CentipedeB4.getY()+6*2);
         else 
            return null;
      }
      		
       private GObject getCollidingObject9()
      {    
         if(getElementAt(CentipedeB5.getX(),CentipedeB5.getY()) != null)
            return getElementAt(CentipedeB5.getX(), CentipedeB5.getY());
         else if(getElementAt(CentipedeB5.getX()+6*2, CentipedeB5.getY()) != null)
            return getElementAt(CentipedeB5.getX()+6*2, CentipedeB5.getY());
         else if(getElementAt(CentipedeB5.getX()+6*2, CentipedeB5.getY()+6*2) != null)
            return getElementAt(CentipedeB5.getX()+6*2, CentipedeB5.getY()+6*2);
         else if(getElementAt(CentipedeB5.getX(), CentipedeB5.getY()+6*2) != null)
            return getElementAt(CentipedeB5.getX(), CentipedeB5.getY()+6*2);
         else 
            return null;
      }
      		
       private GObject getCollidingObject10()
      {     
         if(getElementAt(CentipedeBt.getX(),CentipedeBt.getY()) != null)
            return getElementAt(CentipedeBt.getX(), CentipedeBt.getY());
         else if(getElementAt(CentipedeBt.getX()+6*2, CentipedeBt.getY()) != null)
            return getElementAt(CentipedeBt.getX()+6*2, CentipedeBt.getY());
         else if(getElementAt(CentipedeBt.getX()+6*2, CentipedeBt.getY()+6*2) != null)
            return getElementAt(CentipedeBt.getX()+6*2, CentipedeBt.getY()+6*2);
         else if(getElementAt(CentipedeBt.getX(), CentipedeBt.getY()+6*2) != null)
            return getElementAt(CentipedeBt.getX(), CentipedeBt.getY()+6*2);
         else 
            return null;
      } 
      
       private GObject getCollidingObject11()
      {    
         if(getElementAt(CentipedeB6.getX(),CentipedeB6.getY()) != null)
            return getElementAt(CentipedeB6.getX(), CentipedeB6.getY());
         else if(getElementAt(CentipedeB6.getX()+6*2, CentipedeB6.getY()) != null)
            return getElementAt(CentipedeB6.getX()+6*2, CentipedeB6.getY());
         else if(getElementAt(CentipedeB6.getX()+6*2, CentipedeB6.getY()+6*2) != null)
            return getElementAt(CentipedeB6.getX()+6*2, CentipedeB6.getY()+6*2);
         else if(getElementAt(CentipedeB6.getX(), CentipedeB6.getY()+6*2) != null)
            return getElementAt(CentipedeB6.getX(), CentipedeB6.getY()+6*2);
         else 
            return null;
      }
      
       private GObject getCollidingObject12()
      {    
         if(getElementAt(CentipedeB7.getX(),CentipedeB7.getY()) != null)
            return getElementAt(CentipedeB7.getX(), CentipedeB7.getY());
         else if(getElementAt(CentipedeB7.getX()+6*2, CentipedeB7.getY()) != null)
            return getElementAt(CentipedeB7.getX()+6*2, CentipedeB7.getY());
         else if(getElementAt(CentipedeB7.getX()+6*2, CentipedeB7.getY()+6*2) != null)
            return getElementAt(CentipedeB7.getX()+6*2, CentipedeB7.getY()+6*2);
         else if(getElementAt(CentipedeB7.getX(), CentipedeB7.getY()+6*2) != null)
            return getElementAt(CentipedeB7.getX(), CentipedeB7.getY()+6*2);
         else 
            return null;
      }
      
       private GObject getCollidingObject13()
      {    
         if(getElementAt(CentipedeB8.getX(),CentipedeB8.getY()) != null)
            return getElementAt(CentipedeB8.getX(), CentipedeB8.getY());
         else if(getElementAt(CentipedeB8.getX()+6*2, CentipedeB8.getY()) != null)
            return getElementAt(CentipedeB8.getX()+6*2, CentipedeB8.getY());
         else if(getElementAt(CentipedeB8.getX()+6*2, CentipedeB8.getY()+6*2) != null)
            return getElementAt(CentipedeB8.getX()+6*2, CentipedeB8.getY()+6*2);
         else if(getElementAt(CentipedeB8.getX(), CentipedeB8.getY()+6*2) != null)
            return getElementAt(CentipedeB8.getX(), CentipedeB8.getY()+6*2);
         else 
            return null;
      }
      
       private GObject getCollidingObject14()
      {    
         if(getElementAt(CentipedeB9.getX(),CentipedeB9.getY()) != null)
            return getElementAt(CentipedeB9.getX(), CentipedeB9.getY());
         else if(getElementAt(CentipedeB9.getX()+6*2, CentipedeB9.getY()) != null)
            return getElementAt(CentipedeB9.getX()+6*2, CentipedeB9.getY());
         else if(getElementAt(CentipedeB9.getX()+6*2, CentipedeB9.getY()+6*2) != null)
            return getElementAt(CentipedeB9.getX()+6*2, CentipedeB9.getY()+6*2);
         else if(getElementAt(CentipedeB9.getX(), CentipedeB9.getY()+6*2) != null)
            return getElementAt(CentipedeB9.getX(), CentipedeB9.getY()+6*2);
         else 
            return null;
      }
      
       private GObject getCollidingObject15()
      {    
         if(getElementAt(CentipedeB10.getX(),CentipedeB10.getY()) != null)
            return getElementAt(CentipedeB10.getX(), CentipedeB10.getY());
         else if(getElementAt(CentipedeB10.getX()+6*2, CentipedeB10.getY()) != null)
            return getElementAt(CentipedeB10.getX()+6*2, CentipedeB10.getY());
         else if(getElementAt(CentipedeB10.getX()+6*2, CentipedeB10.getY()+6*2) != null)
            return getElementAt(CentipedeB10.getX()+6*2, CentipedeB10.getY()+6*2);
         else if(getElementAt(CentipedeB10.getX(), CentipedeB10.getY()+6*2) != null)
            return getElementAt(CentipedeB10.getX(), CentipedeB10.getY()+6*2);
         else 
            return null;
      }
   
       public void mouseMoved(MouseEvent e)
      {
      //only move the paddle every 5th mouse event 
      //otherwise the play slows every time the mouse moves
         if(toggle == 1){
         
            double eX = e.getX();
         
         //if the mouse moved to the right
            if(eX - lastX > 0)
            {
            //if paddle is not already at the right wall
               if(ship.getX() < WIDTH - 35)
               {
               //move to the right
                  ship.move(eX - lastX, 0);
               }
            }
            else //(if the mouse moved to the left)
            {
            //if paddle is not already at the left wall
               if(ship.getX() > 0)
               {
               //move to the left
                  ship.move(eX - lastX, 0);
               }
            }
           	
           //record this mouse x position for next mouse event         	
            GPoint last = new GPoint(e.getPoint());
            lastX = last.getX();
         
         //reset toggle to 1 
            toggle = 1;
         }
         else
         {
         //increment toggle by 1
         //(when toggle gets to 5 the code will move the paddle 
         // and reset toggle back to 1)
            toggle++;
         }
      }
   }
