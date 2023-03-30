package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class View extends JFrame{

    //private JFrame frmCalculator;
    private JTextField pol1TxtField;
    private JTextField pol2TxtField;
    private JTextField resTxtField;
    private JPanel addPanel;
    private JPanel subPanel;
    private JPanel mulPanel;
    private JPanel divPanel;
    private JPanel derivPanel;
    private JPanel integPanel;
    private JPanel helpPanel;
    private JPanel resPanel;


    Controller controller = new Controller(this);

    public View() {
        this.initialize();
    }

    private void firstPol() {
        JPanel pol1Panel = new JPanel();
        pol1Panel.setBackground(new Color(128, 255, 128));
        pol1Panel.setBorder(new LineBorder(new Color(40, 149, 44), 4, true));
        pol1Panel.setBounds(41, 58, 459, 62);
        this.getContentPane().add(pol1Panel);
        pol1Panel.setLayout(null);

        JLabel pol1Lbl = new JLabel("POLYNOMIAL 1:\r\n");
        pol1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        pol1Lbl.setFont(new Font("Cambria", Font.BOLD, 15));
        pol1Lbl.setBounds(10, 10, 149, 38);
        pol1Panel.add(pol1Lbl);

        pol1TxtField = new JTextField();
        pol1TxtField.setText("Write the first polynomial here");
        pol1TxtField.setBackground(new Color(128, 255, 128));
        pol1TxtField.setForeground(new Color(0, 0, 0));
        pol1TxtField.setFont(new Font("Cambria Math", Font.BOLD, 15));
        pol1TxtField.setHorizontalAlignment(SwingConstants.CENTER);
        pol1TxtField.setBounds(156, 10, 293, 39);
        pol1Panel.add(pol1TxtField);
        pol1TxtField.setColumns(10);
        pol1TxtField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                controller.pol1TxtFieldPressed();
            }
        });
    }

    private void secondPol(){
        JPanel pol2Panel = new JPanel();
        pol2Panel.setBackground(new Color(128, 255, 128));
        pol2Panel.setBounds(41, 130, 459, 62);
        this.getContentPane().add(pol2Panel);
        pol2Panel.setBorder(new LineBorder(new Color(40, 149, 44), 4, true));
        pol2Panel.setLayout(null);

        JLabel pol2Lbl = new JLabel("POLYNOMIAL 2:\r\n");
        pol2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        pol2Lbl.setFont(new Font("Cambria", Font.BOLD, 15));
        pol2Lbl.setBounds(10, 10, 149, 38);
        pol2Panel.add(pol2Lbl);

        pol2TxtField = new JTextField();
        pol2TxtField.setText("Write the second polynomial here");
        pol2TxtField.setBackground(new Color(128, 255, 128));
        pol2TxtField.setFont(new Font("Cambria Math", Font.BOLD, 15));
        pol2TxtField.setHorizontalAlignment(SwingConstants.CENTER);
        pol2TxtField.setColumns(10);
        pol2TxtField.setBounds(156, 10, 293, 39);
        pol2Panel.add(pol2TxtField);
        pol2TxtField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                controller.pol2TxtFieldPressed();
            }
        });
    }

    private void addView(){
        addPanel = new JPanel();
        addPanel.setLayout(null);
        addPanel.setBorder(new LineBorder(new Color(40, 149, 44), 4, true));
        addPanel.setBackground(new Color(128, 255, 128));
        addPanel.setBounds(85, 202, 178, 62);
        this.getContentPane().add(addPanel);
        addPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                controller.addPanelPressed();
            }
        });

        JLabel addLbl = new JLabel("Addition");
        addLbl.setHorizontalAlignment(SwingConstants.CENTER);
        addLbl.setFont(new Font("Cambria", Font.BOLD, 17));
        addLbl.setBounds(10, 10, 158, 38);
        addPanel.add(addLbl);
    }

    private void subView(){
        subPanel = new JPanel();
        subPanel.setLayout(null);
        subPanel.setBorder(new LineBorder(new Color(40, 149, 44), 4, true));
        subPanel.setBackground(new Color(128, 255, 128));
        subPanel.setBounds(286, 202, 178, 62);
        this.getContentPane().add(subPanel);
        subPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                controller.subPanelPressed();
            }
        });

        JLabel subLbl = new JLabel("Subtraction");
        subLbl.setHorizontalAlignment(SwingConstants.CENTER);
        subLbl.setFont(new Font("Cambria", Font.BOLD, 17));
        subLbl.setBounds(10, 10, 158, 38);
        subPanel.add(subLbl);
    }

    private void mulView(){
        mulPanel = new JPanel();
        mulPanel.setLayout(null);
        mulPanel.setBorder(new LineBorder(new Color(40, 149, 44), 4, true));
        mulPanel.setBackground(new Color(128, 255, 128));
        mulPanel.setBounds(85, 274, 178, 62);
        this.getContentPane().add(mulPanel);

        mulPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                controller.mulPanelPressed();
            }
        });

        JLabel mulLbl = new JLabel("Multiplication ");
        mulLbl.setHorizontalAlignment(SwingConstants.CENTER);
        mulLbl.setFont(new Font("Cambria", Font.BOLD, 17));
        mulLbl.setBounds(10, 10, 158, 38);
        mulPanel.add(mulLbl);
    }

    private void divView(){
        divPanel = new JPanel();
        divPanel.setLayout(null);
        divPanel.setBorder(new LineBorder(new Color(40, 149, 44), 4, true));
        divPanel.setBackground(new Color(128, 255, 128));
        divPanel.setBounds(286, 274, 178, 62);
        this.getContentPane().add(divPanel);

        divPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                controller.divPanelPressed();
            }
        });

        JLabel divLbl = new JLabel("Division");
        divLbl.setHorizontalAlignment(SwingConstants.CENTER);
        divLbl.setFont(new Font("Cambria", Font.BOLD, 17));
        divLbl.setBounds(10, 10, 158, 38);
        divPanel.add(divLbl);
    }

    private void derivView(){
        derivPanel = new JPanel();
        derivPanel.setLayout(null);
        derivPanel.setBorder(new LineBorder(new Color(40, 149, 44), 4, true));
        derivPanel.setBackground(new Color(128, 255, 128));
        derivPanel.setBounds(85, 346, 178, 62);
        this.getContentPane().add(derivPanel);

        derivPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                controller.derivPanelPressed();
            }
        });

        JLabel derivLbl = new JLabel("Derivation");
        derivLbl.setHorizontalAlignment(SwingConstants.CENTER);
        derivLbl.setFont(new Font("Cambria", Font.BOLD, 17));
        derivLbl.setBounds(10, 10, 158, 38);
        derivPanel.add(derivLbl);
    }

    private void integView(){
        integPanel = new JPanel();
        integPanel.setLayout(null);
        integPanel.setBorder(new LineBorder(new Color(40, 149, 44), 4, true));
        integPanel.setBackground(new Color(128, 255, 128));
        integPanel.setBounds(286, 346, 178, 62);
        this.getContentPane().add(integPanel);

        integPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                controller.integPanelPressed();
            }
        });
        JLabel integLbl = new JLabel("Integration");
        integLbl.setHorizontalAlignment(SwingConstants.CENTER);
        integLbl.setFont(new Font("Cambria", Font.BOLD, 17));
        integLbl.setBounds(10, 10, 158, 38);
        integPanel.add(integLbl);
    }

    private void resultView(){
        resPanel = new JPanel();
        resPanel.setLayout(null);
        resPanel.setBorder(new LineBorder(new Color(40, 149, 44), 4, true));
        resPanel.setBackground(new Color(128, 255, 128));
        resPanel.setBounds(41, 418, 459, 109);
        this.getContentPane().add(resPanel);

        resTxtField = new JTextField();
        resTxtField.setEditable(false);
        resTxtField.setBackground(new Color(128, 255, 128));
        resTxtField.setText("Result");
        resTxtField.setHorizontalAlignment(SwingConstants.CENTER);
        resTxtField.setFont(new Font("Cambria Math", Font.BOLD, 15));
        resTxtField.setBounds(10, 10, 332, 89);
        resPanel.add(resTxtField);
        resTxtField.setColumns(10);
    }

    private void helpView(){
        helpPanel = new JPanel();
        helpPanel.setBounds(368, 13, 64, 38);
        resPanel.add(helpPanel);
        helpPanel.setLayout(null);
        helpPanel.setBorder(new LineBorder(new Color(40, 149, 44), 4, true));
        helpPanel.setBackground(new Color(128, 255, 128));

        JLabel helpLbl = new JLabel("Help");
        helpLbl.setHorizontalAlignment(SwingConstants.CENTER);
        helpLbl.setFont(new Font("Cambria", Font.BOLD, 17));
        helpLbl.setBounds(10, 10, 44, 18);
        helpPanel.add(helpLbl);

        helpPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                controller.helpPanelPressed();
            }
        });
    }

    private void restartView(){
        JPanel restartPanel = new JPanel();
        restartPanel.setLayout(null);
        restartPanel.setBorder(new LineBorder(new Color(40, 149, 44), 4, true));
        restartPanel.setBackground(new Color(128, 255, 128));
        restartPanel.setBounds(352, 61, 97, 38);
        resPanel.add(restartPanel);
        restartPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                controller.restartPanelPressed();
            }
        });


        JLabel restartLbl = new JLabel("Restart");
        restartLbl.setHorizontalAlignment(SwingConstants.CENTER);
        restartLbl.setFont(new Font("Cambria", Font.BOLD, 17));
        restartLbl.setBounds(10, 10, 77, 18);
        restartPanel.add(restartLbl);
    }
    private void initialize() {

        this.setTitle("Calculator");
        this.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(128, 255, 128));
        this.setBounds(100, 100, 555, 571);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titleLbl = new JLabel("POLYNOMIAL CALCULATOR");
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(new Font("Cambria", Font.BOLD, 18));
        titleLbl.setBounds(10, 10, 521, 38);
        this.getContentPane().add(titleLbl);

        firstPol();
        secondPol();
        addView();
        subView();
        mulView();
        divView();
        derivView();
        integView();
        resultView();
        helpView();
        restartView();
    }

    public JTextField getPol1TxtField() {
        return pol1TxtField;
    }
    public String getPol1Txt() {
        return pol1TxtField.getText();
    }

    public JTextField getPol2TxtField() {
        return pol2TxtField;
    }
    public String getPol2Txt() {
        return pol2TxtField.getText();
    }

    public JTextField getResTxtField() {
        return resTxtField;
    }
}
