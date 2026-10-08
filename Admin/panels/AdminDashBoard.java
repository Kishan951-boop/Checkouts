package booksmart.Admin.panels;

import booksmart.connection.connection;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class AdminDashBoard extends javax.swing.JPanel {

    public static int Remains;
    public static int Sold;
    public static int Price;
    public static int Worth;
    public static int Book;
    public static int Customer;

    public AdminDashBoard() {
        initComponents();
        design();

        // Create dataset
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.addValue(1, "Series1", "2020");
//        dataset.addValue(4, "Series1", "2021");
//        dataset.addValue(3, "Series1", "2022");
//        dataset.addValue(5, "Series1", "2023");
//
//        // Create chart
//        JFreeChart chart = ChartFactory.createLineChart(
//                "Yearly Data", // Chart title
//                "Year", // X-Axis Label
//                "Value", // Y-Axis Label
//                dataset,
//                PlotOrientation.VERTICAL,
//                true, true, false);
//
//        // Create Panel
//        ChartPanel panel = new ChartPanel(chart);
//        setContentPane(panel);
//        JFreeChart chart = ChartFactory.createLineChart(
//                "Yearly Data",
//                "Year",
//                "Value",
//                dataset,
//                PlotOrientation.VERTICAL,
//                true, true, false);
//
//        ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
//
//// Assuming your JPanel is named `mainPanel`
//        mainPanel.setLayout(new BorderLayout());
//        mainPanel.add(chartPanel, BorderLayout.CENTER);
//        mainPanel.revalidate(); // Refresh to display the chart

    }

//    public LineChartExample(String title) {
//        super(title);
//
//        // Create dataset
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.addValue(1, "Series1", "2020");
//        dataset.addValue(4, "Series1", "2021");
//        dataset.addValue(3, "Series1", "2022");
//        dataset.addValue(5, "Series1", "2023");
//
//        // Create chart
//        JFreeChart chart = ChartFactory.createLineChart(
//                "Yearly Data", // Chart title
//                "Year", // X-Axis Label
//                "Value", // Y-Axis Label
//                dataset,
//                PlotOrientation.VERTICAL,
//                true, true, false);
//
//        // Create Panel
//        ChartPanel panel = new ChartPanel(chart);
//        setContentPane(panel);
//    }
    private void chart() {

//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.addValue(200, "Sales", "January");
//        dataset.addValue(150, "Sales", "February");
//        dataset.addValue(180, "Sales", "March");
//        dataset.addValue(260, "Sales", "April");
//        dataset.addValue(300, "Sales", "May");
//
//        JFreeChart chart = ChartFactory.createLineChart(
//                "Monthly Sales",
//                "Month",
//                "Sales",
//                dataset);
//        
//        ChartPanel chartPanel = new ChartPanel(chart);
//
//        Chartjframeframe.setContentPane(chartPanel);
    }

    private void design() {

        try {
            ResultSet rs = connection.Search("SELECT * FROM `stock`");
            ResultSet book = connection.Search("SELECT * FROM `books`");
            ResultSet customer = connection.Search("SELECT * FROM `cutomer`");

            if (rs.next()) {
                while (rs.next()) {
                    Remains = Remains + rs.getInt("Qty");
                    Sold = Sold + rs.getInt("Sold");
                    Price = Price + rs.getInt("Original_Price");
                    Worth = Worth + rs.getInt("Public_Price");
                }
            }

            while (book.next()) {
                Book = Book + 1;
            }

            while (customer.next()) {
                Customer = Customer + 1;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Please Contac that devloper, why,,,,,,,,",
                    "DashBoard",
                    JOptionPane.ERROR_MESSAGE);
        }

        StocksLabel.setText(String.valueOf(Remains));
        SoldLabel.setText(String.valueOf(Sold));
        PriceLabel.setText(String.valueOf(Price));
        WorthLabel.setText(String.valueOf(Worth));
        BookLabel.setText(String.valueOf(Book));
        Customers.setText(String.valueOf(Customer));

        headBar.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        headBar1.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        headBar2.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        headBar3.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        headBar4.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        headBar5.putClientProperty(FlatClientProperties.STYLE, "arc: 20");

        stockImg.setIcon(new FlatSVGIcon("booksmart/img/boxes-stacked-solid.svg", 50, 50));
        stockImg1.setIcon(new FlatSVGIcon("booksmart/img/cubes-stacked-solid.svg", 50, 50));
        stockImg2.setIcon(new FlatSVGIcon("booksmart/img/arrow-trend-down-solid.svg", 50, 50));
        stockImg3.setIcon(new FlatSVGIcon("booksmart/img/arrow-trend-up-solid.svg", 50, 50));
        stockImg4.setIcon(new FlatSVGIcon("booksmart/img/book-open-solid.svg", 50, 50));
        stockImg5.setIcon(new FlatSVGIcon("booksmart/img/users-line-solid.svg", 50, 50));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headBar = new javax.swing.JPanel();
        stockImg = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        StocksLabel = new javax.swing.JLabel();
        headBar1 = new javax.swing.JPanel();
        stockImg1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SoldLabel = new javax.swing.JLabel();
        headBar2 = new javax.swing.JPanel();
        stockImg2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PriceLabel = new javax.swing.JLabel();
        headBar3 = new javax.swing.JPanel();
        stockImg3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        WorthLabel = new javax.swing.JLabel();
        headBar4 = new javax.swing.JPanel();
        stockImg4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BookLabel = new javax.swing.JLabel();
        headBar5 = new javax.swing.JPanel();
        stockImg5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Customers = new javax.swing.JLabel();

        setFocusTraversalPolicyProvider(true);
        setMaximumSize(new java.awt.Dimension(200, 200));
        setPreferredSize(new java.awt.Dimension(500, 500));

        headBar.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel2.setText("Stock Remained.");

        StocksLabel.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 24)); // NOI18N
        StocksLabel.setText("20");

        javax.swing.GroupLayout headBarLayout = new javax.swing.GroupLayout(headBar);
        headBar.setLayout(headBarLayout);
        headBarLayout.setHorizontalGroup(
            headBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headBarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(stockImg, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headBarLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(headBarLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(StocksLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(47, 47, 47))))
        );
        headBarLayout.setVerticalGroup(
            headBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headBarLayout.createSequentialGroup()
                .addGroup(headBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headBarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(stockImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(headBarLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StocksLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        headBar1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel3.setText("Sold Stock.");

        SoldLabel.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 24)); // NOI18N
        SoldLabel.setText("20");

        javax.swing.GroupLayout headBar1Layout = new javax.swing.GroupLayout(headBar1);
        headBar1.setLayout(headBar1Layout);
        headBar1Layout.setHorizontalGroup(
            headBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headBar1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(stockImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(headBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headBar1Layout.createSequentialGroup()
                        .addComponent(SoldLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(57, 57, 57))
                    .addGroup(headBar1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        headBar1Layout.setVerticalGroup(
            headBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headBar1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SoldLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(stockImg1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );

        headBar2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel4.setText("Stock Paid.");

        PriceLabel.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 24)); // NOI18N
        PriceLabel.setText("20");

        javax.swing.GroupLayout headBar2Layout = new javax.swing.GroupLayout(headBar2);
        headBar2.setLayout(headBar2Layout);
        headBar2Layout.setHorizontalGroup(
            headBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headBar2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(stockImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(headBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headBar2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(headBar2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(PriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(48, 48, 48))))
        );
        headBar2Layout.setVerticalGroup(
            headBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headBar2Layout.createSequentialGroup()
                .addGroup(headBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headBar2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(stockImg2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(headBar2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        headBar3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel5.setText("Stock Worth.");

        WorthLabel.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 24)); // NOI18N
        WorthLabel.setText("20");

        javax.swing.GroupLayout headBar3Layout = new javax.swing.GroupLayout(headBar3);
        headBar3.setLayout(headBar3Layout);
        headBar3Layout.setHorizontalGroup(
            headBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headBar3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(stockImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headBar3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(headBar3Layout.createSequentialGroup()
                        .addComponent(WorthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(39, 39, 39))))
        );
        headBar3Layout.setVerticalGroup(
            headBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headBar3Layout.createSequentialGroup()
                .addGroup(headBar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headBar3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(stockImg3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(headBar3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(WorthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)))
                .addContainerGap())
        );

        headBar4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel6.setText("All Books.");

        BookLabel.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 24)); // NOI18N
        BookLabel.setText("20");

        javax.swing.GroupLayout headBar4Layout = new javax.swing.GroupLayout(headBar4);
        headBar4.setLayout(headBar4Layout);
        headBar4Layout.setHorizontalGroup(
            headBar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headBar4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(stockImg4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(headBar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headBar4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(headBar4Layout.createSequentialGroup()
                        .addComponent(BookLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))))
        );
        headBar4Layout.setVerticalGroup(
            headBar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headBar4Layout.createSequentialGroup()
                .addGroup(headBar4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headBar4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(stockImg4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(headBar4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BookLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)))
                .addContainerGap())
        );

        headBar5.setBackground(new java.awt.Color(102, 102, 102));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel7.setText("Customers.");

        Customers.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 24)); // NOI18N
        Customers.setText("20");

        javax.swing.GroupLayout headBar5Layout = new javax.swing.GroupLayout(headBar5);
        headBar5.setLayout(headBar5Layout);
        headBar5Layout.setHorizontalGroup(
            headBar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headBar5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(stockImg5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headBar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headBar5Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(headBar5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Customers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(66, 66, 66))))
        );
        headBar5Layout.setVerticalGroup(
            headBar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headBar5Layout.createSequentialGroup()
                .addGroup(headBar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headBar5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(stockImg5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(headBar5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Customers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(headBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(headBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(headBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headBar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(headBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(headBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headBar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(259, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookLabel;
    private javax.swing.JLabel Customers;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JLabel SoldLabel;
    private javax.swing.JLabel StocksLabel;
    private javax.swing.JLabel WorthLabel;
    private javax.swing.JPanel headBar;
    private javax.swing.JPanel headBar1;
    private javax.swing.JPanel headBar2;
    private javax.swing.JPanel headBar3;
    private javax.swing.JPanel headBar4;
    private javax.swing.JPanel headBar5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel stockImg;
    private javax.swing.JLabel stockImg1;
    private javax.swing.JLabel stockImg2;
    private javax.swing.JLabel stockImg3;
    private javax.swing.JLabel stockImg4;
    private javax.swing.JLabel stockImg5;
    // End of variables declaration//GEN-END:variables
}
