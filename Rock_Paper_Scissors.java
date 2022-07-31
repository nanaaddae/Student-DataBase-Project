import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.List;
// simple game of Rock Paper Scissiors using java swing

// User makes a choice and the computer randomly makes a choice as well.

// Who ever gets to 3 wins in the game wins and the program ends.....
public class Rock_Paper_Scissors
{
   static int player_counter = 0;

  static  int computer_counter = 0;

    public static void main(String[] args)
    {


        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout());


        frame.getContentPane().setBackground(Color.BLUE);




        frame.setPreferredSize(new Dimension(1020, 720));



        //String choice;

        String[] words ={"Rock","Paper","Scissors"};








        ButtonGroup G = new ButtonGroup();

        JRadioButton Rock = new JRadioButton("Rock");
        JRadioButton Scissors = new JRadioButton("Scissors");
        JRadioButton Paper = new JRadioButton("Paper");

        JButton choice = new JButton("SUBMIT !!!");


        choice.setBounds(500,700,20,20);

        Rock.setBounds(500,250,60,40);

        Scissors.setBounds(500,300,40,40);

        Paper.setBounds(500,350,40,40);


        JPanel panel = new JPanel();




        choice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {


                int random = new Random().nextInt(words.length);
                if(Rock.isSelected())
                {


                    if(words[random].equals("Rock")) {
                        JOptionPane.showMessageDialog(null,
                                "TIE",
                                "Result",
                                JOptionPane.WARNING_MESSAGE);



                    }

                    if(words[random].equals("Scissors"))
                    {
                        JOptionPane.showMessageDialog(null,
                                "Rock Beats Scissiors",
                                "Result",
                                JOptionPane.WARNING_MESSAGE);

                        player_counter+=1;

                        JOptionPane.showMessageDialog(null,
                                "The Score is now\n"+computer_counter+"\n"+player_counter,
                                "Result",
                                JOptionPane.WARNING_MESSAGE);

                    }

                    if(words[random].equals("Paper")) {
                        JOptionPane.showMessageDialog(null,
                                "Rock loses to Paper",
                                "Result",
                                JOptionPane.WARNING_MESSAGE);

                        computer_counter+=1;

                        JOptionPane.showMessageDialog(null,
                                "The Score is now\n"+"COMPUTER"+computer_counter+"\n"+"PLAYER"+player_counter,
                                "Result",
                                JOptionPane.WARNING_MESSAGE);


                    }

                }

                else if(Paper.isSelected()) // If user selects Paper
                {
                    if(words[random].equals("Rock")) {
                        JOptionPane.showMessageDialog(null,
                                "Paper beats Rock" ,
                                "Result",
                                JOptionPane.WARNING_MESSAGE);

                                player_counter+=1;

                        JOptionPane.showMessageDialog(null,
                                "The Score is now\n"+"COMPUTER"+computer_counter+"\n"+"PLAYER"+player_counter,
                                "Result",
                                JOptionPane.WARNING_MESSAGE);


                    }
                    else if(words[random].equals("Paper"))
                    {
                        JOptionPane.showMessageDialog(null,
                                "Paper is the same as Paper",
                                "Result",
                                JOptionPane.WARNING_MESSAGE);

                    }

                   else if(words[random].equals("Scissors")) {
                        JOptionPane.showMessageDialog(null,
                                "Paper loses to Scissors",
                                "Result",
                                JOptionPane.WARNING_MESSAGE);

                            computer_counter+=1;


                        JOptionPane.showMessageDialog(null,
                                "The Score is now\n"+"COMPUTER"+computer_counter+"\n"+"PLAYER"+player_counter,
                                "Result",
                                JOptionPane.WARNING_MESSAGE);


                    }
                }

                else if(Scissors.isSelected()) // if Scissors is Chosen by the user
                {
                    if(words[random].equals("Scissors")) {
                        JOptionPane.showMessageDialog(null,
                                "TIE!!!",
                                "Result",
                                JOptionPane.WARNING_MESSAGE);


                    }
                    if(words[random].equals("Paper")) {
                        JOptionPane.showMessageDialog(null,
                                "Scissors Beats paper",
                                "Result",
                                JOptionPane.WARNING_MESSAGE);

                            player_counter+=1;

                        JOptionPane.showMessageDialog(null,
                                "The Score is now\n"+"COMPUTER "+computer_counter+"\n"+"PLAYER "+player_counter,
                                "Result",
                                JOptionPane.WARNING_MESSAGE);


                    }

                    if(words[random].equals("Rock")) {
                        JOptionPane.showMessageDialog(null,
                                "Scissors loses to Rock!",
                                "Result",
                                JOptionPane.WARNING_MESSAGE);

                        computer_counter += 1;

                        JOptionPane.showMessageDialog(null,
                                "The Score is now\n" + "COMPUTER " + computer_counter + "\n" + "PLAYER " + player_counter,
                                "Result",
                                JOptionPane.WARNING_MESSAGE);

                    }
                }


                if(player_counter == 3)
                {
                    JOptionPane.showMessageDialog(null,
                            "Congrats you won",
                            "Final Result",
                            JOptionPane.WARNING_MESSAGE);

                    System.exit(0);
                }


                else if (computer_counter == 3)
                {
                    JOptionPane.showMessageDialog(null,
                            "You lost sorry !!!!",
                            "Final Result",
                            JOptionPane.WARNING_MESSAGE);

                    System.exit(0);
                }

            }
        });

        G.add(Rock);

        G.add(Paper);

        G.add(Scissors);


        frame.add(Rock);
        frame.add(Scissors);
        frame.add(Paper);

        frame.add(choice);





        frame.pack();






        frame.setVisible(true);

    }


}
