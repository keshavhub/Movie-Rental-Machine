package mrm.physical;import mrm.codeOperation.Operations;import store.Movies;import store.Status; public class CustomerConsole{      public CustomerConsole()    {    }         public void display(String message)    {        Operations.getInstance().clearDisplay();        Operations.getInstance().display(message);    }            public int readZIP(String prompt) throws Cancelled    {        Operations.getInstance().clearDisplay();        Operations.getInstance().display(prompt);        Operations.getInstance().display("");                String input = Operations.getInstance().readInput(Operations.ZIP_MODE, 0);                Operations.getInstance().clearDisplay();                if (input == null)            throw new Cancelled();        else            return Integer.parseInt(input);    }          public synchronized int readMenuChoice(String prompt, String[] menu) throws Cancelled    {        Operations.getInstance().clearDisplay();        Operations.getInstance().display(prompt);        for (int i = 0; i < menu.length; i ++)            Operations.getInstance().display((i+1) + ") " + menu[i]);        String input =             Operations.getInstance().readInput(Operations.MENU_MODE, menu.length);                    Operations.getInstance().clearDisplay();                if (input == null)            throw new Cancelled();        else            return Integer.parseInt(input) - 1;    }                    public synchronized Movies readAmount(String prompt) throws Cancelled    {        Operations.getInstance().clearDisplay();        Operations.getInstance().display(prompt);        Operations.getInstance().display("");                String input = Operations.getInstance().readInput(Operations.AMOUNT_MODE, 0);                Operations.getInstance().clearDisplay();                if (input == null)            throw new Cancelled();        else        {            int dollars = Integer.parseInt(input) / 100;            int cents = Integer.parseInt(input) % 100;            return new Movies(dollars, cents);        }    }          public static class Cancelled extends Exception    {               public Cancelled()        {            super("Cancelled by customer");        }    }}