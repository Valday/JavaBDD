package com.valday.GestionAgenceVoyage.Managers;

import com.valday.GestionAgenceVoyage.GUI.AdminWindow;
import com.valday.GestionAgenceVoyage.GUI.CustomerWindow;
import com.valday.GestionAgenceVoyage.GUI.GuideWindow;

import javax.swing.*;

public final class Login_Manager
{
    private Login_Manager()
    {

    }
    public static void OpenAdminView()
    {
        JFrame frame = new JFrame("Admin window");
        frame.setContentPane(new AdminWindow().AdminWindowPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void OpenCustomerView()
    {
        JFrame frame = new JFrame("Customer window");
        frame.setContentPane(new CustomerWindow().CustomersWindowPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void OpenGuideView()
    {
        JFrame frame = new JFrame("Guide window");
        frame.setContentPane(new GuideWindow().GuideWindowPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
