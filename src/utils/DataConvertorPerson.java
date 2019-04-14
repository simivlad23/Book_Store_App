package utils;

import model.notUsed.Person;

import java.util.List;

public interface DataConvertorPerson {
    Object[][] accountToTableData(List<Person> accounts);

    String[] accountToTableColumnNames();
}
