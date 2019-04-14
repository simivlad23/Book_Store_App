package utils;

import model.notUsed.Account;

import java.util.List;

public interface DataConverter {
    Object[][] accountToTableData(List<Account> accounts);

    String[] accountToTableColumnNames();
}
