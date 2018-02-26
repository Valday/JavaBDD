package com.valday;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class LogIn_Window
{

    private JButton Cancel;

    public JPanel getPanelMain() {
        return PanelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        PanelMain = panelMain;
    }

    private JPanel PanelMain;
    private JButton but_Connect;
    private JTextField txtF_login;
    private JTextField txtF_Passwd;
    private JLabel lbl_Login;
    private JLabel lbl_passwd;

    //region Private Attributes

    //endregion Private Attributes

    //region Const Attributes

    private final Hashtable _passwd_Hashtable;

    //endregion Const Attributes

    public LogIn_Windows() {
        Cancel.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        but_Connect.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                connect(txtF_login.getText(),txtF_Passwd.getText());
            }
        });

        this._passwd_Hashtable = new Hashtable();
        this._passwd_Hashtable.put("admin","root");
        this._passwd_Hashtable.put("toto","toto");
        this._passwd_Hashtable.put("guide","guide");

    }

    private void connect(String id, String passwd)
    {
            if (this._passwd_Hashtable.containsKey(id))
            {
                if (this._passwd_Hashtable.get(id).toString().equals(passwd))
                {
                    switch (id)
                    {
                        case "admin":
                            Login_Manager.OpenAdminView();
                            break;
                        case "toto":
                            Login_Manager.OpenCustomerView();
                            break;
                        case "guide":
                            Login_Manager.OpenGuideView();
                            break;
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid password");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid id, There is no user for this id");
            }
    }

    public void dispose()
    {
        System.exit(0);
    }
}
