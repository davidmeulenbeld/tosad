package domain;


import dao.ARNGDAO;


public class Test {

    public static void main(String args[]) {

        ARNGDAO adao = new ARNGDAO();

       System.out.println( adao.getenoughinfotogenerate(207));

    }
}
