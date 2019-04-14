package utils.impl;

import model.notUsed.Person;
import utils.DataConvertorPerson;

import java.util.List;

public class DataConvertorPersonImpl implements DataConvertorPerson {

    public Object[][] accountToTableData(List<Person> acc) {
        Object[][] data = new Object[acc.size()][4];
        for (int row = 0; row < data.length; row++) {
            data[row][0] = acc.get(row).getId();
            data[row][1] = acc.get(row).getName();
            data[row][2] = acc.get(row).getCNP();
            data[row][3] = acc.get(row).getAddres();
        }
        return data;
    }



    public String[] accountToTableColumnNames() {
        return new String[]{"Id","Nume", "CNP", "Addres"};
    }
}
