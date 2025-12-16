package com.fuel.manager.provider;

import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
@Eager
public class FuelingFrameImpl implements FuelingFrame{
    JPanel jPanel = new JPanel();
    JProgressBar pb = new JProgressBar();
    FuelingFrameImpl() {
        pb.setString("0 Gallons");
        pb.setStringPainted(true);
        pb.setIndeterminate(true);
        jPanel.add(pb);
        jPanel.setVisible(true);
    }

    @Override
    public void updateBar(int fpNumber, double amount) {

    }
}
