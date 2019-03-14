package com.dhu.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends Frame implements MoneyListener{
    private Label label=new Label("金额");
    private Button button=new Button("购买");
    public Frame1(){
        this.setSize(400,200);
        this.setLayout(new FlowLayout());
        this.add(button);
        this.add(label);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame2().setMoneyListener(Frame1.this);
            }
        });
        this.setVisible(true);
    }

    @Override
    public void setMoney(String money) {
        label.setText(money);
    }

    public static void main(String[] args) {
        new Frame1();
    }
}
