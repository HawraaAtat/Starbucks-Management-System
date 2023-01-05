/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz;

import dao.UserDao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Administrator
 */
public class Quiz extends javax.swing.JFrame {

    String userEmail;
    /**
     * Creates new form Quiz
     */
    public Quiz() {
        initComponents();
    }
    
    public Quiz(String email) {
        initComponents();
        userEmail = email;
    }

    String[] questions = {
                            "Which company created Starbucks?",
                            "When did Starbucks come out?",
                            "What year did Starbucks start selling lattes?",
                            "Who is Starbucks owned by?"
                        };
    String[][] options = {
                            {"Logo", "Starbucks", "Microsoft", "Alphabet"},
                            {"1989", "1971", "1972", "1492"},
                            {"1956", "1988", "1985", "1990"},
                            {"Steve Jobs", "Bill Gates", "Howard Schultz", "Mark Zuckerburg"}
                        };
    char[] answers = {
                        'A',
                        'B',
                        'C',
                        'C'
                    };

    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int result;
    int seconds = 10;

    Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if (seconds <= 0) {
                displayAnswer();

            }
        }
    });
    
    	public void nextQuestion() {

        if (index >= total_questions) {
            results();
        } else {
            textfield.setText("Question " + (index + 1));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();
        }
    }

    public void results() {

      		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		result = (int)((correct_guesses/(double)total_questions)*100);
		
		textfield.setText("RESULTS!");
		
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
		

                updSal();

    }
    
    
    public void updSal(){
    
       
        double currSalary= UserDao.selectSalary(userEmail);
        
        if(result>=75){
            currSalary=currSalary+currSalary*0.2;
                UserDao.updateSalary(userEmail, currSalary);
                textarea.setText("Your current salary is "+currSalary);
            }
        else{
        textarea.setText("Your current salary is "+currSalary);
        }
        
    }
    

    public void displayAnswer() {

        timer.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answers[index] != 'A') {
            answer_labelA.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'B') {
            answer_labelB.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'C') {
            answer_labelC.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'D') {
            answer_labelD.setForeground(new Color(255, 0, 0));
        }

        
        
        Timer pause = new Timer(2000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                answer_labelA.setForeground(new Color(0,102,51));
                answer_labelB.setForeground(new Color(0,102,51));
                answer_labelC.setForeground(new Color(0,102,51));
                answer_labelD.setForeground(new Color(0,102,51));

                answer = ' ';
                seconds = 10;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }

    	
               
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        buttonA = new javax.swing.JButton();
        answer_labelA = new javax.swing.JLabel();
        answer_labelB = new javax.swing.JLabel();
        buttonB = new javax.swing.JButton();
        answer_labelC = new javax.swing.JLabel();
        buttonC = new javax.swing.JButton();
        answer_labelD = new javax.swing.JLabel();
        buttonD = new javax.swing.JButton();
        number_right = new java.awt.Label();
        textfield = new java.awt.Label();
        textarea = new java.awt.Label();
        time_label = new java.awt.Label();
        percentage = new java.awt.Label();
        seconds_left = new java.awt.Label();

        setBounds(new java.awt.Rectangle(650, 0, 0, 0));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images (1).png"))); // NOI18N

        buttonA.setBackground(new java.awt.Color(0, 102, 51));
        buttonA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonA.setForeground(new java.awt.Color(255, 255, 255));
        buttonA.setText("A");
        buttonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAActionPerformed(evt);
            }
        });

        answer_labelA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        answer_labelA.setForeground(new java.awt.Color(0, 102, 51));

        answer_labelB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        answer_labelB.setForeground(new java.awt.Color(0, 102, 51));

        buttonB.setBackground(new java.awt.Color(0, 102, 51));
        buttonB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonB.setForeground(new java.awt.Color(255, 255, 255));
        buttonB.setText("B");
        buttonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBActionPerformed(evt);
            }
        });

        answer_labelC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        answer_labelC.setForeground(new java.awt.Color(0, 102, 51));

        buttonC.setBackground(new java.awt.Color(0, 102, 51));
        buttonC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonC.setForeground(new java.awt.Color(255, 255, 255));
        buttonC.setText("C");
        buttonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCActionPerformed(evt);
            }
        });

        answer_labelD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        answer_labelD.setForeground(new java.awt.Color(0, 102, 51));

        buttonD.setBackground(new java.awt.Color(0, 102, 51));
        buttonD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonD.setForeground(new java.awt.Color(255, 255, 255));
        buttonD.setText("D");
        buttonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDActionPerformed(evt);
            }
        });

        number_right.setAlignment(java.awt.Label.CENTER);
        number_right.setBackground(new java.awt.Color(0, 102, 51));
        number_right.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        number_right.setEnabled(false);
        number_right.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        number_right.setForeground(new java.awt.Color(255, 255, 255));

        textfield.setAlignment(java.awt.Label.CENTER);
        textfield.setBackground(new java.awt.Color(0, 102, 51));
        textfield.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textfield.setEnabled(false);
        textfield.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        textfield.setForeground(new java.awt.Color(255, 255, 255));

        textarea.setAlignment(java.awt.Label.CENTER);
        textarea.setBackground(new java.awt.Color(255, 255, 255));
        textarea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textarea.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        textarea.setForeground(new java.awt.Color(0, 102, 51));

        time_label.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        time_label.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        time_label.setForeground(new java.awt.Color(0, 102, 51));
        time_label.setText("timer >:D");

        percentage.setAlignment(java.awt.Label.CENTER);
        percentage.setBackground(new java.awt.Color(0, 102, 51));
        percentage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        percentage.setEnabled(false);
        percentage.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        percentage.setForeground(new java.awt.Color(255, 255, 255));

        seconds_left.setAlignment(java.awt.Label.CENTER);
        seconds_left.setBackground(new java.awt.Color(0, 102, 51));
        seconds_left.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        seconds_left.setFont(new java.awt.Font("MV Boli", 1, 48)); // NOI18N
        seconds_left.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(buttonB)
                                    .addGap(18, 18, 18)
                                    .addComponent(answer_labelB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(buttonA)
                                    .addGap(18, 18, 18)
                                    .addComponent(answer_labelA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(buttonC)
                                        .addComponent(buttonD))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(answer_labelC, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                                        .addComponent(answer_labelD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                            .addComponent(textarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(92, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(number_right, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(percentage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addComponent(time_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(seconds_left, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seconds_left, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textarea, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonA, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(answer_labelA, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(answer_labelB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonC, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(answer_labelC, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(answer_labelD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(time_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(number_right, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(percentage, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        number_right.getAccessibleContext().setAccessibleDescription("");
        time_label.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void formComponentShown(java.awt.event.ComponentEvent evt) {                                    
        // TODO add your handling code here:
        seconds_left.setText("   "+String.valueOf(seconds)+"   ");
        nextQuestion();
    }                                   

    private void buttonDActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        answer = 'D';
        if (answer == answers[index]) {
            correct_guesses++;
        }
        displayAnswer();
        

    }                                       

    private void buttonAActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        		
	buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        answer = 'A';
        if (answer == answers[index]) {
            correct_guesses++;
        }
        displayAnswer();
    }                                       

    private void buttonBActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        		
	buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        answer = 'B';
        if (answer == answers[index]) {
            correct_guesses++;
        }

        displayAnswer();
    }                                       

    private void buttonCActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        answer = 'C';
        if (answer == answers[index]) {
            correct_guesses++;
        }
        displayAnswer();

    }                                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel answer_labelA;
    private javax.swing.JLabel answer_labelB;
    private javax.swing.JLabel answer_labelC;
    private javax.swing.JLabel answer_labelD;
    private javax.swing.JButton buttonA;
    private javax.swing.JButton buttonB;
    private javax.swing.JButton buttonC;
    private javax.swing.JButton buttonD;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label number_right;
    private java.awt.Label percentage;
    private java.awt.Label seconds_left;
    private java.awt.Label textarea;
    private java.awt.Label textfield;
    private java.awt.Label time_label;
    // End of variables declaration                   
}
