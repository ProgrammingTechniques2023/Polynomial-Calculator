package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import BusinessLogic.Operation;
import DataModels.Polynomial;

public class Controller implements ActionListener {
    private View view;
    //private Operation operations = new Operation();

    public Controller(View v) {
        this.view = v;
    }

    public void pol1TxtFieldPressed()
    {
        if((view.getPol1TxtField().getText()).equals(new String("Write the first polynomial here"))){
            view.getPol1TxtField().setText("");
        }
    }

    public void pol2TxtFieldPressed()
    {
        if((view.getPol2TxtField().getText()).equals(new String("Write the second polynomial here"))){
            view.getPol2TxtField().setText("");
        }
    }

    public void addPanelPressed() {
        Polynomial p1= Operation.transform(view.getPol1Txt());
        Polynomial p2=Operation.transform(view.getPol2Txt());
        if(validData(p1)==0 || validData(p2)==0  ) {
            return;
        }
        Polynomial p3=Operation.add(p1,p2);
        view.getResTxtField().setText(p3.toString());
    }

    public void subPanelPressed() {
        Polynomial p1=Operation.transform(view.getPol1Txt());
        Polynomial p2=Operation.transform(view.getPol2Txt());
        if(validData(p1)==0 || validData(p2)==0  ) {
            return;
        }
        Polynomial p3=Operation.sub(p1,p2);
        view.getResTxtField().setText(p3.toString());
    }

    public void mulPanelPressed() {
        Polynomial p1=Operation.transform(view.getPol1Txt());
        Polynomial p2=Operation.transform(view.getPol2Txt());
        if(validData(p1)==0 || validData(p2)==0  ) {
            return;
        }
        Polynomial p3=Operation.multiply(p1,p2);
        view.getResTxtField().setText(p3.toString());
    }

    public void divPanelPressed() {
        Polynomial p1=Operation.transform(view.getPol1Txt());
        Polynomial p2=Operation.transform(view.getPol2Txt());
        if(validData(p1)==0 || validData(p2)==0  ) {
            return;
        }
        ArrayList<Polynomial> p3 = Operation.divide(p1,p2);
        if(p3.get(0).getPolynomial().containsKey(-1)) {
            view.getResTxtField().setText("Divide by 0!");
            return ;
        }
        view.getResTxtField().setText("Q:" +p3.get(0).toString()+ " and R:"+p3.get(1).toString());
        //view.getResTxtField().setText("Not yet");
    }
    public void derivPanelPressed() {
        Polynomial p1=Operation.transform(view.getPol1Txt());
        if(validData(p1)==0) {
            return;
        }
        Polynomial p3=Operation.deriv(p1);
        view.getResTxtField().setText("For p1: "+p3.toString()+"+C");
    }
    public void integPanelPressed() {
        Polynomial p1=Operation.transform(view.getPol1Txt());
        if(validData(p1)==0) {
            return;
        }
        Polynomial p3=Operation.integrat(p1);
        view.getResTxtField().setText("For p1: "+p3.toString()+"+C");
    }
    public void helpPanelPressed() {
        view.getResTxtField().setText("Data form, without spaces, use just x: x-5+x^8");
    }


    public void restartPanelPressed()
    {
        view.getPol1TxtField().setText("Write the first polynomial here");
        view.getPol2TxtField().setText("Write the second polynomial here");
        view.getResTxtField().setText("Result");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println(e.getSource());
        String command = e.getActionCommand();
        if(command.equals("Click"))
        {
            view.getPol1TxtField().setText("");
        }
    }

    public int validData(Polynomial p) {
        if(p.getPolynomial().containsKey(-1)) {
            view.getResTxtField().setText("Invalid data input. Consult help!");
            return 0;
        }
        return 1;
    }
}
