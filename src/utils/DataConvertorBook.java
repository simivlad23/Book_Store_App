package utils;

import model.Product;

import java.util.List;

public interface DataConvertorBook {

    Object[][] bookToTableData(List<Product> products);

    String[] bookToTableColumnNames();
}
