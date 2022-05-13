package com.zhou.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @Author: zhou.liu
 * @Date: 2022/5/13 14:11
 * @Description: 计算器
 */
public class Calculator extends Frame implements ActionListener, WindowListener
{
    private Container container;
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    /**
     * 计算结果显示区
     */
    private JTextField displayField;
    /**
     * 保存+,-,*,/,=命令0
     */
    private String lastCommand;
    /**
     * 保存计算结果
     */
    private double result;
    /**
     * 判断是否为数字的开始
     */
    private boolean start;
    private JMenuBar menubar;
    private JMenuItem m_exit;
    private JMenuItem m2_ejz;
    private JMenuItem m2_bjz;
    private Dialog dialog;
    private Label label_dialog;
    private JButton button_sqrt;
    private JButton button_plusminus;
    private JButton button_CE;
    private JButton button_cancel;
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton button_4;
    private JButton button_5;
    private JButton button_6;
    private JButton button_7;
    private JButton button_8;
    private JButton button_9;
    private JButton button_0;
    private JButton button_plus;
    private JButton button_minus;
    private JButton button_multiply;
    private JButton button_divide;
    private JButton button_point;
    private JButton button_equal;
    private JButton button_log;
    private JButton button_tan;
    private JButton button_cos;
    private JButton button_sin;
    private JButton button_exp;

    /**
     * 构造方法设置布局、为按钮注册事件监听器
     */
    public Calculator()
    {
        super( "My Calculator" );
        this.setLocation( 350,150 );
        this.setSize( 450,400 );
        this.setResizable( true );
        this.setLayout( new GridLayout( 7,1 ) );
        this.addMyMenu();                   //调用成员方法添加菜单
        displayField = new JTextField( 30 );
        this.add( displayField );
        displayField.setEditable( true );

        start = true;
        result = 0;
        lastCommand = "=";

        JPanel panel0 = new JPanel();
        panel0.setLayout( new GridLayout( 1,4,4,4 ) );


        JPanel panel1 = new JPanel();
        panel1.setLayout( new GridLayout( 1,5,4,4 ) );
        this.add( panel1 );
        /**
         * 根号
         */
        button_sqrt = new JButton( "sqrt" );
        button_plusminus = new JButton( "+/-" );
        /**
         * 底数e的n次幂
         */
        button_exp = new JButton( "exp" );
        button_CE = new JButton( "退位");
        /**
         * 清除
         */
        button_cancel = new JButton( "c" );

        JPanel panel2 = new  JPanel();
        panel2.setLayout( new GridLayout( 1,5,4,4 ) );
        this.add( panel2 );
        button_7 = new JButton( "7" );
        button_8 = new JButton( "8" );
        button_9 = new JButton( "9" );
        button_log = new JButton( "log" );
        button_divide = new JButton( "/" );

        JPanel panel3 = new JPanel();
        panel3.setLayout( new GridLayout(1,5,4,4) );
        this.add( panel3 );
        button_4 = new JButton( "4" );
        button_5 = new JButton( "5" );
        button_6 = new JButton( "6" );
        button_tan = new JButton( "tan" );
        button_multiply = new JButton( "*" );

        JPanel panel4=new  JPanel();
        panel4.setLayout( new GridLayout( 1,5,4,4 ) );
        this.add(panel4);
        button_1 = new JButton( "1" );
        button_2 = new JButton( "2" );
        button_3 = new JButton( "3" );
        button_cos = new JButton( "cos");
        button_minus = new JButton( "-" );

        JPanel panel5 = new  JPanel();
        panel5.setLayout( new GridLayout( 1,5,4,4 ) );
        this.add( panel5 );
        button_0 = new JButton( "0" );
        button_point=new JButton( "." );
        button_equal = new JButton( "=" );
        button_sin = new JButton( "sin" );
        button_plus = new JButton( "+" );

        panel1.add( button_sqrt );
        panel1.add( button_plusminus );
        panel1.add( button_exp );
        panel1.add( button_CE );
        panel1.add( button_cancel );
        panel2.add( button_7 );
        panel2.add( button_8 );
        panel2.add( button_9 );
        panel2.add( button_log );
        panel2.add( button_divide );
        panel3.add( button_4 );
        panel3.add( button_5 );
        panel3.add( button_6 );
        panel3.add( button_tan );
        panel3.add( button_multiply );
        panel4.add( button_1 );
        panel4.add( button_2 );
        panel4.add( button_3 );
        panel4.add( button_cos );
        panel4.add( button_minus );
        panel5.add( button_0 );
        panel5.add( button_point );
        panel5.add( button_equal );
        panel5.add( button_sin );
        panel5.add( button_plus) ;

        button_sqrt.addActionListener( this );
        button_plusminus.addActionListener( this );
        button_exp.addActionListener( this );
        button_CE.addActionListener( this );
        button_cancel.addActionListener( this );
        button_7.addActionListener( this );
        button_8.addActionListener( this );
        button_9.addActionListener( this );
        button_log.addActionListener( this );
        button_divide.addActionListener( this );
        button_4.addActionListener( this );
        button_5.addActionListener( this );
        button_6.addActionListener( this );
        button_tan.addActionListener( this );
        button_multiply.addActionListener( this );
        button_1.addActionListener( this );
        button_2.addActionListener( this );
        button_3.addActionListener( this );
        button_cos.addActionListener( this );
        button_minus.addActionListener( this );
        button_0.addActionListener( this );
        button_point.addActionListener( this );
        button_equal.addActionListener( this );
        button_sin.addActionListener( this );
        button_plus.addActionListener( this );

        /**
         * 注册窗口监听器
         */
        this.addWindowListener( new WinClose() );
        this.setVisible( true );
    }

    /**
     * 菜单的添加
     */
    private void addMyMenu()
    {
        JMenuBar menubar = new JMenuBar();
        this.add( menubar );
        JMenu m1 = new JMenu( "选项" );
        JMenu m2 = new JMenu( "进制转换" );

        JMenuItem m1_exit = new JMenuItem( "退出" );
        m1_exit.addActionListener( this );
        JMenuItem m2_ejz = new JMenuItem( "二进制" );
        m2_ejz.addActionListener( this );
        JMenuItem m2_bjz = new JMenuItem("八进制");
        m2_bjz.addActionListener( this );
        JMenuItem m2_sljz = new JMenuItem("十六进制");
        m2_sljz.addActionListener( this );

        JMenu m3 = new JMenu( "帮助" );
        JMenuItem m3_Help = new JMenuItem( "用法" );
        m3_Help.addActionListener( this );

        /**
         * 模式窗口
         */
        dialog = new Dialog( this, "提示" , true );
        dialog.setSize( 240,80 );
        /**
         * 标签的字符串为空，居中对齐
         */
        label_dialog = new Label("", Label.CENTER );
        dialog.add( label_dialog );
        /**
         * 为对话框注册窗口事件监听器
         */
        dialog.addWindowListener( this );
        m1.add( m1_exit );
        menubar.add( m1 );
        m2.add( m2_ejz );
        m2.add( m2_bjz );
        m2.add( m2_sljz );
        menubar.add( m2 );
        m3.add( m3_Help );
        menubar.add( m3 );
    }

    /**
     * 按钮的单击事件处理方法
     * @param e action
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(
                e.getSource().equals( button_1 )||e.getSource().equals( button_2 )||
                        e.getSource().equals( button_3 )||e.getSource().equals( button_4 )||
                        e.getSource().equals( button_5 )|| e.getSource().equals( button_6 )||
                        e.getSource().equals( button_7 )|| e.getSource().equals( button_8 )||
                        e.getSource().equals( button_9 ) ||e.getSource().equals( button_0 )||
                        e.getSource().equals( button_point )||e.getSource().equals( button_plusminus )||
                        e.getSource().equals( button_cancel )||e.getSource().equals( button_CE )
        )
        {      //非运算符的处理方法
            String input = e.getActionCommand();

            if ( start )
            {
                displayField.setText("");
                start = false;
                if( input.equals( "+/-" ) ) {
                    displayField.setText( displayField.getText()+ "-" );
                }
            }
            if( !input.equals( "+/-" ) )
            {
                String str = displayField.getText();
                if( input.equals( "退格" ) )
                {
                    if( str.length() > 0 ) {
                        displayField.setText( str.substring( 0,str.length() - 1 ) );
                    }
                }
                else if( input.equals( "C" ) )
                {
                    displayField.setText( "0" );
                    start = true;
                }
                else {
                    displayField.setText( displayField.getText() + input );
                }
            }
        }
        else if ( e.getActionCommand() == "二进制" )
        {
            int n = Integer.parseInt( displayField.getText() );
            displayField.setText( Integer.toBinaryString( n ) );
        }
        else if ( e.getActionCommand() == "八进制" )
        {
            int n = Integer.parseInt( displayField.getText() );
            displayField.setText( Integer.toOctalString( n ) );
        }
        else if ( e.getActionCommand() == "十六进制" )
        {
            int n = Integer.parseInt( displayField.getText() );
            displayField.setText( Integer.toHexString( n ) );
        }

        else if ( e.getActionCommand() == "退出" )
        {
            System.exit( 0 );
        }
        else if ( e.getActionCommand() == "用法" )
        {
            label_dialog.setText( "sqrt,exp等键是先输运算符再输数字\n" );
            dialog.setLocation( 400,250 );
            dialog.setVisible( true );
        }
        else
        {
            String command = e.getActionCommand();
            if( start )
            {
                lastCommand = command;
            }
            else
            {
                calculate( Double.parseDouble( displayField.getText() ) );
                lastCommand = command;
                start = true;
            }
        }
    }

    public void calculate( double x )
    {
        double d = 0;
        if ( lastCommand.equals( "+" ) ) {
            result += x;
        } else if (lastCommand.equals( "-" ) ) {
            result -= x;
        } else if ( lastCommand.equals( "*" ) ) {
            result *= x;
        } else if ( lastCommand.equals( "/" ) ) {
            result /= x;
        } else if ( lastCommand.equals( "=" ) ) {
            result = x;
        } else if ( lastCommand.equals( "sqrt" ) )
        {
            d = Math.sqrt( x );
            result = d;
        }
        else if ( lastCommand.equals( "exp" ) )
        {
            d = Math.exp( x );
            result = d;
        }
        else if ( lastCommand.equals( "log" ) )
        {
            d = Math.log( x );
            result = d;
        }
        else if ( lastCommand.equals( "tan" ) )
        {
            d = Math.tan(x);
            result = d;
        }
        else if ( lastCommand.equals( "cos" ) )
        {
            d = Math.cos( x );
            result = d;
        }
        else if ( lastCommand.equals( "sin" ) )
        {
            d = Math.sin( x );
            result = d;
        }
        displayField.setText( ""+ result );
    }

    @Override
    public void windowClosing(WindowEvent e )
    {
        if( e.getSource() == dialog ){
            //隐藏对话框
            dialog.setVisible( false );
        } else {
            System.exit( 0 );
        }
    }

    @Override
    public void windowOpened( WindowEvent e )         {  }
    @Override
    public void windowActivated( WindowEvent e )      {  }
    @Override
    public void windowDeactivated( WindowEvent e )    {  }
    @Override
    public void windowClosed( WindowEvent e )         {  }
    @Override
    public void windowIconified( WindowEvent e )      {  }
    @Override
    public void windowDeiconified( WindowEvent e )    {  }

    public static void main(String[] args) {
        new Calculator();
    }
}