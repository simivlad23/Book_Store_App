package utils.impl;


import model.notUsed.Account;
import utils.DataConverter;

import java.util.List;

public class DataConverterImpl implements DataConverter {

    public Object[][] accountToTableData(List<Account> acc) {
        Object[][] data = new Object[acc.size()][6];
        for (int row = 0; row < data.length; row++) {
            data[row][0] = acc.get(row).getId();
            data[row][1] = acc.get(row).getIban();
            data[row][2] = acc.get(row).getId_person();
            data[row][3] = acc.get(row).getType();
            data[row][4] = acc.get(row).getMoney();
            data[row][5] = acc.get(row).getDate_of_caretion();
        }
        return data;
    }



    public String[] accountToTableColumnNames() {
        return new String[]{"Id","Iban", "Person", "Type","Money","Date of creation"};
    }
}
