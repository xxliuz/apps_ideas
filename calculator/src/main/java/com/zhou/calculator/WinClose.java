package com.zhou.calculator;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @Author: zhou.liu
 * @Date: 2022/5/13 14:24
 * @Description:
 */

public class WinClose implements WindowListener
{
    /**
     * 单击窗口关闭按钮时触发并执行实现窗口监听器接口中的方法
     * @param e Event
     */
    @Override
    public void windowClosing( WindowEvent e )
    {
        System.exit( 0 );
    }
    @Override
    public void windowOpened( WindowEvent e ){ }
    @Override
    public void windowActivated( WindowEvent e ){}
    @Override
    public void windowDeactivated( WindowEvent e){ }
    @Override
    public void windowClosed( WindowEvent e ){ }
    @Override
    public void windowIconified( WindowEvent e ){ }
    @Override
    public void windowDeiconified( WindowEvent e ){ }
}