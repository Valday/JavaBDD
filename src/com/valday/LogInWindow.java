package com.valday;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class LogInWindow
{
    //region Private Attributes
    private JButton but_Connect;
    private JTextField txtF_login;
    private JTextField txtF_Passwd;
    private JLabel lbl_Login;
    private JLabel lbl_passwd;
    private JButton but_Cancel;
    //endregion Private Attributes

    //region Public Attributes
    public JPanel PanelMain;
    //endregion Public Attributes

    //region Const Attributes

    private final Hashtable _passwd_Hashtable;

    //endregion Const Attributes

    //region Constructors Init

    public LogInWindow() {

        this._passwd_Hashtable = new Hashtable();
        this._passwd_Hashtable.put("admin","root");
        this._passwd_Hashtable.put("toto","toto");
        this._passwd_Hashtable.put("guide","guide");

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

        but_Cancel.addActionListener(new ActionListener() {
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
    }

    //endregion Constructors / Init

    //region Private Services
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
    //endregion Private Services

    //region Public Services
    public void dispose()
    {
        System.exit(0);
    }

    //endregion Public Services
}
