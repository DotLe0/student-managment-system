package io.github.dotle0.student_management_system.main;

import java.sql.SQLException;
import java.util.List;

import dao.*;
import model.*;
import util.DBhelper;

public class App
{
    public static void main( String[] args ) throws SQLException
    {
    	wellcomeText();
    }
    
    public static void wellcomeText() {
    	System.out.println("Wellcome to Student-Managment-System");
    }
}
