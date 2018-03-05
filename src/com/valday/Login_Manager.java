package com.valday;

import javax.swing.*;

public final class Login_Manager
{
    private Login_Manager()
    {

    }
    public static void OpenAdminView()
    {
        JFrame frame = new JFrame("Admin window");
        frame.setContentPane(new Admin_Window().getAdminWindow_Panel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void OpenCustomerView()
    {
        JFrame frame = new JFrame("Customer window");
        frame.setContentPane(new Customer_Windows().getCustomersWindow_Panel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void OpenGuideView()
    {
        JFrame frame = new JFrame("Guide window");
        frame.setContentPane(new Guide_Window().getGuideWindow_Panel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
