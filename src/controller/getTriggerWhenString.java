package controller;

public class getTriggerWhenString {

    public String generateTriggerWhenString (Boolean insert, Boolean delete, Boolean update,String tablename , String affectedColumn){
        String result = "before ";
        int counter = 0;

        if ( insert) {
            result += "insert ";
            counter ++;
        }
        if (delete){
            if (counter > 0){
                result += "or ";

            }

                result += "delete ";
                counter++;
        }
        if (update){
            if (counter > 0){
                result += "or ";

            }
            result += "update of "+ affectedColumn;
        }
        result += " on "+ tablename;

        return result;
    }

}
