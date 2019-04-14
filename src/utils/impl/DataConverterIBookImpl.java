package utils.impl;

import model.Product;
import utils.DataConvertorBook;

import java.util.List;

public class DataConverterIBookImpl implements DataConvertorBook {
    @Override
    public Object[][] bookToTableData(List<Product> products) {
            Object[][] data = new Object[products.size()][7];
            for (int row = 0; row < data.length; row++) {
                data[row][0] = products.get(row).getId();
                data[row][1] = products.get(row).getISBN();
                data[row][2] = products.get(row).getGenre();
                data[row][3] = products.get(row).getTitle();
                data[row][4] = products.get(row).getAuthor();
                data[row][5] = products.get(row).getPrice();
                data[row][6] = products.get(row).getQuantity();
            }
            return data;
    }

    @Override
    public String[] bookToTableColumnNames() {
        return new String[]{"ID","ISBN","Genre","Title","Autho","Price","Stok"};
    }
}
