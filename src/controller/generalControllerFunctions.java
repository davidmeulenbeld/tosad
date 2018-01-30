package controller;

/**
 * The type General controller functions.
 */
public class generalControllerFunctions {

    /**
     * Generate string which defines when trigger happens
     *
     * @param insert         if it happens on insert
     * @param delete         if it happens on delete
     * @param update         if it happens on update
     * @param tablename      on which table it happens
     * @param affectedColumn which column is affected
     * @return the string
     */
    public String generateTriggerWhenString(Boolean insert, Boolean delete, Boolean update, String tablename, String affectedColumn) {
        String result = "before ";
        int counter = 0;
        //checks when trigger happens
        if (insert) {
            result += "insert ";
            counter++;
        }
        if (delete) {
            if (counter > 0) {
                result += "or ";

            }

            result += "delete ";
            counter++;
        }
        if (update) {
            if (counter > 0) {
                result += "or ";

            }
            result += "update of " + affectedColumn;
        }
        result += " on " + tablename + " \n";

        return result;
    }

}
