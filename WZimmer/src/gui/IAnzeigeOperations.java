// Anzeige Interface
package gui;

import javax.swing.JPanel;

interface IAnzeigeOperations extends ICommonOperations{
    JPanel getWaitPanel();
    int getRows();
}