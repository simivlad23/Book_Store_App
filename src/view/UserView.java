package view;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

//TODO extend observer
public class UserView extends JFrame {

    private static final String TITLE = "User View";
    private static final int WIDTH = 600;
    private static final int HEIGHT = 500;
    private final JLabel findABookLabel;
    private final JLabel searchResult;
    private final JButton searchBtn;
    private final JButton sellBtn;

    private JLabel isbnLabel;
    private JLabel genLabel;
    private JLabel titleLabel;
    private JLabel authorLabel;
    private JLabel cantitate;
    private JLabel isbnLabelSell;


    private JTextField ISBN;
    private JTextField gen;
    private JTextField autor;
    private JTextField title;
    private JTextField isbnSell;

    private final JTable searchResultTable;
    private final JComboBox select;
    private final SpinnerNumberModel quantity;
    private final JSpinner spinner;


    private final JPanel bigPanel;
    private final JPanel left;
    private final JPanel right;
    private final JPanel grid;
    private final JPanel sellPanel;

    public UserView() throws HeadlessException {

        super(TITLE);
        findABookLabel = new JLabel("Find a book");
        searchResult = new JLabel("Result of Search");

        searchBtn = new JButton("Search");
        sellBtn = new JButton("Sell");


        isbnLabel = new JLabel("ISBN");
        genLabel = new JLabel("GEN");
        titleLabel = new JLabel("Title");
        authorLabel = new JLabel("Author");
        cantitate = new JLabel("Quantity");
        isbnLabelSell = new JLabel("ISBN");



        ISBN = new JTextField();
        gen = new JTextField();
        autor = new JTextField();
        title = new JTextField();
        isbnSell = new JTextField();


        searchResultTable = new JTable();
        select = new JComboBox<>(new String[]{"Id", "Name", "Price"});
        select.setEditable(false);
        quantity = new SpinnerNumberModel();
        spinner = new JSpinner(quantity);

        left = new JPanel();
        right = new JPanel();
        grid = new JPanel();
        bigPanel = new JPanel();
        sellPanel = new JPanel();


        initializeView();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeView() {

        bigPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        left.setLayout(new BoxLayout(left, BoxLayout.PAGE_AXIS));
        right.setLayout(new BoxLayout(right, BoxLayout.PAGE_AXIS));
        setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));

        left.add(Box.createRigidArea(new Dimension(20, 20)));
        findABookLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        left.add(findABookLabel);

        //set size for TextFeild
        ISBN.setSize(50,20);
        gen.setSize(50,20);
        autor.setSize(50,20);
        title.setSize(50,20);



        GridLayout gridLayout = new GridLayout(4, 2, 10, 10);
        GridLayout gridLayout2 = new GridLayout(1, 2, 10, 10);
        bigPanel.setLayout(gridLayout2);


        grid.setLayout(gridLayout);
        grid.add(isbnLabel);
        grid.add(ISBN);

        grid.add(genLabel);
        grid.add(gen);

        grid.add(authorLabel);
        grid.add(autor);

        grid.add(titleLabel);
        grid.add(title);


        left.add(grid);
        left.add(Box.createRigidArea(new Dimension(20, 20)));

        left.add(Box.createRigidArea(new Dimension(20, 20)));
        left.add(searchBtn);
        left.add(Box.createRigidArea(new Dimension(20, 20)));

        left.add(Box.createRigidArea(new Dimension(20, 20)));

        GridLayout gridLayout3 = new GridLayout(2, 2, 10, 10);
        sellPanel.setLayout(gridLayout3);
        sellPanel.add(cantitate);
        sellPanel.add(spinner);

        sellPanel.add(isbnLabelSell);
        sellPanel.add(isbnSell);

        left.add(sellPanel);
        left.add(Box.createRigidArea(new Dimension(20, 20)));
        left.add(Box.createRigidArea(new Dimension(20, 20)));
        left.add(sellBtn);

        left.add(Box.createRigidArea(new Dimension(20, 20)));

        left.add(Box.createRigidArea(new Dimension(20, 20)));


        bigPanel.add(left);

///---------------------------------------------------------------------------
        right.add(Box.createRigidArea(new Dimension(20, 20)));
        searchResult.setBorder(new EmptyBorder(10, 10, 10, 10));
        right.add(searchResult);
        bigPanel.add(right);
        right.add(Box.createRigidArea(new Dimension(20, 20)));
        JScrollPane jScrollPaneShoppingBasket = new JScrollPane(searchResultTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneShoppingBasket.setBorder(new EmptyBorder(10, 10, 10, 10));
        right.add(jScrollPaneShoppingBasket);
        right.add(Box.createRigidArea(new Dimension(20, 20)));


        //-----------------------------------------------------------
        add(bigPanel);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
    }

    public void setLoggedInUser(String userName) {
        this.findABookLabel.setText("Logged in as: " + userName);
    }

    public void refreshProductTable(Object[][] data, String[] columnNames) {
        DefaultTableModel tableModel = (DefaultTableModel) searchResultTable.getModel();
        tableModel.setDataVector(data, columnNames);
        tableModel.setColumnIdentifiers(columnNames);
        tableModel.fireTableDataChanged();
    }


    public void addSearchActionListener(ActionListener listener) {
        searchBtn.addActionListener(listener);
    }
    public void addSellActionListener(ActionListener listener) {
        sellBtn.addActionListener(listener);
    }




}
