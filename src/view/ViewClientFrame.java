package view;

import model.notUsed.Person;
import repository.NotUsed.PersonRepository;
import utils.DataConvertorPerson;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static javax.swing.BoxLayout.Y_AXIS;

public class ViewClientFrame extends JFrame {
    private static final String TITLE = "Sample View";
    private static final String ACTION_BUTTON_TEXT = "List";
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private final JTextField textField;
    private final JButton actionBtn;
    private final JTable table;

    private final PersonRepository personRepository;
    private final DataConvertorPerson dataConverter;

    public ViewClientFrame(PersonRepository personRepository,
                            DataConvertorPerson dataConverter) throws HeadlessException {
        super(TITLE);
        textField = new JTextField();
        actionBtn = new JButton(ACTION_BUTTON_TEXT);
        table = new JTable();
        initializeView();
        setVisible(true);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.personRepository = personRepository;

        actionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Person> items = ViewClientFrame.this.personRepository.findAll();
                Object[][] data = dataConverter.accountToTableData(items);
                String[] columns = dataConverter.accountToTableColumnNames();

                refreshTable(data, columns);
            }
        });
        this.dataConverter = dataConverter;
    }

    private void initializeView() {
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(Box.createRigidArea(new Dimension(20,20)));
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(jScrollPane);
        add(Box.createRigidArea(new Dimension(20,20)));
        textField.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(textField);
        add(Box.createRigidArea(new Dimension(20,20)));
        add(actionBtn);
        setSize(WIDTH, HEIGHT);
        setLocation(7,20);
        //setLocationRelativeTo(null);
    }

    private void addActionButtonListener(ActionListener listener) {
        actionBtn.addActionListener(listener);
    }

    private void refreshTable(Object[][] data, String[] columnNames) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setDataVector(data, columnNames);
        tableModel.setColumnIdentifiers(columnNames);
        tableModel.fireTableDataChanged();
    }


}
