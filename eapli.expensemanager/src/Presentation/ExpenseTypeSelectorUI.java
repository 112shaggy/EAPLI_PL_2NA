/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Controllers.ExpenseTypeController;
import Model.ExpenseType;
import eapli.util.Console;

/**
 *
 * @author Raul.Lima
 */
public class ExpenseTypeSelectorUI {
    
    ExpenseTypeController pController = new ExpenseTypeController();
    
    public ExpenseTypeSelectorUI() {}
    
    public ExpenseType SelectExpenseType(boolean aCancelable) {
        System.out.println("\nExpense types list:");
        if (aCancelable) {
            System.out.println("[0] Cancel selection");
        }
        System.out.println(pController.ExpenseTypeList(true));
        int option = Console.readInteger("Please choose an expense type");
        while (true) {
            switch (option) {
                case 0: 
                    if (!aCancelable) {
                        option = Console.readInteger("Option not available! Please choose an expense type");
                    } else {
                        return null;
                    }
                default:
                    ExpenseType et = pController.GetExpenseType(option);
                    if (et == null) {
                        option = Console.readInteger("Option not available! Please choose an expense type");
                    } else {
                        return et;
                    }
                    break;
            }
        }
    }
    
}
